package javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class majorityElement {
    public static List<Integer> majorityElements(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // 1st pass: find two possible candidates
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass: count their actual frequency
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) count1++;
            else if (candidate2 != null && num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        Collections.sort(result); // final sorted output
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 1, 3, 2, 1, 1};
        System.out.println(majorityElements(arr)); // Output: [1, 2]
    }
}
