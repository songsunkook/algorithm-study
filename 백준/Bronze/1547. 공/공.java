import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[3];
        arr[0] = true;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            boolean tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
        int result = -1;
        for (int i = 0; i < 3; i++) {
            if (arr[i])
                result = i + 1;
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }
}