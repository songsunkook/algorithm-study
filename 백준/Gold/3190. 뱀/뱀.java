import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = new boolean[n];
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = true;
        }

        int l = Integer.parseInt(br.readLine());
        DirPlan[] paths = new DirPlan[l];
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int turn = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            paths[i] = new DirPlan(turn, dir);
        }

        Arrays.sort(paths, (a, b) -> Integer.compare(a.turn, b.turn));

        int pathIdx = 0;
        int nowTurn = 0;
        Pos head = new Pos(0, 0);
        Queue<Pos> snake = new LinkedList<>();
        snake.offer(new Pos(0, 0));
        Dir curDir = new Dir(0, 1);
        while (true) {
            // 머리 돌리기
            if (paths.length > pathIdx && paths[pathIdx].turn == nowTurn) {
                curDir = new Dir(curDir, paths[pathIdx++].dir);
            }

            // 머리 직진 및 게임종료 여부 확인
            head = head.move(curDir);
            if (isBoom(snake, n, head))
                break;
            snake.offer(head);

            // 사과 여부 조사 (있으면 꼬리 미제거, 없으면 꼬리 제거)
            if (board[head.r][head.c]) {
                board[head.r][head.c] = false;
            } else {
                snake.poll();
            }
            nowTurn++;
        }

        bw.write(nowTurn + 1 + "");
        bw.close();
        br.close();
    }

    static boolean isBoom(Queue<Pos> snake, int n, Pos head) {
        if (head.r >= n || head.r < 0 || head.c >= n || head.c < 0)
            return true;
        return snake.contains(head);
    }

    /**
     * paths: 방향 전환 정보
     * board: 사과 존재 유무
     * board 크기: n x n
     */

    static class Dir {
        int dr;
        int dc;

        /**
         * 왼쪽
         * (dx, dy) → (-dy, dx)
         * 
         * 오른쪽
         * (dx, dy) → (dy, -dx)
         */

        Dir(int drr, int dcc) {
            dr = drr;
            dc = dcc;
        }

        Dir(Dir before, String dir) {
            switch (dir) {
                case "L":
                    dr = -before.dc;
                    dc = before.dr;
                    break;
                case "D":
                    dr = before.dc;
                    dc = -before.dr;
                    break;
            }
        }
    }

    static class DirPlan {
        int turn;
        String dir;

        DirPlan(int t, String d) {
            turn = t;
            dir = d;
        }
    }

    static class Pos {
        int r;
        int c;

        Pos(int rr, int cc) {
            r = rr;
            c = cc;
        }

        Pos move(Dir dir) {
            return new Pos(r + dir.dr, c + dir.dc);
        }

        @Override
        public boolean equals(Object o) {
            Pos other = (Pos) o;
            return r == other.r && c == other.c;
        }
    }
}