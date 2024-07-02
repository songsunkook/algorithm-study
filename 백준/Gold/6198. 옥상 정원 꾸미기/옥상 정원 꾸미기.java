/*
    BAEKJOON 6198번 옥상 정원 꾸미기
    https://www.acmicpc.net/problem/6198

    복습 필요 - 풀이 참조함
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> st = new Stack<>();
        long result = 0;
        for (int i = 0; i < N; i++) {
            while (!st.empty() && st.peek() <= arr[i]) {
                st.pop();
            }
            result += st.size();
            st.add(arr[i]);
        }
        System.out.print(result);
    }
}
