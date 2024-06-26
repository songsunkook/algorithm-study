/*
    BAEKJOON 11328번 Strfry
    https://www.acmicpc.net/problem/11328
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            for (char c : s1.toCharArray()) {
                arr1[c - 'a']++;
            }
            for (char c : s2.toCharArray()) {
                arr2[c - 'a']++;
            }
            boolean result = true;
            for (int i = 0; i < 26; i++) {
                if (arr1[i] != arr2[i]) {
                    result = false;
                    break;
                }
            }
            System.out.println(result ? "Possible" : "Impossible");
        }
    }
}
