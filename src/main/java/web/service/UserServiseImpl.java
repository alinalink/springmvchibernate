package web.service;

import web.dao.UserDAO;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiseImpl implements UserServise {

    private final UserDAO userDAO;

    @Autowired
    public UserServiseImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public User deleteUser(int id) {
        return userDAO.deleteUser(id);
    }
}
