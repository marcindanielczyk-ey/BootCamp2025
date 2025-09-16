public class ClassConstructorMethods {
    private String name;
    private int age;

    public ClassConstructorMethods(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String welcomeText() {
        return "Hello, my name is " + name;
    }

    public static void main(String[] args) {
        ClassConstructorMethods classConstructorMethods = new ClassConstructorMethods("Marcin", 26);
        System.out.println(classConstructorMethods.welcomeText());
        System.out.println("Is adult? " + classConstructorMethods.isAdult());
    }
}
