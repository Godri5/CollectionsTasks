package task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object x = new Integer(0);
        System.out.println((String)x);

    }

    public void methodThrowsNullPointerException() {
        int[] arr = null;
        int i = arr.length;
    }

    public static void main(String[] args) {

    }
}
