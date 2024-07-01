/*
    BAEKJOON 2493번 탑
    https://www.acmicpc.net/problem/2493
    
    복습 필요 - 풀이 참조함
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tower = new int[N];
        for (int i = 0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> result = new ArrayList<>(N);
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<N;i++) {
            while (!stack.empty() && tower[stack.peek()] < tower[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                result.add(0);
            } else {
                result.add(stack.peek() + 1);
            }
            stack.push(i);
        }
        for (int i=0;i<N;i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
