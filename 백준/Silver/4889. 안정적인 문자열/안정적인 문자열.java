import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1;; t++) {
            String input = br.readLine();
            if (input.startsWith("-"))
                break;
            Stack<Integer> stack = new Stack<>();
            int count = 0;
            for (char c : input.toCharArray()) {
                if (c == '{')
                    stack.push(1);
                if (c == '}') {
                    if (stack.isEmpty()) {
                        count++;
                        stack.push(1);
                    } else {
                        stack.pop();
                    }
                }
            }
            count += stack.size() / 2;
            bw.write(t + ". " + count + "\n");
        }
        bw.close();
        br.close();
    }
}