/*
    BAEKJOON 1026번 보물
    https://www.acmicpc.net/problem/1026

    추가 학습 내용
    - Arrays.sort에서 인자로 비교 방법을 람다로 제공하는 방법

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Arr[] B = new Arr[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Arr(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(B);
        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            B[i].a = A[i];
        }
        Arrays.sort(B, (a, b) -> Integer.compare(a.idx, b.idx));
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += B[i].a * B[i].n;
        }
        System.out.print(sum);
    }

    static class Arr implements Comparable<Arr> {
        int idx, n, a;

        Arr(int idx, int n) {
            this.idx = idx;
            this.n = n;
        }

        @Override
        public int compareTo(Arr o) {
            return Integer.compare(o.n, this.n);
        }
    }
}
