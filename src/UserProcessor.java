import java.util.*;
import java.io.*;

public class UserProcessor {

    public static void main(String[] args) {
        UserProcessor processor = new UserProcessor();
        processor.processUser();
    }

    public void processUser() {
        UserInputHandler inputHandler = new UserInputHandler();
        UserData data = inputHandler.getUserData();

        UserValidator validator = new UserValidator();
        if (!validator.validate(data)) {
            return;
        }

        String userId = UUID.randomUUID().toString();
        User user = new User(userId, data.name, data.email, data.phone, data.age);

        UserStorage storage = new UserStorage();
        storage.saveToFile(user);
        storage.saveToMemory(user);

        NotificationService notifier = new NotificationService();
        notifier.sendEmail(user);
        notifier.sendSms(user);

        System.out.println("User processed successfully!");
    }
}

class UserInputHandler {
    public UserData getUserData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        System.out.println("Enter user email:");
        String email = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();
        System.out.println("Enter user age:");
        int age = scanner.nextInt();
        return new UserData(name, email, phone, age);
    }
}

class UserData {
    String name;
    String email;
    String phone;
    int age;

    public UserData(String name, String email, String phone, int age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }
}

class UserValidator {
    public boolean validate(UserData data) {
        if (data.name == null || data.name.isEmpty() || data.name.length() > 20 || !data.name.matches("[a-zA-Z]+")) {
            System.out.println("Invalid name");
            return false;
        }
        if (data.email == null || data.email.isEmpty() || !data.email.contains("@")) {
            System.out.println("Invalid email");
            return false;
        }
        if (data.phone == null || data.phone.isEmpty()) {
            System.out.println("Invalid phone number");
            return false;
        }
        if (data.age <= 18) {
            System.out.println("Invalid age");
            return false;
        }
        return true;
    }
}

class UserStorage {
    private static final Map<String, User> inMemoryUserDatabase = new HashMap<>();

    public void saveToFile(User user) {
        try {
            FileWriter writer = new FileWriter("user.log", true);
            writer.write("User created: " + user.toString() + "\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveToMemory(User user) {
        inMemoryUserDatabase.put(user.getId(), user);
    }
}

class NotificationService {
    public void sendEmail(User user) {
        System.out.println("sending email to client " + user.toString());
    }

    public void sendSms(User user) {
        System.out.println("sending sms to client " + user.toString());
    }
}

class User {
    private String id;
    private String name;
    private String email;
    private String phone;
    private int age;

    public User(String id, String name, String email, String phone, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}