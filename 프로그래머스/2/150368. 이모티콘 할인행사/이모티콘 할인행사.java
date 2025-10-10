class Solution {
    int[] dd = {10,20,30,40};
    int[] ans = new int[2];
    int[] disc;
    
    public int[] solution(int[][] users, int[] emoticons) {
        disc = new int[emoticons.length];
        dfs(0, users, emoticons);
        return ans;
    }
    
    void dfs(int idx, int[][] users, int[] emos) {
        if (idx == emos.length) {
            cal(users, emos);
            return;
        }
        for(int d : dd) {
            disc[idx] = d;
            dfs(idx + 1, users, emos);
        }
    }
    
    void cal(int[][] users, int[] emos) {
        int plusSum = 0;
        int costSum = 0;
        for(int[] user : users) {
            int userCost = 0;
            for(int i=0;i<emos.length;i++) {
                if (user[0] <= disc[i]) {
                    userCost += (int)emos[i] * (1 - (disc[i] * 0.01));
                }
            }
            if (userCost >= user[1]) {
                plusSum++;
            } else {
                costSum+=userCost;
            }
        }
        if (ans[0] < plusSum || (ans[0] == plusSum && ans[1] < costSum)) {
            ans[0] = plusSum;
            ans[1] = costSum;
        }
    }
}