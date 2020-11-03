package correcter;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        char[] text = sc.nextLine().toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ0123456789";
        System.out.println(new String(text));

        char[] longText = new char[text.length * 3];
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < 3; j++) {
                longText[i * 3 + j] = text[i];
            }
        }
        System.out.println(new String(longText));

        for (int i = 0; i < longText.length; i += 3) {
            int randIndex = i + random.nextInt(3);
            if (randIndex < longText.length) {
                longText[randIndex] = alphabet.charAt(random.nextInt(61));
            }
        }
        System.out.println(longText);

        char[] txt = new char[longText.length / 3];
        for (int i = 0; i < txt.length; i++) {
            txt[i] = longText[i * 3] == longText[i * 3 + 1] ? longText[i * 3]
                    : longText[i * 3 + 1] == longText[i * 3 + 2] ? longText[i * 3 + 1]
                    : longText[i * 3 + 2];
        }
        System.out.println(new String(txt));
    }
}
