import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(br.readLine()));
        }

        if (q.peek() < h) {
            bw.write("YES\n0");
            bw.close();
            br.close();
            return;
        }

        int result = 0;
        for (int i = 0; i < t; i++) {
            int mid = Math.max(q.poll() / 2, 1);
            q.offer(mid);
            if (q.peek() < h) {
                result = i + 1;
                break;
            }
        }

        bw.write(q.peek() >= h ? "NO\n" : "YES\n");
        if (q.peek() >= h)
            bw.write(q.peek() + "");
        else
            bw.write(result + "");
        bw.close();
        br.close();
    }
}