import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input >= num) {
                while (input >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (input < stack.pop()) {
                    bw.write("NO");
                    bw.close();
                    br.close();
                    return;
                }
                sb.append("-\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}