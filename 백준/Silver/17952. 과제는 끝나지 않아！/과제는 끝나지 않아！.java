import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<H> stack = new Stack<>();
        int now = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            switch (type) {
                case 0:
                    break;
                case 1:
                    int a = Integer.parseInt(st.nextToken());
                    int t = Integer.parseInt(st.nextToken());
                    if (!stack.isEmpty()) {
                        stack.peek().cur = now;
                        now = 0;
                    }
                    stack.push(new H(a, t));
                    break;
            }
            now++;
            if (!stack.isEmpty() && stack.peek().t <= now) {
                var before = stack.pop();
                result += before.a;
                now = before.cur + 1;
            }
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }

    static class H {
        int a;
        int t;
        int cur;

        H(int c, int d) {
            a = c;
            t = d;
            cur = 0;
        }
    }
}