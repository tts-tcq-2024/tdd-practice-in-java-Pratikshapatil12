package TddPracticeInJava;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;

        String[] numbers = extractNumbers(input);
        validateNumbers(numbers);

        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num <= 1000) sum += num;
        }
        return sum;
    }

    private String[] extractNumbers(String input) {
        String delimiter = getDelimiter(input);
        String numbersPart = getNumbersPart(input);
        return numbersPart.split("[,\n" + delimiter + "]");
    }

    private String getDelimiter(String input) {
        if (input.startsWith("//")) {
            return input.split("\n")[0].substring(2);
        }
        return ",";
    }

    private String getNumbersPart(String input) {
        if (input.startsWith("//")) {
            return input.split("\n", 2)[1];
        }
        return input;
    }

    private void validateNumbers(String[] numbers) {
        List<Integer> negatives = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) negatives.add(num);
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }
    }
}


