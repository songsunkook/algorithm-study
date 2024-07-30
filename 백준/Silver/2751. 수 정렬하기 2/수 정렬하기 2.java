/*
    BAEKJOON 2751번 수 정렬하기2
    https://www.acmicpc.net/problem/2751

    추가 학습 내용
    - 

    복습 필요: x
    풀이 참고: x
*/

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(0, N);
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.close();
    }

    static void merge_sort(int st, int en) {
        if (en - st == 1) {
            return;
        }
        int mid = (st + en) / 2;
        merge_sort(st, mid);
        merge_sort(mid, en);
        merge(st, en);
    }

    static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int aIdx = 0, bIdx = 0, curIdx = 0;
        int[] tmp = Arrays.copyOfRange(arr, st, mid);
        while (st + aIdx < mid || mid + bIdx < en) {
            if (st + aIdx >= mid) {
                arr[st + curIdx++] = arr[mid + bIdx++];
                continue;
            }
            if (mid + bIdx >= en) {
                arr[st + curIdx++] = tmp[aIdx++];
                continue;
            }
            if (tmp[aIdx] < arr[mid + bIdx]) {
                arr[st + curIdx++] = tmp[aIdx++];
            } else {
                arr[st + curIdx++] = arr[mid + bIdx++];
            }
        }
    }
}
