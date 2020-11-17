package correcter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decode {
    public void decodeText() throws IOException {
        FileInputStream inputStream = new FileInputStream("received.txt");
        int n = inputStream.read();
        String bin = "";
        while (n != -1) {
            bin += String.format("%8s", Integer.toBinaryString(n))
                    .replace(" ", "0") + " ";
            n = inputStream.read();
        }
        String[] binArr = bin.split(" ");
        int[] arr = new int[bin.split(" ").length];

        FileOutputStream outputStream = new FileOutputStream("decoded.txt", false);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(binArr[i], 2) ^ (2 << 1);
        }
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += String.format("%8s", Integer.toBinaryString(arr[i]))
                    .replace(" ", "0")
                    .replaceAll("[0]{2}", "0")
                    .replaceAll("[1]{2}", "1").substring(0,3);

        }
        String[] d = str.split("");
        String decode = "";
        for (int i = 0; i < str.length() - (str.length() % 8); i++) {
            if (i % 8 == 0 && i != 0) {
                decode += " " + d[i];
            }
            decode += d[i];
        }
        d = decode.split(" ");
        for (int i = 0; i < d.length; i++) {
            outputStream.write((byte) Integer.parseInt(d[i],2));
        }
        outputStream.close();

        System.out.println("bin view: " + bin);
        System.out.println("correct: " + str);
        System.out.println("decoded: " + d);
        System.out.println("d:_" + decode  + "_");
    }
}
