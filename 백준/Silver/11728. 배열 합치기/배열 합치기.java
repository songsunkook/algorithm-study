/*
    BAEKJOON 11728번 배열 합치기
    https://www.acmicpc.net/problem/11728

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];
        C = new int[N + M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        int aIdx = 0, bIdx = 0, curIdx = 0;
        while (aIdx < N || bIdx < M) {
            if (aIdx >= N) {
                C[curIdx++]  = B[bIdx++];
                continue;
            }
            if (bIdx >= M) {
                C[curIdx++] = A[aIdx++];
                continue;
            }
            if (A[aIdx] >= B[bIdx]) {
                C[curIdx++] = B[bIdx++];
            } else {
                C[curIdx++] = A[aIdx++];
            }
        }
        for (int i = 0; i < N + M; i++) {
            bw.write(C[i] + " ");
        }
        bw.close();
    }
}
