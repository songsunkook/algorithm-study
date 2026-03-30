import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        long sum = 0;
        while (pq.size() > 1) {
            int com = pq.poll() + pq.poll();
            sum += com;
            pq.offer(com);
        }
        bw.write(sum + "");
        bw.close();
        br.close();
    }
}