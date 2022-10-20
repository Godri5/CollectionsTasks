package task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null)
            return 0;
        int maxLength = 0;
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (characters.size() > maxLength) {
                maxLength = characters.size();
            }
            characters.clear();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!characters.contains(c)) {
                    characters.add(c);
                } else 
                    break;
            }
        }
        return characters.size() > maxLength ? characters.size() : maxLength;
    }
}
