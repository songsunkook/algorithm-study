/*
    BAEKJOON 1475번 방 번호
    https://www.acmicpc.net/problem/1475
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        int max = 0;
        while (N > 0) {
            arr[N % 10]++;
            if (max < arr[N % 10] && N % 10 != 6 && N % 10 != 9) {
                max = arr[N % 10];
            }
            N /= 10;
        }
        if (max < Math.max(arr[6], arr[9])) {
            max = (arr[6] + arr[9] + 1) / 2;
        }
        System.out.print(max);
    }
}
