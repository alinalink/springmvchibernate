package service;

import model.User;

import java.util.List;

public interface UserServise {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User getById(int id);

    User deleteUser(int id);
}
