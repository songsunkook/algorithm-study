/*
    BAEKJOON 2752번 세수정렬
    https://www.acmicpc.net/problem/2752

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
        int[] input = new int[3];
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        System.out.print(input[0] + " " + input[1] + " " + input[2]);
    }
}
