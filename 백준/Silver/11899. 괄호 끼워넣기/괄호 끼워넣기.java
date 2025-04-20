import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '(')
                stack.push(1);
            if (c == ')') {
                if (stack.isEmpty())
                    count++;
                else
                    stack.pop();
            }
        }
        count += stack.size();
        bw.write(count + "");
        bw.close();
        br.close();
    }
}