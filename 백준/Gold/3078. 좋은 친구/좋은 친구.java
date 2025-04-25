import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, Queue<Integer>> map = new HashMap<>(20);
        for (int i = 2; i <= 20; i++) {
            map.put(i, new LinkedList<>());
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            int len = br.readLine().length();
            Queue<Integer> curMap = map.get(len);
            while (!curMap.isEmpty() && i - curMap.peek() > k) {
                curMap.poll();
            }
            result += curMap.size();
            // System.out.println("len: " + len + ", size(): " + curMap.size() + ", result: " + result + ", map: " + curMap);
            curMap.offer(i);
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }
}