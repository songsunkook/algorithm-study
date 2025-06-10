import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> box = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            box.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int child = Integer.parseInt(st.nextToken());
            if (box.peek() < child) {
                bw.write("0");
                bw.close();
                br.close();
                return;
            }
            box.offer(box.poll() - child);
        }
        bw.write("1");
        bw.close();
        br.close();
    }
}