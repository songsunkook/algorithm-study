/*
    BAEKJOON 2753번 윤년
    https://www.acmicpc.net/problem/2753

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
        int n = Integer.parseInt(br.readLine());
        if (n % 4 == 0 && (n % 100 != 0 || n % 400 == 0)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
