package correcter;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        switch (str) {
            case "encode":
                new Encode().encodeText();
                break;
            case "send":
                new Send().sendText();
                break;
            case "decode":
                new Decode().decodeText();
                break;
        }
    }
    public static String inputFile(String s) throws IOException {
        String str = "";
        try (FileInputStream reader = new FileInputStream(s)) {
            int num = reader.read();
            while (num != -1) {
                str += String.format("%8s", Integer.toBinaryString(num))
                        .replace(" ", "0") + " ";
                num = reader.read();
            }
        }
        return str;
    }

    public static void outputFile(String[] arr, String s) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(s, false)) {
            for (int i = 0; i < arr.length; i++) {
                outputStream.write((byte) Integer.parseInt(arr[i],2));
            }
        }
    }
}