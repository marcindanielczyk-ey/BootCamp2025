
import java.util.*;
import java.io.*;

public class UserProcessor {

    private static final Map<String, User> inMemoryUserDatabase = new HashMap<>();

    public static void main(String[] args) {
        UserProcessor processor = new UserProcessor();
        processor.processUser();
    }

    public void processUser() {
        Scanner userInputField = new Scanner(System.in);
        System.out.println("Enter user name:");
        String userName = userInputField.nextLine();
        System.out.println("Enter user email:");
        String userEmail = userInputField.nextLine();
        System.out.println("Enter phone number:");
        String userPhoneNumber = userInputField.nextLine();
        System.out.println("Enter user age:");
        int userAge = userInputField.nextInt();
        if (userName == null || userName.isEmpty() || userName.length()  > 20 || !userName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid name");
            return;
        }

        if (userEmail == null || userEmail.isEmpty() || !userEmail.contains("@")) {
            System.out.println("Invalid email");
            return;
        }

        if (userPhoneNumber == null || userPhoneNumber.isEmpty()) {
            System.out.println("Invalid phone number");
            return;
        }

        if (userAge <= 18) {
            System.out.println("Invalid age");
            return;
        }
        String userId = UUID.randomUUID().toString();
        UserProcessor.User user = new UserProcessor.User(userId, userName, userEmail, userPhoneNumber, userAge);
        try {
            FileWriter writer = new FileWriter("user.log", true);
            writer.write("User created: " + user.toString() + "\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("save data in DB" + user.toString());
        inMemoryUserDatabase.put(user.getId(), user);

        System.out.println("sending email to client" + user.toString());
        System.out.println("sending sms to client" + user.toString());

        System.out.println("User processed successfully!");
    }

    public class User {
        private String id;
        private String name;
        private String email;
        private String phone;
        private int age;

        public User(String id, String name, String email, String phone,  int age) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.age = age;
            this.phone = phone;
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
        }}
}
