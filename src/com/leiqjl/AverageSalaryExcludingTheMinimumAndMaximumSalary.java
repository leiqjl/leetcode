package com.leiqjl;

/**
 * 1491. Average Salary Excluding the Minimum and Maximum Salary - Easy
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;
        for (int s : salary) {
            sum += s;
            max = Math.max(max, s);
            min = Math.min(min, s);
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }
}
