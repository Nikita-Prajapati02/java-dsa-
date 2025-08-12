package javapractice;

import java.util.Arrays;



public class Smallest_Range_II{
    public static  int smallestRangeII(int[] nums,int n, int k) {

        Arrays.sort(nums);
        int diff=nums[n-1]-nums[0];
        int smallest=nums[0]+k;
        int largest=nums[n-1]-k;
        for(int i=0;i<n-1;i++){
            int minval=Math.min(smallest,nums[i+1]-k);
            int maxval=Math.max(largest,nums[i]+k);
            // if(minval<0)continue;
            diff=Math.min(diff,maxval-minval);

        }

        return diff;
    }

public static void main(String[] args) {
    int []nums = {1,3,6};
    int k = 3;
    int n=nums.length;
    System.out.println(smallestRangeII(nums, n, k) );
}}

