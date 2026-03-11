import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 뒷 작업부터 걸리는 시간을 stack에 삽입, 앞작업부터 pop하며 이미 걸린시간이 더 크다면 함께 pop
        Stack<Integer> st = new Stack<>();
        int n = speeds.length;
        for(int i=n-1;i>=0;i--) {
            int left = 100 - progresses[i];
            int leftDays = (int)Math.ceil((double)left / speeds[i]);
            st.push(leftDays);
        }
        int today = 0;
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
		while(!st.isEmpty()) {
            while (!st.isEmpty() && today >= st.peek()) {
            	st.pop();
                cnt++;
            }
            if (cnt != 0) {
            	ans.add(cnt);
            	cnt = 0;
            }
            if (!st.isEmpty() && today < st.peek()) {
                today = st.pop();
                cnt++;
            }
        }
        if (cnt != 0) {
            ans.add(cnt);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}