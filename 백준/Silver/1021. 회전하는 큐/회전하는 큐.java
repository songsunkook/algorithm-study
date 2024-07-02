/*
    BAEKJOON 1021번 회전하는 큐
    https://www.acmicpc.net/problem/1021

    추가 학습 내용
    - Deque에서 특정 원소가 왼편에 있는지 오른편에 있는지 판단하는 로직

    복습 필요: O
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deq = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            deq.addLast(i);
        }
        int result = 0;
        for (int t = 0; t < M; t++) {
            int left = getLeftShiftCount(deq, target[t]);
            int right = deq.size() - left;
            while (deq.peekFirst() != target[t]) {
                if (left <= right) {
                    deq.addLast(deq.removeFirst());
                } else {
                    deq.addFirst(deq.removeLast());
                }
                result++;
            }
            deq.removeFirst();
        }
        bw.write(Integer.toString(result));
        bw.close();
        br.close();
    }

    public static int getLeftShiftCount(Deque<Integer> deq, int target) {
        int toLeftCount = 0;
        for (int a : deq) {
            if (a == target) {
                break;
            }
            toLeftCount++;
        }
        return toLeftCount;
    }
}
