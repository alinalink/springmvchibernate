package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    public UserDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select users from User users", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User deleteUser(int id){
        User user = getById(id);
        entityManager.remove(user);
        return user;
    }
}
