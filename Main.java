package correcter;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        char[] text = sc.nextLine().toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < text.length; i += 3) {
            int randIndex = i + random.nextInt(3);
            if (randIndex < text.length) {
                text[randIndex] = alphabet.charAt(random.nextInt(61));
            }
        }
        System.out.println(new String(text));
    }
}
