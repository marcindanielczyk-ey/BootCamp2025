package lambdaexpressions.exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Exercise1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, 0, 1, 2, 3, 4, 5, 6, 7, 11, 13, 15);


        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };

        System.out.println("Liczby pierwsze:");
        numbers.stream()
                .filter(isPrime)
                .forEach(n -> System.out.println(n));
    }
}
