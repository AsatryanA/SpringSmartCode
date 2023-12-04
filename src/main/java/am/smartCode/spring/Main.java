package am.smartCode.spring;


import am.smartCode.spring.model.User;
import am.smartCode.spring.repository.UserRepository;
import am.smartCode.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var userService = context.getBean(UserService.class);
        User register = userService.register(User.builder()
                .age(20)
                .email("aaaaahj@gmail.com")
                .firstName("aaaaa")
                .lastName("aaaaa")
                .password("aaaaa")
                .build());
        System.out.println(register);
        System.out.println(userService.getAll());
    }
}
