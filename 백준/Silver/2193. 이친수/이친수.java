/*
    BAEKJOON 2193번 이친수
    https://www.acmicpc.net/problem/2193

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new long[N + 1][2];
        d[1][0] = 0;
        d[1][1] = 1;
        if (N >= 2) {
            d[2][0] = 1;
            d[2][1] = 0;
        }
        for (int i = 3; i <= N; i++) {
            d[i][0] = d[i - 1][0] + d[i - 1][1];
            d[i][1] = d[i - 1][0];
        }
        System.out.print(d[N][0] + d[N][1]);
    }
}
