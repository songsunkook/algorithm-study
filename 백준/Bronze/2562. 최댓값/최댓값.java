import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Num[] arr = new Num[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = new Num(Integer.parseInt(br.readLine()), i + 1);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.n, b.n));
        bw.write(arr[8].n + "\n" + arr[8].i);
        bw.close();
        br.close();
    }

    static class Num {
        int n;
        int i;

        Num(int nn, int ii) {
            n = nn;
            i = ii;
        }
    }
}