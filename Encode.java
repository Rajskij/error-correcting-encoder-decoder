package correcter;

import java.io.*;
import java.util.Arrays;

public class Encode {
    public void encodeText() throws IOException {

        FileReader file = new FileReader("send.txt");
        String str;
        try (BufferedReader bufferedReader = new BufferedReader(file)) {
            str = bufferedReader.readLine();

        }

        String bin = "";
        String hex = "";
        try (FileInputStream reader = new FileInputStream("send.txt")) {
            int num = reader.read();
            while (num != -1) {
                bin += String.format("%8s", Integer.toBinaryString(num))
                        .replace(" ", "0");
                hex += Integer.toHexString(num) + " ";
                num = reader.read();
            }
        }
        int[] arr = new int[bin.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(Character.toString(bin.charAt(i)));
        }
        String parity = "";
        for (int i = 0; i < arr.length; i++) {
            if (i % 3 == 0 && i != 0) {
                int n = (arr[i - 3] ^ arr[i - 2] ^ arr[i - 1]);
                parity += "" + n + n + " ";
            }
            parity += "" + arr[i] + arr[i];
        }
        String[] parityArr = parity.split(" ");

        int[] b = new int[parityArr.length];
        if (parityArr[parityArr.length - 1].length() == 6) {
            int x = arr[arr.length - 3] ^ arr[arr.length - 2] ^ arr[arr.length - 1];
            parityArr[parityArr.length - 1] = parityArr[parityArr.length - 1] + x + x;
        } else if (parityArr[parityArr.length - 1].length() == 4) {
            int x = 0;
            int y = arr[arr.length - 2] ^ arr[arr.length - 1] ^ x;
            parityArr[parityArr.length - 1] = parityArr[parityArr.length - 1] + "00" + y + y;
        }

        OutputStream outputStream = new FileOutputStream("encoded.txt", false);

        String hexEncode = "";

        for (int i = 0; i < parityArr.length; i++) {
            b[i] = (byte) Integer.parseInt(parityArr[i], 2);
            outputStream.write((byte) Integer.parseInt(parityArr[i], 2));
            hexEncode += Integer.toHexString(b[i]) + " ";
        }
        outputStream.close();

        System.out.println(new File("send.txt").getName());
        System.out.println("text view:(" + str + ")");
        System.out.println("hex view: " + hex);
        System.out.println("bin view: " + bin + " length: " + bin.length() + "\n");

        System.out.println(new File("encoded.txt").getName());
        System.out.println("parity: " + Arrays.toString(parityArr));
        System.out.println("int value: " + Arrays.toString(b));
        System.out.println("hex view: " + hexEncode);
    }
}
