package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            UserService service = context.getBean(UserService.class);
            service.addTwoUsers(new User(1L, "Alicja"), new User(2L, "Bob"));
        }
    }
}