/*
    BAEKJOON 3273번 두 수의 합
    https://www.acmicpc.net/problem/3273

    추가 학습 내용
    - HashSet 사용법

    복습 필요
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        HashSet<Integer> buf = new HashSet<>();
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (buf.contains(x - input[i])) {
                count++;
            }
            buf.add(input[i]);
        }
        System.out.print(count);
    }
}
