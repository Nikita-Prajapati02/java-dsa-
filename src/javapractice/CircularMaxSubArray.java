package javapractice;
//Max Circular Subarray Sum
//Difficulty: HardAccuracy: 29.37%Submissions: 177K+Points: 8Average Time: 25m
//You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.
//
//Examples:
//
//Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
//Output: 22
//Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
public class CircularMaxSubArray {
    public int maxSubarraySumCircular(int[] arr) {
        int total = 0;
        int curMax = 0, maxSum = arr[0];
        int curMin = 0, minSum = arr[0];

        for (int num : arr) {
            total += num;

            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);
        }

        // If all elements are negative
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);

    }
    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println("Circular Maximum  Subarray = " + maxSubarraySumCircular(arr));
    }
}