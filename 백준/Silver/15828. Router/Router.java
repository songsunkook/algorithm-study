import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        while(true) {
            int input = Integer.parseInt(br.readLine());
            if (input==-1) {
                break;
            }
            if (input==0){
                q.poll();
                continue;
            }
            if (q.size() >= n)
                continue;
            q.offer(input);
        }
        if (q.isEmpty())
            bw.write("empty");
        for(var a = q.poll(); a != null; a = q.poll()) {
            bw.write(a + " ");
        }
        bw.close();
        br.close();
    }
}
