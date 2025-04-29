import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> d = new LinkedList<>();
        Deque<Integer> s = new LinkedList<>();
        Deque<Integer> dg = new LinkedList<>();
        Deque<Integer> sg = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            d.addLast(Integer.parseInt(st.nextToken()));
            s.addLast(Integer.parseInt(st.nextToken()));
        }

        String winner = null;
        Deque<Integer> nowDeck = d;
        Deque<Integer> nowG = dg;
        for (int turn = 0; turn < m; turn++) {
            // System.out.println("turn: " + turn);
            int card = nowDeck.removeLast();
            nowG.addLast(card);
            if (nowDeck.isEmpty()) {
                winner = nowDeck == d ? "su" : "do";
                break;
            }
            // if (card == 5) {
            if ((!dg.isEmpty() && dg.peekLast() == 5) || (!sg.isEmpty() && sg.peekLast() == 5)) {
                // d win
                while (!sg.isEmpty()) {
                    d.addFirst(sg.removeFirst());
                }
                while (!dg.isEmpty()) {
                    d.addFirst(dg.removeFirst());
                }
            } else if (!sg.isEmpty() && !dg.isEmpty() && sg.peekLast() + dg.peekLast() == 5) {
                // s win
                while (!dg.isEmpty()) {
                    s.addFirst(dg.removeFirst());
                }
                while (!sg.isEmpty()) {
                    s.addFirst(sg.removeFirst());
                }
            }
            nowDeck = nowDeck == d ? s : d;
            nowG = nowG == dg ? sg : dg;
        }
        // System.out.println("d: " + d + ", s: " + s);
        if (winner == null) {
            if (d.size() > s.size()) {
                winner = "do";
            } else if (d.size() < s.size()) {
                winner = "su";
            } else {
                winner = "dosu";
            }
        }
        bw.write(winner + "");

        bw.close();
        br.close();
    }
}