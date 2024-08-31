package az.code.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtil {
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        return text;
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

    public static BigDecimal inputBigDecimal() {
        Scanner scanner = new Scanner(System.in);
        BigDecimal value = scanner.nextBigDecimal();
        return value;
    }

    public static Long inputLong() {
        Scanner scanner = new Scanner(System.in);
        Long value = scanner.nextLong();
        return value;
    }

}
