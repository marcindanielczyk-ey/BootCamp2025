package cleancodepatterns;

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

    public final String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public final  String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public final int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "daniel{id='" + id + "', name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}
