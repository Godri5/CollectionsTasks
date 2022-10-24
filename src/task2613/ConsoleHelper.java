package task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static Operation operation;

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = null;
        try {
            result = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String askCurrencyCode() {
        writeMessage("Enter currency code:");
        String currencyCode;
        while (true) {
            currencyCode = readString();
            if (currencyCode == null || currencyCode.trim().length() != 3) {
                writeMessage("Enter currency code once again");
                continue;
            }
            return currencyCode.trim().toUpperCase();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        writeMessage("Enter face value and number of banknotes");
        while (true) {
            String s = ConsoleHelper.readString();
            String[] split = null;
            if (s == null || (split = s.split(" ")).length != 2) {
                writeMessage("Enter face value and number of banknotes again");
            } else {
                try {
                    if (Integer.parseInt(split[0]) <= 0 || Integer.parseInt(split[1]) <= 0)
                        writeMessage("Specify valid data.");
                } catch (NumberFormatException e) {
                    writeMessage("Specify valid data.");
                    continue;
                }
                return split;
            }
        }
    }

    public static Operation askOperation() {
        writeMessage("Enter number of operation you want to commit");
        int operationCode;
        try {
            while (true) {
                if ((operationCode = Integer.parseInt(bis.readLine())) > 4) {
                    writeMessage("Specify valid data");
                    continue;
                } else {
                    operation = operation.getAllowableOperationByOrdinal(operationCode);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operation;
    }
}
