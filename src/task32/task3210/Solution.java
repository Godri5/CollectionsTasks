package task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException{
        String fileName = args[0];
        Long number = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        raf.seek(number);

        byte[] texts = new byte[text.length()];
        raf.read(texts, 0, text.length());
        String readText = new String(texts);

        raf.seek(raf.length());
        if (readText.equals(text)) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }
    }
}
