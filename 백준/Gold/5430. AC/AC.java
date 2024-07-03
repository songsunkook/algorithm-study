/*
    BAEKJOON 5430번 AC
    https://www.acmicpc.net/problem/5430

    추가 학습 내용
    - String to int[]
        1. replaceAll("\\[|\\]", "")
        2. split(",")
        3. Arrays.stream()
        4. filter(s -> !s.isEmpty())
            - 이게 없으면 빈 문자열 입력 시 toArray()에서 에러 발생
        5. mapToInt()
        6. toArray()

    복습 필요: O
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String func = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine()
                .replaceAll("\\[|\\]", "")
                .split(",");
            int[] arr = Arrays.stream(str)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
            boolean front = true, error = false;
            Deque<Integer> deq = new LinkedList<>();
            for (int a : arr) {
                deq.add(a);
            }
            for (char c : func.toCharArray()) {
                if (c == 'R') {
                    front = !front;
                }
                if (c == 'D') {
                    if (deq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (front) {
                        deq.removeFirst();
                    } else {
                        deq.removeLast();
                    }
                }
            }
            List<Integer> result = new ArrayList<>(deq);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int count = 0;
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(front ? i : result.size() - i - 1));
                count++;
                if (count < deq.size()) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (error) {
                bw.write("error\n");
            } else {
                bw.write(sb + "\n");
            }
        }
        bw.close();
        br.close();
    }
}
