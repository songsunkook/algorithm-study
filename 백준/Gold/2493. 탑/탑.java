import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        stack.push(new Pair(1, Integer.parseInt(st.nextToken())));
        bw.write("0 ");
        for (int i = 1; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (stack.peek().h <= h) {
                while (!stack.isEmpty() && stack.peek().h <= h) {
                    stack.pop();
                }
            }
            if (stack.isEmpty())
                bw.write("0 ");
            else
                bw.write(stack.peek().pos + " ");

            stack.push(new Pair(i + 1, h));
        }

        bw.close();
        br.close();
    }

    static class Pair {
        int pos;
        int h;

        public Pair(int pos, int h) {
            this.pos = pos;
            this.h = h;
        }
    }
}