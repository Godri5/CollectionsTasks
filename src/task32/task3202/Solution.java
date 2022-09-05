package task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if (is != null) {
            char[] buff = new char[1024];
            try (Reader reader = new BufferedReader(new InputStreamReader(is))) {
                int n;
                while ((n = reader.read(buff)) != -1) {
                    sw.write(buff, 0, n);
                }
            }
        }
        return sw;
    }
}
