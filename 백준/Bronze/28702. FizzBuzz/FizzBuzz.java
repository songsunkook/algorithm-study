import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        for (int i = 3; i > 0; i--) {
            String n = br.readLine();
            if (!n.equals("Fizz")
                    && !n.equals("Buzz")
                    && !n.equals("FizzBuzz")) {
                result = Integer.parseInt(n) + i;
            }
        }
        bw.write(toFB(result));

        bw.close();
        br.close();
    }

    static String toFB(int n) {
        if (n % 3 == 0 && n % 5 == 0)
            return "FizzBuzz";
        if (n % 3 == 0)
            return "Fizz";
        if (n % 5 == 0)
            return "Buzz";
        return String.valueOf(n);
    }
}