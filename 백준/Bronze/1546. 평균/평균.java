import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        List<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int M = Collections.max(arr);

        List<Double> arr2 = new ArrayList<>();
        for (int i=0;i<n;i++) {
            arr2.add((double)arr.get(i) / M * 100);
        }
        double sum = 0;
        for(int i=0;i<n;i++) {
            sum += arr2.get(i);
        }
        bw.write(String.format("%.3f", sum / n));
        bw.close();
        br.close();
    }
}