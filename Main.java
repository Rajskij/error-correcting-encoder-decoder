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
}