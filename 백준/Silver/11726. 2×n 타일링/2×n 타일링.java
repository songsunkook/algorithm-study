/*
    BAEKJOON 11726번 2×n 타일링
    https://www.acmicpc.net/problem/11726

    추가 학습 내용
    - 

    복습 필요: o
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        d[1] = 1;
        if (n >= 2) d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        System.out.print(d[n]);
    }
}
