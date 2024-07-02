/*
    BAEKJOON 17298번 오큰수
    https://www.acmicpc.net/problem/17298

    추가 학습 내용
    - BufferedWriter 사용법
    
    복습 필요: O
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.empty() && a[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.empty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(a[i]);
        }
        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.close();
        br.close();
    }
}
