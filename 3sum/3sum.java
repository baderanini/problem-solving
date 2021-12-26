import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(i == 0 || nums[i] != nums[i-1])
                twoSum(nums, nums[i], i+1, nums.length - 1, res);
        }
        
        return res;
    }
    
    
    void twoSum(int[] nums, int num, int st, int end, List<List<Integer>> res) {
        int prevSt = Integer.MIN_VALUE, prevEnd = Integer.MIN_VALUE;
        while(st < end) {
            if(nums[st] == prevSt && nums[end] == prevEnd) {
                st++;
                end--;
                continue;
            }
            
            int sum = nums[st] + nums[end];
            if(num + sum == 0) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(num);
                subRes.add(nums[st]);
                subRes.add(nums[end]);
                res.add(subRes);
                prevSt = nums[st];
                prevEnd = nums[end];
            } else if (num + sum > 0) {
                end--;
            } else {
                st++;
            }
        }
    }
}


/*


[-1, 0, 1, 2, -1 ,-4 ,-2 ,-3 ,3 ,0 ,4]
[-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4]

*/