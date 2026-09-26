class Solution {
    boolean isAllowed(int[] mapS, int[] mapT) {
        for (int i = 0; i < 266; i++) {
            if (mapS[i] < mapT[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int i = 0, j = 0, n = s.length();
        int[] mapT = new int[266];
        for (int c = 0; c < t.length(); c++) {
            mapT[t.charAt(c)]++;
        }
        int[] mapS = new int[266];
        int[] ans = new int[]{Integer.MAX_VALUE, -1, -1};
        while (j < n) {
            Character cJ = s.charAt(j);
            mapS[cJ]++;
            while (isAllowed(mapS, mapT)) {
                if (ans[0] >= j - i + 1) {
                    ans[0] = j - i + 1;
                    ans[1] = i;
                    ans[2] = j;
                }
                Character cI = s.charAt(i);
                mapS[cI]--;
                i++;
            }
            j++;
        }
        if (ans[1] == -1 || ans[2] == -1) {
            return "";
        }
        return s.substring(ans[1], ans[2] + 1);
    }
}