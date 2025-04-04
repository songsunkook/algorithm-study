import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int i = 666;
        int count = 0;
        while (count < n) {
            if (String.valueOf(i).contains("666"))
                count++;
            i++;
        }
        bw.write(i - 1 + "");

        bw.close();
        br.close();
    }
}