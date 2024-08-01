/*
    BAEKJOON 2579번 계단 오르기
    https://www.acmicpc.net/problem/2579

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] score;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new int[N + 1][3];
        score = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        d[1][1] = score[1];
        d[1][2] = -100000;
        if (N >= 2) {
            d[2][1] = score[2];
            d[2][2] = score[1] + score[2];
        }
        for (int i = 3; i <= N; i++) {
            d[i][1] = Math.max(d[i - 2][1], d[i - 2][2]) + score[i];
            d[i][2] = d[i - 1][1] + score[i];
        }
        System.out.print(Math.max(d[N][1], d[N][2]));
    }
}
