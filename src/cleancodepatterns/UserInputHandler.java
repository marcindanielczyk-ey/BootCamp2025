package cleancodepatterns;

import java.util.Scanner;

class UserInputHandler implements UserInputInterface {
    @Override
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
