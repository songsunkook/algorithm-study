import java.io.*;
import java.util.*;

/**
 * 가로세로 길이 최대 15
 * 퀸은 가로/세로/대각선/대각선으로 이동 가능하다.
 * - 해당 경로 중 이전에 놓은 퀸이 하나도 있으면 안된다.
 * 가로줄 한줄마다 퀸 하나만 가능하니까,
 * - 위에서부터 한줄씩 선점하며 내려갈 수 있다.
 * - 배열 인덱스를 row, 값을 column으로 배치할 수 있다.
 * arr[i] = j
 * i번째 줄 j번째 칸에 퀸이 배치되었다.
 * 
 * 시간복잡도
 * 일차원 배열 구조는 탐색 비용이 매우 절약된다 O(n)
 * 이차원 배열 구조가 직관적이지만 탐색 비용이 높다 O(n^2)
 * 퀸 하나 놓을 때마다 탐색이 필요하다.
 * 모든 칸에서 탐색할 경우 O(n! * 배열 탐색 비용)
 * 이차원 배열 구조 -> O(n! * n^2)
 * 일차원 배열 구조 -> O(n! * n)
 * 
 * O(n)도 오래걸린다. 
 * 각 세로나 대각선을 유일하게 식별할 수 있다면 조건 검사를 O(1)에 할 수 있다.
 * / 대각선: r+c = i
 * \ 대각선: r-c = i
 * 대각선은 총 개수가 n개를 넘기에 2*n으로 범위를 잡는다.
 * \ 대각선은 음수인덱스가 나올 수 있기에 보드 크기를 더한다(n-1).
 */
class Main {

    static int n;
    static boolean[] rows, dia1, dia2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        rows = new boolean[n];
        dia1 = new boolean[2 * n];
        dia2 = new boolean[2 * n];
        bw.write(dfs(0) + "");
        bw.close();
        br.close();
    }

    static int dfs(int row) {
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (can(row, i)) {
                rows[i] = true;
                dia1[row + i] = true;
                dia2[row - i + n - 1] = true;
                cnt += dfs(row + 1);
                rows[i] = false;
                dia1[row + i] = false;
                dia2[row - i + n - 1] = false;
            }
        }
        return cnt;
    }

    static boolean can(int r, int c) {
        return !(rows[c] || dia1[r + c] || dia2[r - c + n - 1]);
    }
}