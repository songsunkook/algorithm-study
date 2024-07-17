/*
    BAEKJOON 9663번 N-Queen
    https://www.acmicpc.net/problem/9663

    추가 학습 내용
    - 

    복습 필요: O
    풀이 참고: O
*/

import java.io.*;

public class Main {

    static int N, count;
    static boolean[] usedW, used1, used2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        usedW = new boolean[N];
        used1 = new boolean[2 * N - 1];
        used2 = new boolean[2 * N - 1];
        func(0);
        System.out.print(count);
    }

    static void func(int n) {
        if (n == N) {
            count++;
            return;
        }
        for (int c = 0; c < N; c++) {
            if (!usedW[c] && !used1[n + c] && !used2[n - c + N - 1]) {
                usedW[c] = true;
                used1[n+c]=true;
                used2[n-c+N-1] = true;
                func(n+1);
                usedW[c] = false;
                used1[n+c]=false;
                used2[n-c+N-1] = false;
            }
        }
    }
}
