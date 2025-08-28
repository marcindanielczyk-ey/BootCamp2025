package lambdaexpressions.exercise3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Blueberry", "Orange", "Jogurt", "Kiwi");

        List<String> filteredAndUppercase = strings.stream()
                .filter(s -> s.startsWith("J"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("String/Strings that start with the letter 'J'");

        for(String x : filteredAndUppercase) {
            System.out.println(x);
        }
    }
}