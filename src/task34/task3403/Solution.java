package task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {

    public void recurse(int n) {
        int prime = 2;
        while (prime <= n) {
            if (n % prime == 0) {
                if (prime != n) {
                    System.out.println(prime + " ");
                    recurse(n / prime);
                } else {
                    System.out.println(prime);
                }
                return;
            }
            prime++;
        }
    }
}
