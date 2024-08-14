/*
    BAEKJOON 2170번 선 긋기
    https://www.acmicpc.net/problem/2170

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
        PriorityQueue<Line> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.offer(new Line(Math.min(x, y), Math.max(x, y)));
        }
        int sum = 0;
        Line prev = q.poll();
        while (!q.isEmpty()) {
            Line cur = q.poll();
            if (cur.st <= prev.en) {
                prev.en = Math.max(prev.en, cur.en);
            } else {
                sum += prev.en - prev.st;
                prev = cur;
            }
        }
        sum += prev.en - prev.st;
        System.out.print(sum);
    }

    static class Line implements Comparable<Line> {
        int st, en;

        Line(int st, int en) {
            this.st = st;
            this.en = en;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.st, o.st);
        }
    }
}
