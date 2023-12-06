package am.smartCode.spring.repository.impl;

import am.smartCode.spring.model.User;
import am.smartCode.spring.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public User getByEmail(String email) {
        sessionFactory.getCurrentSession().createQuery("from User where email = :email")
                .setParameter("email", email).uniqueResult();
        return null;
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return sessionFactory.openSession().createQuery("from User").list();
    }
}
