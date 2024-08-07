/*
    BAEKJOON 15988번 1, 2, 3 더하기 3
    https://www.acmicpc.net/problem/15988

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
        int T = Integer.parseInt(br.readLine());
        int[] N = new int[T];
        int max = 0;
        for (int t = 0; t < T; t++) {
            N[t] = Integer.parseInt(br.readLine());
            max = Math.max(max, N[t]);
        }
        long[] d = new long[max + 1];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        long mod = 1000000009;
        for (int i = 4; i <= max; i++) {
            d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % mod;
        }
        for (int t = 0; t < T; t++) {
            bw.write((d[N[t]] % mod) + "\n");
        }
        bw.close();
    }
}
