package correcter;

import java.io.IOException;

public class Decode {
    public void decodeText() throws IOException {
        String receivedTxt = Main.inputFile("received.txt");
        String replaceError = Send.putReplaceOneBitError(receivedTxt.split(" "));
        String decodedTxt = decode(replaceError.replaceAll(" ","").split(""));
        Main.outputFile(decodedTxt.split(" "), "decoded.txt");

        System.out.println("\nreceived.txt:");
        System.out.println("bin view: " + receivedTxt);
        System.out.println("\ndecoded:");
        System.out.println("correct: " + replaceError);
        System.out.println("decode: " + decodedTxt);
    }
    static String decode (String[] s) {
        String decoded = "";
        for (int i = 0; i < s.length; i += 8) {
            String dByte = s[i + 2] + s[i + 4] + s[i + 5] + s[i + 6];
            decoded += i % 16 == 0 && i != 0 ? " " + dByte : dByte;
        }
        return decoded;
    }
}
