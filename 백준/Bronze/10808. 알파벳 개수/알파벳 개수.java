/*
    BAEKJOON 10808번 알파벳 개수
    https://www.acmicpc.net/problem/10808
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        int[] arr = new int[26];
        for (char c : input.toCharArray()) {
            arr[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
