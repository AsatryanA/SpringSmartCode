package am.smartCode.spring.repository.impl;

import am.smartCode.spring.model.User;
import am.smartCode.spring.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        try (var session = sessionFactory.openSession()) {
            session.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return user;
    }

    @Override
    public void delete(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getByEmail(String email) {
        sessionFactory.openSession().createQuery("from User where email = :email")
                .setParameter("email", email).uniqueResult();
        return null;
    }

    @Override
    public User update(User user) {
        try (var session = sessionFactory.openSession()) {
            session.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getById(Long id) {
        try (var session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("from User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
