import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

public class JunitMockitoTest {

    private static JunitMockito.PersonService mockService;
    private JunitMockito lesson;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Setting up before all tests: Creating mock service");
        mockService = Mockito.mock(JunitMockito.PersonService.class);
    }

    @BeforeEach
    void setUpEach() {
        System.out.println("Before test: Creating lesson instance");
        lesson = new JunitMockito(mockService);
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("After test: Resetting mock");
        reset(mockService);
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Final cleanup after all tests");
    }

    @Test
    void shouldFormatPersonInfoCorrectly() {
        String name = "Marcin";
        String company = "EY";
        int age = 26;
        boolean isCompanyEmployee = true;
        String expected = "My name is: Marcin, My company name is: EY, I am 26 years old, Am I company's employee?: true";

        String result = lesson.formatPersonInfo(name, company, age, isCompanyEmployee);
        assertEquals(expected, result);
    }

    @Test
    void shouldFormatPersonInfoWithDifferentData() {
        String name = "Anna";
        String company = "Google";
        int age = 30;
        boolean isCompanyEmployee = false;
        String expected = "My name is: Anna, My company name is: Google, I am 30 years old, Am I company's employee?: false";

        String result = lesson.formatPersonInfo(name, company, age, isCompanyEmployee);
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnPersonStatusUsingMockedService() {
        String name = "Marcin";
        when(mockService.isEmployed(name)).thenReturn(true);
        String expected = "Marcin is employed";

        String result = lesson.getPersonStatus(name);
        assertEquals(expected, result);
    }
}