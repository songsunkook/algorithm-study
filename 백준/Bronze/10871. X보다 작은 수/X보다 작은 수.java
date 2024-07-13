/*
    BAEKJOON 10871번 X보다 작은 수
    https://www.acmicpc.net/problem/10871

    추가 학습 내용
    - 

    복습 필요: 
    풀이 참고: 
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (x > input) {
                bw.write(input + " ");
            }
        }
        bw.close();
    }
}
