import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<N> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().n < a) {
                N p = stack.pop();
                ans[p.i] = a;
            }
            stack.push(new N(a, i));
        }
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }

        bw.close();
        br.close();
    }

    static class N {
        int n;
        int i;

        N(int nn, int ii) {
            n = nn;
            i = ii;
        }
    }
}