package com.leiqjl;

/**
 * 134. Gas Station - Medium
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0;
        int tank = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                idx = i + 1;
                tank = 0;
            }
        }
        return sumGas >= sumCost ? idx : -1;
    }
}
