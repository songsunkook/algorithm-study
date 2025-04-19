import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            switch (a) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if (stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.pop() + "\n");
                    break;
                case 3:
                    bw.write(stack.size() + "\n");
                    break;
                case 4:
                    bw.write(stack.isEmpty() ? "1\n" : "0\n");
                    break;
                case 5:
                    if (stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.peek() + "\n");
                    break;
            }
        }

        bw.close();
        br.close();
    }
}