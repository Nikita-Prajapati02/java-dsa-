package javapractice;

import java.util.Arrays;

public class nextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {

            // code here
            int n= nums.length;
            int i=n-2;
            while(i>=0 && nums[i] >= nums[i+1]){
                i--;
            }
            if(i>=0){
                int j=n-1;
                while(nums[j]<=nums[i]){
                    j--;
                }
                swap(nums,i,j);
            }
            reverse(nums,i+1,n-1);

        }

        public static void swap(int[]nums,int i,int j){
            int temp= nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        private static void reverse(int[]nums, int start,int end){
            while(start < end){
                swap(nums,start++,end--);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 7, 5, 0};

        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
