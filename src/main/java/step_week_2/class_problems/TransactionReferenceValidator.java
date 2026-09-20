package step_week_2.class_problems;
public class TransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits only";
            }
        }
        String date = reference.substring(3, 9);
        StringBuilder result = new StringBuilder();
        result.append("[").append(reference.substring(0, 3)).append("] ");
        result.append("DATE: ").append(date.substring(0, 2)).append("/")
              .append(date.substring(2, 4)).append("/")
              .append(date.substring(4, 6));
        result.append(" | SEQ: ").append(reference.substring(9));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference(" hdf03022600042 ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }
}