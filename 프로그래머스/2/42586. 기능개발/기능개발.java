import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length == 0) return new int[0];
        List<Integer> ans = new ArrayList<>();
        int today = 0;
        int cnt = 1;
        for(int i = 0;i<progresses.length;i++) {
        	int left = 100 - progresses[i];
            int days = (int)Math.ceil((double)left / speeds[i]);
            if (days > today) {
                today = days;
                if (i != 0) {
                	ans.add(cnt);
                	cnt = 1;
                }
            } else {
                cnt++;
            }
        }
        if (cnt != 0) ans.add(cnt);
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}