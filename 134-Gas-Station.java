class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0;
        int total_cost = 0;

        for(int i = 0; i < gas.length; i++){
            total_gas += gas[i];
            total_cost += cost[i];
        }
        if(total_gas < total_cost){
            return -1;
        }

        int currentgas = 0;
        int startIndex = 0;
        for(int i = 0; i < gas.length; i++){
            currentgas += gas[i] - cost[i];

            if(currentgas < 0){
                startIndex = i + 1;
                currentgas = 0;
            }
        }
        return startIndex;
    }
}