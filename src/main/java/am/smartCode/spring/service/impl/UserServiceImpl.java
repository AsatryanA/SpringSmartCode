package am.smartCode.spring.service.impl;

import am.smartCode.spring.exceptions.UserNotFoundException;
import am.smartCode.spring.model.User;
import am.smartCode.spring.repository.UserRepository;
import am.smartCode.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User register(User user) {
        return userRepository.create(user);
    }

    @Override
    public User login(String username, String password) {
        User byEmail = userRepository.getByEmail(username);
        if (byEmail != null && byEmail.getPassword().equals(password)) {
            return byEmail;
        }
        throw new UserNotFoundException("Wrong username or password");
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.getById(id);
    }
    @Transactional
    public User update(User user){
        return userRepository.update(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
