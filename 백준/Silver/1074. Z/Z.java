/*
    BAEKJOON 1074번 Z
    https://www.acmicpc.net/problem/1074

    추가 학습 내용
    - 

    복습 필요: O
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.print(func(N, r, c));
    }

    static int func(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        /**
         * 1. 좌상 -> func(n-1)
         * 2. 우상 -> area * func(n-1)
         * 3. 좌하 -> 2 * area * func(n-1)
         * 4. 우하 -> 3 * area * func(n-1)
         */
        int half = 1 << (n - 1);
        if (r < half && c < half) return func(n - 1, r, c);
        if (r < half && c >= half) return half * half + func(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + func(n - 1, r - half, c);
        return 3 * half * half + func(n - 1, r - half, c - half);
    }
}
