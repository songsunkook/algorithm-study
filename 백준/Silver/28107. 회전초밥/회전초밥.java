import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] eatCount = new int[n];
        Map<Integer, Queue<Integer>> wish = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int sushi = Integer.parseInt(st.nextToken());
                if (!wish.containsKey(sushi))
                    wish.put(sushi, new LinkedList<>());
                wish.get(sushi).add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < m; t++) {
            int sushi = Integer.parseInt(st.nextToken());
            if (wish.get(sushi) != null) {
                Integer per = wish.get(sushi).poll();
                if (per != null) {
                    eatCount[per]++;
                }
            }
        }

        for (int i = 0; i < n; i++)
            bw.write(eatCount[i] + " ");

        bw.close();
        br.close();
    }
}