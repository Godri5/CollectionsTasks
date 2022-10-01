package task36.task3602;

import java.util.Collections;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class clas : Collections.class.getDeclaredClasses()) {
            if (clas.getSimpleName().equals("EmptyList"))
                return clas;
        }
        return null;
    }
}
