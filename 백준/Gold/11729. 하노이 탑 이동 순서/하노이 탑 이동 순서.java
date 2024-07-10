/*
    BAEKJOON 11729번 하노이 탑 이동 순서
    https://www.acmicpc.net/problem/11729

    추가 학습 내용
    - 

    복습 필요: O
    풀이 참고: O
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] sticks;
    static List<Act> his = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        sticks = new int[3][N];
        move(0, 2, N);
        bw.write(his.size() + "\n");
        for (int i = 0; i < his.size(); i++) {
            bw.write((his.get(i).a + 1) + " " + (his.get(i).b + 1) + "\n");
        }
        bw.close();
        br.close();
    }

    static void move(int a, int b, int n) {
        if (n == 1) {
            his.add(new Act(a, b));
            return;
        }
        move(a, 3 - a - b, n - 1);
        his.add(new Act(a, b));
        move(3 - a - b, b, n - 1);
        /**
         * 1. n-1번 원판까지 c(sum-a-b) 기둥으로 옮긴다
         * 2. n번 원판을 b 기둥으로 옮긴다
         * 3. n-1번 원판까지 b 기둥으로 옮긴다
         */
    }

    static class Act {
        int a, b;

        public Act(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
