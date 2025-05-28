import java.io.*;
import java.util.*;

class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[26];
        Arrays.fill(arr, -1);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);
            arr[a - 'a'] = b - 'a';
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);
            bw.write(find(a - 'a', b - 'a') ? "T\n" : "F\n");
        }

        bw.close();
        br.close();
    }

    static boolean find(int a, int b) {
        if (a == -1)
            return false;
        if (a == b)
            return true;
        return find(arr[a], b);
    }
}