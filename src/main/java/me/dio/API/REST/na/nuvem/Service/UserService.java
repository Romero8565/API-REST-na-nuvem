package me.dio.API.REST.na.nuvem.Service;

import me.dio.API.REST.na.nuvem.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User createUser(User user);

    List<User> getUsers();

    void deleteUser(Long id);

    User updateUser(Long id, User user);
}
