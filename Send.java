package correcter;

import java.io.*;
import java.util.Arrays;

public class Send {
    public void sendText() throws IOException {
    /*For the encode, you can read all the bytes as
      String using the Files.readAllBytes class and
      get a byte array from the string.*/
/*        byte[] byteArr = Files
                .readAllBytes(Path.of("/Users/Lisa/Desktop/Error/encoded.txt"));
        for (int i = 0; i < byteArr.length; i++) {
            System.out.println(Integer.toBinaryString(byteArr[i]));
        }*/

        String bin = "";
        try (FileInputStream reader = new FileInputStream("encoded.txt")) {
            int num = reader.read();
            while (num != -1){
                bin += String.format("%8s", Integer.toBinaryString(num))
                        .replace(" ", "0") + " ";
                num = reader.read();
            }
        }
        String[] binArr = bin.split(" ");
        int[] arr = new int[bin.split(" ").length];

        FileOutputStream outputStream = new FileOutputStream("received.txt", false);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(binArr[i], 2) ^ (2 << 1);
            outputStream.write((byte) arr[i]);
        }
        outputStream.close();

        String received = "";
        for (int i = 0; i < arr.length; i++) {
            received += String.format("%8s", Integer.toBinaryString(arr[i]))
                    .replace(" ", "0") + " ";
        }

/*        System.out.println("Bin array: " + Arrays.toString(arr));
        System.out.println("Bin view: " + bin);
        System.out.println("Bin received: " + received);*/
    }
}
