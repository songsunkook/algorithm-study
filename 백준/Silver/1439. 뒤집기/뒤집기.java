/*
    BAEKJOON 1439번 뒤집기
    https://www.acmicpc.net/problem/1439

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
        String input = br.readLine();
        int[] count = new int[2];
        count[input.charAt(0) - '0']++;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i - 1)) {
                count[input.charAt(i) - '0']++;
            }
        }
        System.out.print(Math.min(count[0], count[1]));
    }
}
