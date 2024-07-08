package me.dio.API.REST.na.nuvem.Service.impl;

import me.dio.API.REST.na.nuvem.Service.UserService;
import me.dio.API.REST.na.nuvem.domain.model.User;
import me.dio.API.REST.na.nuvem.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User createUser(User user) {
        if(user.getId() != null  && userRepository.existsById(user.getId())){
            throw new IllegalArgumentException("User already exists");
        } else if(userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("Account number already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if(user != null) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        User userExists = userRepository.findById(id).orElseThrow(NoSuchElementException::new);

        if(userExists != null) {
            userExists.setName(user.getName());
            userExists.setAccount(user.getAccount());

            userRepository.save(userExists);

        }

        return userExists;
    }

}
