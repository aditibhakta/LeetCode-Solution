class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];

        boolean added = false;

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][1] < start) {

                result.add(intervals[i]);

            }
            else if (intervals[i][0] > end) {

                if (!added) {
                    result.add(new int[]{start, end});
                    added = true;
                }

                result.add(intervals[i]);

            }
            else {

                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        if (!added) {
            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }
}