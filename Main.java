package correcter;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("send.txt");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        sc.close();

        try {
            FileInputStream inputStream = new FileInputStream("send.txt");
            FileOutputStream outputStream = new FileOutputStream("received.txt", false);
            byte[] byteArr = new byte[str.length()];

            inputStream.read(byteArr);
            inputStream.close();

            for (int i = 0; i < byteArr.length; i++) {
                byteArr[i] = (byte) (byteArr[i] ^ 1 << 2);
            }

            outputStream.write(byteArr);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}