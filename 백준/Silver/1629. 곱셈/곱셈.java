/*
    BAEKJOON 1629번 곱셈
    https://www.acmicpc.net/problem/1629

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        System.out.print(func(A, B, C));
    }

    static long func(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        long num = func(a, b / 2, c);
        num = num * num % c;
        if (b % 2 == 0) {
            return num;
        }
        return num * a % c;
    }
}
