/*
    BAEKJOON 1919번 애너그램 만들기
    https://www.acmicpc.net/problem/1919

    추가 학습 내용
    - 절대값 함수
*/

import java.io.*;
import java.util.*;

public class Main {

    public static int[] count1, count2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        count1 = new int[26];
        count2 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count2[c - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(count1[i] - count2[i]);
        }
        System.out.print(result);
    }
}
