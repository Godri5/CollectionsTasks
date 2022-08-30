package task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File result = new File(args[0]);
        if (!result.exists()) {
            result.createNewFile();
        }
        List<FileInputStream> in = new ArrayList<>();
        
        List<String> fileNames = new ArrayList<>();
        fileNames.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);
        
        for (String name : fileNames) {
            in.add(new FileInputStream(name));
        }
        
        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(in))))
        {
            while (true) {
                ZipEntry entry = is.getNextEntry();
                if (entry == null) break;
                
                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(result))) {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                }
            }
        }
    }
}
