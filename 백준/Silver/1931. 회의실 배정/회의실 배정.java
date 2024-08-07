/*
    BAEKJOON 1931번 회의실 배정
    https://www.acmicpc.net/problem/1931

    추가 학습 내용
    - 사용자 정의 객체 배열의 정렬

    복습 필요: o
    풀이 참고: o
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meet[] meet = new Meet[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meet[i] = new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meet);
        int now = 0, count = 0;
        for (int i = 0; i < N; i++) {
            if (now <= meet[i].s) {
                now = meet[i].e;
                count++;
            }
        }
        System.out.print(count);
    }

    static class Meet implements Comparable<Meet> {
        int s, e;

        Meet(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meet o) {
            if (this.e == o.e) {
                return this.s - o.s;
            }
            return this.e - o.e;
        }
    }
}
