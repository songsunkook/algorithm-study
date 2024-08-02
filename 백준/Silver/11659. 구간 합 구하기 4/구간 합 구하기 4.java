/*
    BAEKJOON 11659번 구간 합 구하기 4
    https://www.acmicpc.net/problem/11659

    추가 학습 내용
    - 

    복습 필요: o
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] num;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N + 1];
        d = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        d[1] = num[1];
        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + num[i];
        }
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write((d[e] - d[s - 1]) + "\n");
        }
        bw.close();
    }
}
