/*
    BAEKJOON 1744번 수 묶기
    https://www.acmicpc.net/problem/1744

    추가 학습 내용
    - 

    복습 필요: O
    풀이 참고: O
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                plus.offer(n);
            } else {
                minus.offer(n);
            }
        }
        int sum = getSum(plus) + getSum(minus);
        System.out.print(sum);
    }

    private static int getSum(PriorityQueue<Integer> q) {
        int sum = 0;
        while (!q.isEmpty()) {
            int n1 = q.poll();
            if (q.isEmpty()) {
                sum += n1;
                break;
            }
            int n2 = q.poll();
            sum += Math.max(n1 * n2, n1 + n2);
        }
        return sum;
    }
}
