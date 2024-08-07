/*
    BAEKJOON 9095번 1, 2, 3 더하기
    https://www.acmicpc.net/problem/9095

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];
            dp[1] = 1;
            if (n >= 2) dp[2] = 2;
            if (n >= 3) dp[3] = 4;
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            System.out.println(dp[n]);
        }
    }
}
