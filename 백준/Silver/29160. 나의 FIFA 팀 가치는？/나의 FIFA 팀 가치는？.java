import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] qarr = new PriorityQueue[12];
        for (int i = 0; i < 12; i++) {
            qarr[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            qarr[p].offer(w);
        }

        long sum = -1;
        for (int y = 0; y <= year; y++) {
            sum = 0;
            for (int i = 1; i < 12; i++) {
                if (!qarr[i].isEmpty()) {
                    int cur = qarr[i].poll();
                    sum += cur;
                    qarr[i].offer(Math.max(1, cur - 1));
                }
            }
        }
        bw.write(sum + "");
        bw.close();
        br.close();
    }
}