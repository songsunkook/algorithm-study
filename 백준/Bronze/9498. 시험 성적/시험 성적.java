/*
    BAEKJOON 9498번 시험 성적
    https://www.acmicpc.net/problem/9498
*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int input = Integer.parseInt(st.nextToken());
    String result = "F";
    // 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력
    if (input >= 60) {
      result = "D";
    }
    if (input >= 70) {
      result = "C";
    }
    if (input >= 80) {
      result = "B";
    }
    if (input >= 90) {
      result = "A";
    }
    System.out.print(result);
  }
}
