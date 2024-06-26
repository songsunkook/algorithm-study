/*
    BAEKJOON 13300번 방 배정
    https://www.acmicpc.net/problem/13300

    추가 학습 내용
    - 올림 함수 (Math.ceil)
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[6][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[y][s]++;
        }
        int result = 0;
        for (int y = 0; y < 6; y++) {
            for (int s = 0; s < 2; s++) {
                result += Math.ceil((double)arr[y][s] / K);
            }
        }
        System.out.print(result);
    }
}
