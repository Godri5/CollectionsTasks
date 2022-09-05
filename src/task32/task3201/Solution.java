package task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.valueOf(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        if (number < raf.length()){
            raf.seek(number);
        } else {
            raf.seek(raf.length());
        }

        raf.write(text.getBytes(Charset.defaultCharset()));
    }
}
