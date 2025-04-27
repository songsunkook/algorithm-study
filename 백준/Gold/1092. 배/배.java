import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] crain = new Integer[n];
        for (int i = 0; i < n; i++) {
            crain[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean[] empty = new boolean[m];
        Integer[] box = new Integer[m];
        for (int i = 0; i < m; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crain, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());
        int counter = 0;
        int time = 0;
        if (box[0] > crain[0]) {
            bw.write("-1");
        } else {
            while (counter < m) {
                int boxIdx = 0;
                for (var c : crain) {
                    while (boxIdx < m) {
                        if (box[boxIdx] <= c && empty[boxIdx] == false) {
                            empty[boxIdx] = true;
                            counter++;
                            boxIdx++;
                            break;
                        }
                        boxIdx++;
                    }
                }
                time++;
            }
            bw.write(time + "");
        }

        bw.close();
        br.close();
    }
}