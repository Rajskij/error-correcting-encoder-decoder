package correcter;

import java.io.IOException;

public class Send {
    public void sendText() throws IOException {
        String encodedTxt = Main.inputFile("encoded.txt");
        String receivedTxt = putReplaceOneBitError(encodedTxt.split(" "));
        Main.outputFile(receivedTxt.split(" "), "received.txt");

        System.out.println("\nencoded.txt:");
        System.out.println("bin view: " + encodedTxt);
        System.out.println("\nreceived.txt");
        System.out.println("new view: " + receivedTxt);
    }
    static String putReplaceOneBitError(String[] s) {
        String str = "";
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i], 2) ^ (2 << 1);
            str += String.format("%8s", Integer.toBinaryString(arr[i]))
                    .replace(" ", "0") + " ";
        }
        return str;
    }
}
