package cleancodepatterns;

class UserValidator implements UserValidatorInterface {
    @Override
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
