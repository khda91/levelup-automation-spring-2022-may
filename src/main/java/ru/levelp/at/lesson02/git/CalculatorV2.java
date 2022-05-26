package ru.levelp.at.lesson02.git;

import java.util.Arrays;

public class CalculatorV2 {

    public int add(int... nums) {
        return Arrays.stream(nums).sum();
    }

    public int subtract(int... nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res -= nums[i];
        }
        return res;
    }

    public int multiply(int... nums) {
        int res = 1;
        for (int num : nums) {
            res *= num;
        }
        return res;
    }

    public int divide(int... nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res /= nums[i];
        }
        return res;
    }

    public double add(double... nums) {
        return Arrays.stream(nums).sum();
    }

    public double subtract(double... nums) {
        double res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res -= nums[i];
        }
        return res;
    }
}
