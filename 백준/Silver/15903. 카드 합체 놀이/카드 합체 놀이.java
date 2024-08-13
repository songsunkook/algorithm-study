/*
    BAEKJOON 15903번 카드 합체 놀이
    https://www.acmicpc.net/problem/15903

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            q.offer(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            long sum = q.poll() + q.poll();
            q.offer(sum);
            q.offer(sum);
        }
        long ans = q.stream().mapToLong(Long::valueOf).sum();
        System.out.print(ans);
    }
}
