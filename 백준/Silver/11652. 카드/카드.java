/*
    BAEKJOON 11652번 카드
    https://www.acmicpc.net/problem/11652

    추가 학습 내용
    - 

    복습 필요: 
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] n = new long[N];
        for (int i = 0; i < N; i++) {
            n[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(n);
        long cnt = 1, max = n[0], maxCnt = 1;
        for (int i = 1; i < N; i++) {
            if (n[i] == n[i - 1]) {
                cnt++;
            } else {
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    max = n[i - 1];
                }
                cnt = 1;
            }
        }
        if (cnt > maxCnt) {
            max = n[N - 1];
        }
        System.out.print(max);
    }
}
