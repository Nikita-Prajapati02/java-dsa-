package javapractice;
//Maximum Product Subarray
//Difficulty: MediumAccuracy: 18.09%Submissions: 473K+Points: 4
//Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].
//
//Note: It is guaranteed that the answer fits in a 32-bit integer.
//
//Examples
//
//Input: arr[] = [-2, 6, -3, -10, 0, 2]
//Output: 180
//Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.
public class maxProduct {
    public static int maxProduct(int[] arr) {
        int n = arr.length;

        int prefix = 1, suffix = 1;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Forward pass (prefix)
            prefix = (prefix == 0 ? 1 : prefix) * arr[i];
            result = Math.max(result, prefix);

            // Backward pass (suffix)
            suffix = (suffix == 0 ? 1 : suffix) * arr[n - 1 - i];
            result = Math.max(result, suffix);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.out.println("Maximum Product Subarray = " + maxProduct(arr));
    }
}
