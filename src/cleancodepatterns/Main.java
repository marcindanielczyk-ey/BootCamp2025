package cleancodepatterns;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserProcessor processor = new UserProcessor(
                Arrays.asList(new FileUserStorage(), new MemoryUserStorage()),
                Arrays.asList(new EmailNotification(), new SmsNotification()),
                new UserInputHandler(),
                new UserValidator()
        );
        processor.processUser();
    }
}
