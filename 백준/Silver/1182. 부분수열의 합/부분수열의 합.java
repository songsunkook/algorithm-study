import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //문제풀이
        backtracking(0, 0);
        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

    static void backtracking(int index, int sum) {
        if (index == N)
            return;
        if (sum + arr[index] == S)
            result++;
        backtracking(index + 1, sum);
        backtracking(index + 1, sum + arr[index]);
    }
}
