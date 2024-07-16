/*
    BAEKJOON 2480번 주사위 세개
    https://www.acmicpc.net/problem/2480

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());
        a[2] = Integer.parseInt(st.nextToken());
        if (a[0] == a[1] && a[1] == a[2]) {
            System.out.print(10000 + a[0] * 1000);
        } else if (a[0] == a[1] || a[1] == a[2]) {
            System.out.print(1000 + a[1] * 100);
        } else if (a[0] == a[2]) {
            System.out.print(1000 + a[0] * 100);
        } else {
            System.out.print(Math.max(Math.max(a[0], a[1]), a[2]) * 100);
        }
    }
}
