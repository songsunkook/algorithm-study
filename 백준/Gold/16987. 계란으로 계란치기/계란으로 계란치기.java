/*
    BAEKJOON 16987번 계란으로 계란치기
    https://www.acmicpc.net/problem/16987

    추가 학습 내용
    - 

    복습 필요: -
    풀이 참고: 조금
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] egg;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        egg = new int[N][2];
        max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken());
            egg[i][1] = Integer.parseInt(st.nextToken());
        }
        func(0);
        System.out.print(max);
    }

    static void func(int idx) {
        if (idx == N) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (egg[i][0] <= 0) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }
        if (egg[idx][0] <= 0) {
            func(idx + 1);
            return;
        }
        boolean allBreak = false;
        for (int i = 0; i < N; i++) {
            if (i == idx || egg[i][0] <= 0) {
                continue;
            }
            int temp = 0;
            egg[i][0] -= egg[idx][1];
            egg[idx][0] -= egg[i][1];
            func(idx + 1);
            egg[i][0] += egg[idx][1];
            egg[idx][0] += egg[i][1];
            allBreak = true;
        }
        if (!allBreak) {
            func(idx + 1);
        }
    }
}
