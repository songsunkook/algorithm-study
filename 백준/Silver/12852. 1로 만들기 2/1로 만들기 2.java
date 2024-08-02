/*
    BAEKJOON 12852번 1로 만들기 2
    https://www.acmicpc.net/problem/12852

    추가 학습 내용
    - 

    복습 필요: O
    풀이 참고: O
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int[] pre = new int[N + 1];
        d[1] = 0;
        pre[1] = 0;
        if (N >= 2) {
            d[2] = 1;
            pre[2] = 1;
        }
        for (int i = 3; i <= N; i++) {
            d[i] = d[i - 1] + 1;
            pre[i] = i - 1;
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
                pre[i] = i / 3;
            }
            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
                pre[i] = i / 2;
            }
        }
        bw.write(d[N] + "\n");
        bw.write(N + " ");
        for (
            int i = N;
            pre[i] != 0; i = pre[i]) {
            bw.write(pre[i] + " ");
        }
        bw.close();
    }
}
