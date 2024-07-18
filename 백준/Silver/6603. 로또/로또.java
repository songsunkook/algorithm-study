/*
    BAEKJOON 6603번 로또
    https://www.acmicpc.net/problem/6603

    추가 학습 내용
    - 

    복습 필요: o
    풀이 참고: 조금
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] used;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            arr = new int[N];
            used = new boolean[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            func(0, 0);
            bw.write("\n");
        }
        bw.close();
    }

    static void func(int idx, int n) throws IOException {
        if (n == 6) {
            for (int i = 0; i < N; i++) {
                if (used[i]) {
                    bw.write(arr[i] + " ");
                }
            }
            bw.write("\n");
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                func(i, n + 1);
                used[i] = false;
            }
        }
    }
}
