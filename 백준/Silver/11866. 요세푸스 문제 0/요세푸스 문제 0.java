import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            arr.add(i);
        arr.set(0, n);

        List<Integer> result = new ArrayList<>(n);
        int idx = 0;
        while (!arr.isEmpty()) {
            idx += k;
            idx %= arr.size();
            result.add(arr.remove(idx));
            idx -= 1;
        }

        bw.write(result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">")));

        bw.close();
        br.close();
    }
}