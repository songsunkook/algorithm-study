import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();

            if (line.equals("0"))
                break;

            int sum = 2 + line.length() - 1;
            for (var c : line.toCharArray()) {
                switch (c) {
                    case '1':
                        sum += 2;
                        break;
                    case '0':
                        sum += 4;
                        break;
                    default:
                        sum += 3;
                }
            }
            bw.write(sum + "\n");
        }

        bw.close();
        br.close();
    }
}