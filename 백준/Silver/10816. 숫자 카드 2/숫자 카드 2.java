import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] p;
    static List<String> people;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> cards = new HashMap<>(N);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (cards.containsKey(input)) {
                cards.put(input, cards.get(input) + 1);
            } else {
                cards.put(input, 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (cards.containsKey(input)) {
                bw.write(Integer.toString(cards.get(input)) + " ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
