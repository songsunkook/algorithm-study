/*
    BAEKJOON 2156번 포도주 시식
    https://www.acmicpc.net/problem/2156

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
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] d = new int[n + 1][3];
        d[1][1] = arr[1];
        d[1][2] = 0;
        if (n >= 2) {
            d[2][1] = arr[2];
            d[2][2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= n; i++) {
            d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
            d[i][1] = Math.max(d[i - 1][0], Math.max(d[i - 2][1], d[i - 2][2])) + arr[i];
            d[i][2] = d[i - 1][1] + arr[i];
        }
        int a = Math.max(d[n - 1][1], d[n - 1][2]);
        int b = Math.max(d[n][1], d[n][2]);
        System.out.print(Math.max(a, b));
    }
}
