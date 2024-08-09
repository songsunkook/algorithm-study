/*
    BAEKJOON 1541번 잃어버린 괄호
    https://www.acmicpc.net/problem/1541

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
        String input = br.readLine();
        int tmp = 0;
        List<Integer> nums = new ArrayList<>();
        List<Character> mark = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (c >= '0' && c <= '9') {
                tmp = tmp * 10 + (c - '0');
            } else {
                nums.add(tmp);
                tmp = 0;
                mark.add(c);
            }
        }
        nums.add(tmp);

        int ans = nums.get(0);
        boolean isMinus = false;
        for (int i = 1; i < nums.size(); i++) {
            if (mark.get(i - 1) == '-') {
                for (int j = i; j < nums.size(); j++) {
                    ans -= nums.get(j);
                }
                break;
            }
            ans += nums.get(i);
        }
        System.out.print(ans);
    }
}
