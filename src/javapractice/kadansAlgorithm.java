package javapractice;
//Kadane's Algorithm
//Difficulty: MediumAccuracy: 36.28%Submissions: 1.2MPoints: 4Average Time: 20m
//You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].
//
//Note : A subarray is a continuous part of an array.
//
//        Examples:
//
//Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
//Output: 11
//Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.

public class kadansAlgorithm {
    public static int maxSubArraySum(int[] arr) {
        int max_sum = arr[0];
        int current_sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current_sum = Math.max(arr[i], current_sum + arr[i]);
            max_sum = Math.max(max_sum, current_sum);
        }

        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println("Maximum subarray sum is: " + maxSubArraySum(arr));
}}
