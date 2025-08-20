import org.apache.commons.lang3.StringUtils;

public class ApacheCommonsLang {
    private String name;

    public ApacheCommonsLang(String name) {
        this.name = name;
    }

    public String getCapitalizedName() {
        return StringUtils.capitalize(name);
    }

    public static void main(String[] args) {
        ApacheCommonsLang formatter = new ApacheCommonsLang("marcin");
        System.out.println(formatter.getCapitalizedName());
    }

}
