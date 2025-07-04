import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];
        arr[0] = Integer.parseInt(br.readLine());
        arr[1] = Integer.parseInt(br.readLine());
        arr[2] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        bw.write(arr[1] + "");

        bw.close();
        br.close();
    }
}