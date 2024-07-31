/*
    BAEKJOON 15688번 수 정렬하기 5
    https://www.acmicpc.net/problem/15688

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2000010];
        for (int i = 0; i < N; i++) {
            arr[1000000 + Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i < 2000010; i++) {
            while (arr[i] != 0) {
                bw.write((i - 1000000) + "\n");
                arr[i]--;
            }
        }
        bw.close();
    }
}
