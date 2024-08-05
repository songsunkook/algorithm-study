/*
    BAEKJOON 14501번 퇴사
    https://www.acmicpc.net/problem/14501

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
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] d = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        d[0] = 0;
        for (int i = 1; i <= N; i++) {
            if (i + T[i] <= N + 1) {
                d[i + T[i]] = Math.max(d[i + T[i]], d[i] + P[i]);
            }
            d[i + 1] = Math.max(d[i], d[i + 1]);
        }
        System.out.print(d[N + 1]);
    }
}
