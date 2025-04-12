import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>(n);
        @SuppressWarnings("unchecked")
        Map.Entry<Integer, Integer>[] count = new Map.Entry[8001];
        for (int i = 0; i < 8001; i++)
            count[i] = Map.entry(i, 0);
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
            count[num + 4000] = Map.entry(num, count[num + 4000].getValue() + 1);
        }

        Collections.sort(arr);
        int ave = (int) Math.round(arr.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .getAsDouble());
        int mid = arr.get(arr.size() / 2);
        Arrays.sort(count, (a, b) -> {
            if (a.getValue() == b.getValue())
                return Integer.compare(a.getKey(), b.getKey());
            return Integer.compare(b.getValue(), a.getValue());
        });
        int mode = count[0].getValue() == count[1].getValue() ? count[1].getKey() : count[0].getKey();
        int range = arr.get(arr.size() - 1) - arr.get(0);
        bw.write(ave + "\n" + mid + "\n" + mode + "\n" + range);
        bw.close();
        br.close();
    }
}