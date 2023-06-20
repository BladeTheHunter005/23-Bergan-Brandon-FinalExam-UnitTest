public class StringCalculator {
    public static int add(String numbers) throws IllegalArgumentException {
        int returnValue = 0;
        String[] numbersArray = numbers.split(",|\n");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        } else {
            StringBuilder negativeNumbers = new StringBuilder();
            for (String number : numbersArray) {
                if (!number.trim().isEmpty()) {
                    try {
                        int num = Integer.parseInt(number.trim());
                        if (num < 0) {
                            if (negativeNumbers.length() > 0) {
                                negativeNumbers.append(", ");
                            }
                            negativeNumbers.append(num);
                        } else if (num <= 1000) {
                            returnValue += num;
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Only integers are allowed.");
                    }
                }
            }
            if (negativeNumbers.length() > 0) {
                throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers.toString());
            }
        }
        return returnValue;
    }
}