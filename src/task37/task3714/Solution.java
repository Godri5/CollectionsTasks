package task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("I",1);
        numbers.put("V",5);
        numbers.put("X",10);
        numbers.put("L",50);
        numbers.put("C",100);
        numbers.put("D",500);
        numbers.put("M",1000);
        s = s.replace("IV","IIII");
        s = s.replace("IX","VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");
        String[] romanNumbers = s.split("");
        int result = 0;
        for (String number : romanNumbers) {
            result += numbers.get(number);
        }
        return result;
    }
}
