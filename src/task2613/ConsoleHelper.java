package task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static Operation operation;

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = bis.readLine();
            if ("exit".equals(result.toLowerCase())) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }


    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode;
        while (true) {
            currencyCode = readString();
            if (currencyCode == null || currencyCode.trim().length() != 3) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            return currencyCode.trim().toUpperCase();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage(res.getString("choose.denomination.and.count.format"));
        while (true) {
            String s = ConsoleHelper.readString();
            String[] split = null;
            if (s == null || (split = s.split(" ")).length != 2) {
                writeMessage(res.getString("invalid.data"));
            } else {
                try {
                    if (Integer.parseInt(split[0]) <= 0 || Integer.parseInt(split[1]) <= 0)
                        writeMessage(res.getString("invalid.data"));
                } catch (NumberFormatException e) {
                    writeMessage(res.getString("invalid.data"));
                    continue;
                }
                return split;
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        int operationCode;
        try {
            while (true) {
                if ((operationCode = Integer.parseInt(bis.readLine())) > 4) {
                    writeMessage(res.getString("invalid.data"));
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
