/*
    BAEKJOON 11501번 주식
    https://www.acmicpc.net/problem/11501

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int[] afterMax = new int[N];
            long ans = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = Integer.MIN_VALUE;
            for (int i = N - 1; i >= 0; i--) {
                if (max < arr[i]) {
                    afterMax[i] = -1;
                    max = arr[i];
                } else {
                    afterMax[i] = max;
                }
            }
            for (int i = 0; i < N; i++) {
                if (afterMax[i] != -1) {
                    ans += afterMax[i] - arr[i];
                }
            }
            bw.write(ans + "\n");
        }
        bw.close();
    }
}
