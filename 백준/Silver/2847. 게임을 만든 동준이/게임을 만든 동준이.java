/*
    BAEKJOON 2847번 게임을 만든 동준이
    https://www.acmicpc.net/problem/2847

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
        int N = Integer.parseInt(br.readLine());
        int[] level = new int[N];
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        for (int i = N - 1; i > 0; i--) {
            if (level[i - 1] >= level[i]) {
                ans += level[i - 1] - level[i] + 1;
                level[i - 1] = level[i] - 1;
            }
        }
        System.out.print(ans);
    }
}
