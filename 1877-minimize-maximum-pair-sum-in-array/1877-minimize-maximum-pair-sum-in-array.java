class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int l = 0, h = nums.length - 1;
        
        int min = Integer.MIN_VALUE;
        while(l < h) {
            min = Math.max(min, nums[l] + nums[h]);
            l++;
            h--;
        }
        return min;
    }
}


/*
min: max arr elem + min arr elem
max: max arr elem + sec max ar elem

[3,5,2,3]
min: 5 + 2 = 7
max: 5 + 3
*/


/*

[3,5,4,2,4,6]
[2,3,4,4,5,6]


[2,3,4,4,10,15]

*/