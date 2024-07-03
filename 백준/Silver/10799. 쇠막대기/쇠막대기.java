/*
    BAEKJOON 10799번 쇠막대기
    https://www.acmicpc.net/problem/10799

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        boolean prevLaser = false;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                prevLaser = false;
            }
            if (c == ')') {
                // Laser
                if (stack.peek() == '(' && !prevLaser) {
                    count += stack.size() - 1;
                    prevLaser = true;
                } else {
                    count++;
                }
                stack.pop();
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}
