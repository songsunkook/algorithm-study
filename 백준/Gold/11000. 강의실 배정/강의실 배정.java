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
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new N(s, e);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.s, b.s));

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(arr[0].e);

        for (int i = 1; i < n; i++) {
            if (q.peek() <= arr[i].s) {
                q.poll();
            }
            q.offer(arr[i].e);
        }

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