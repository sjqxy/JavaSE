package h1;

import java.util.ArrayList;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ab=new int[2];
        ArrayList<Object> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if (list.contains(nums[i])){
                ab[0]=list.indexOf(nums[i]);
                ab[1]=i;

    } else list.add(target-nums[i]);

        }
       return ab;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a=new int[]{3,3};
        System.out.println(solution.twoSum(a,6));

    }
}
