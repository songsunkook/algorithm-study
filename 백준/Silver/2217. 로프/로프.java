/*
    BAEKJOON 2217번 로프
    https://www.acmicpc.net/problem/2217

    추가 학습 내용
    - 배열 내림차순 정렬

    복습 필요: -
    풀이 참고: 약간
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[N];
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope, Collections.reverseOrder());
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, rope[i] * (i + 1));
        }
        System.out.print(max);
    }
}
