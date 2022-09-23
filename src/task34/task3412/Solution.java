package task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        try {
            this.value1 = value1;
            this.value2 = value2;
            this.value3 = value3;
        } catch (Exception e) {
            logger.debug("Unknown error", e);
        }
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        try {
            value -= 133;
            if (value > Integer.MAX_VALUE) {
                value1 = (int) (value / Integer.MAX_VALUE);
            } else {
                value1 = (int) value;
            }
        } catch (Exception e) {
            logger.trace("Unknown error", e);
            logger.debug("Unknown error", e);
        }
    }

    public void printString() {
        try {
            if (value2 != null) {
                System.out.println(value2.length());
            }
        } catch (Exception e) {
            logger.trace("Unknown error", e);
        }
    }

    public void printDateAsLong() {
        try {
            if (value3 != null) {
                System.out.println(value3.getTime());
            }
        } catch (Exception e) {
            logger.trace("Unknown error", e);
        }
    }

    public void divide(int number1, int number2) {
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.trace("Unknown error", e);
            logger.debug("Unknown error", e);
            logger.error("Unknown error", e);
        }
    }

    public void setValue1(int value1) {
        try {
            this.value1 = value1;
        } catch (Exception e) {
            logger.debug("Unknown error", e);
        }
    }

    public void setValue2(String value2) {
        try {
            this.value2 = value2;
        } catch (Exception e) {
            logger.debug("Unknown error", e);
        }
    }

    public void setValue3(Date value3) {
        try {
            this.value3 = value3;
        } catch (Exception e) {
            logger.debug("Unknown error", e);
        }
    }
}
