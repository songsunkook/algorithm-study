import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        @SuppressWarnings("unchecked")
        Queue<String>[] sen = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sen[i] = new LinkedList<>();
            while (st.hasMoreTokens()) {
                sen[i].offer(st.nextToken());
            }
        }

        boolean result = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            boolean can = false;
            String input = st.nextToken();
            for (int i = 0; i < n; i++) {
                if (input.equals(sen[i].peek())) {
                    sen[i].poll();
                    can = true;
                    break;
                }
            }
            if (!can) {
                result = false;
                break;
            }
        }
        for (int i = 0; i < n; i++)
            if (!sen[i].isEmpty())
                result = false;
        bw.write(result ? "Possible" : "Impossible");

        bw.close();
        br.close();
    }
}