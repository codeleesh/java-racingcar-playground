package util;


import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int RESULT_NULL_OR_EMPTY = 0;
    private static final String COMMA_N_DELIMITER = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern COMMA_N_DELIMITER_PATTERN = Pattern.compile(COMMA_N_DELIMITER);
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_SEPARATOR);
    private static final int ONE_LENGTH = 1;

    public static int splitAndSum(final String str) {

        if (Objects.isNull(str) || str.isEmpty()) {
            return RESULT_NULL_OR_EMPTY;
        }
        if (str.length() == ONE_LENGTH) {
            return Integer.parseInt(str);
        }
        if (COMMA_N_DELIMITER_PATTERN.matcher(str).find()) {
            String[] tokens = str.split(COMMA_N_DELIMITER);
            return sum(tokens);
        }
        Matcher m = CUSTOM_PATTERN.matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return sum(tokens);
        }
        throw new RuntimeException("잘못 입력하였습니다.");
    }

    private static void validMinusNum(String str) {
        boolean result = Integer.parseInt(str) > 0;
        if (!result) {
            throw new RuntimeException("음수가 존재합니다.");
        }
    }

    private static int sum(final String[] strings) {
        int result = 0;
        for (String str : strings) {
            validMinusNum(str);
            result += Integer.parseInt(str);
        }
        return result;
    }
}
