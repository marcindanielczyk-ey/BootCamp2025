public class JunitMockito {
    private final PersonService personService;

    public JunitMockito(PersonService personService) {
        this.personService = personService;
    }

    public String formatPersonInfo(String name, String company, int age, boolean isCompanyEmployee) {
        return "My name is: " + name + ", My company name is: " + company +
                ", I am " + age + " years old, Am I company's employee?: " + isCompanyEmployee;
    }

    public String getPersonStatus(String name) {
        boolean isEmployed = personService.isEmployed(name);
        return name + " is " + (isEmployed ? "employed" : "not employed");
    }

    public interface PersonService {
        boolean isEmployed(String name);
    }
}