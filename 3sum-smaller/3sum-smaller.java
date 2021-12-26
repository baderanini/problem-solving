class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        
        
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            int st = i+1, end = nums.length - 1;
            while(st < end) {
                int sum = nums[i] + nums[st] + nums[end];
                if(sum >= target) {
                    end--;
                } else {
                    res += end - st;
                    st++;
                }
            }
        }
        
        return res;
    }
}


/*
target 5


1 2 3 4 5 6 7 8 9




*/