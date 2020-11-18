package correcter;

import java.io.IOException;

public class Encode {
    public void encodeText() throws IOException {
        String sendTxt = Main.inputFile("send.txt");
        String[] sendTxtArr = sendTxt.replaceAll(" ", "").split("");
        String[] encodedTxtArr = encode(sendTxtArr).split(" ");
        Main.outputFile(encodedTxtArr,"encoded.txt");

        System.out.println("bin view: " + sendTxt);
        System.out.println("\nencoded.txt:");
        System.out.println("parity: " + encode(sendTxtArr));
    }
    static String encode(String[] s) {
        String parity = "";
        for (int i = 0; i < s.length; i += 4) {
            int n3 = Integer.parseInt(s[i]);
            int n5 = Integer.parseInt(s[i + 1]);
            int n6 = Integer.parseInt(s[i + 2]);
            int n7 = Integer.parseInt(s[i + 3]);
            int n8 = 0;

            int n1 = n3 ^ n5 ^ n7;
            int n2 = n3 ^ n6 ^ n7;
            int n4 = n5 ^ n6 ^ n7;

            parity += "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + " ";
        }
        return parity;
    }
}

