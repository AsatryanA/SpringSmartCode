package am.smartCode.spring;


import am.smartCode.spring.model.User;
import am.smartCode.spring.repository.UserRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
    }
}
