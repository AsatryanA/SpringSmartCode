package am.smartCode.spring.repository;


import am.smartCode.spring.model.User;

import java.util.List;

public interface UserRepository {

    User create(User user);

    void delete(Long id);

    User getByEmail(String email);

    User update(User user);

    User getById(Long id);

    List<User> getAll();


}
