import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Pos[] arr = new Pos[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.y == b.y)
                return Integer.compare(a.x, b.x);
            return Integer.compare(a.y, b.y);
        });

        for (int i = 0; i < n; i++) {
            bw.write(arr[i].x() + " " + arr[i].y() + "\n");
        }
        bw.close();
        br.close();
    }

    static class Pos {
        int x;
        int y;

        int x() {
            return x;
        }

        int y() {
            return y;
        }

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}