/*
    BAEKJOON 10807번 개수 세기
    https://www.acmicpc.net/problem/10807
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[201];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken()) + 100]++;
        }
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        System.out.print(arr[v + 100]);
    }
}
