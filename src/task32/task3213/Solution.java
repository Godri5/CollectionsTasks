package task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder sb = new StringBuilder();
        int char1;
        if (reader != null) {
            while ((char1 = reader.read()) != -1) {
                char ch = (char) char1;
                sb.append((char) (ch + key));
            }
        }
        return sb.toString();
    }
}
