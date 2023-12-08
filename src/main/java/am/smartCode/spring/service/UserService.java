package am.smartCode.spring.service;
import am.smartCode.spring.model.User;
import java.util.List;

public interface UserService {

    User register(User user);

    User login(String username, String password);

    User getById(Long id);

    List<User> getAll();

    void delete(Long id);
    User update(User user);
     User getByEmail(String email);
}
