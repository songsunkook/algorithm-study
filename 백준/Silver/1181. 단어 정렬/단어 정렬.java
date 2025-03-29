import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (!arr.contains(word)) {
                arr.add(word);
            }
        }
        Collections.sort(arr, Comparator.comparing(String::length)
                .thenComparing((a, b) -> a.compareTo(b)));

        for (var word : arr) {
            bw.write(word + "\n");
        }

        bw.close();
        br.close();
    }
}