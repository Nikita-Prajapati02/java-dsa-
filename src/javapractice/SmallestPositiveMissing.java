package javapractice;

public class SmallestPositiveMissing {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Step 1: Place each number in its correct index (if possible)
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // swap nums[i] with nums[nums[i]-1]
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        // Step 2: Find the first missing positive
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all positions are filled correctly, return n+1
        return n + 1;
    }

    // ✅ Main method to test the solution
    public static void main(String[] args) {


        int[] arr1 = {2, -3, 4, 1, 1, 7};
        System.out.println("Output: " + firstMissingPositive(arr1)); // Expected 3

//        int[] arr2 = {1, 2, 0};
//        System.out.println("Output: " + sol.firstMissingPositive(arr2)); // Expected 3
//
//        int[] arr3 = {3, 4, -1, 1};
//        System.out.println("Output: " + sol.firstMissingPositive(arr3)); // Expected 2
//
//        int[] arr4 = {7, 8, 9, 11, 12};
//        System.out.println("Output: " + sol.firstMissingPositive(arr4)); // Expected 1
    }
}

