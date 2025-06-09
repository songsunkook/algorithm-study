import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        N[] arr = new N[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new N(b, c);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.s, b.s));

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(arr[0].e);
        // int max = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i].s >= q.peek()) {
                q.poll();
            }
            q.offer(arr[i].e);
            // max = Math.max(max, q.size());
        }

        // bw.write(max + "");
        bw.write(q.size() + "");
        bw.close();
        br.close();
    }

    static class N {
        int s;
        int e;

        N(int ss, int ee) {
            s = ss;
            e = ee;
        }
    }
}