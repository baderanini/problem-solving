class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 3 ; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i + 1 ; j < nums.length - 2 ; j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                int st = j+1, end = nums.length - 1;
                
                while(st < end) {
                    
                    while(st < end && st > j+1 && nums[st] == nums[st-1])
                        st++;
                    while(st < end && end < nums.length - 1 && nums[end] == nums[end+1])
                        end--;
                    
                    if(st == end)
                        break;
                    
                    int total = nums[i] + nums[j] + nums[st] + nums[end];
                    
                    if(total == target) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[st]);
                        curr.add(nums[end]);
                        res.add(curr);
                        st++;
                        end--;
                    } else if(total < target) {
                        st++;
                    } else {
                        end--;
                    }
                }
            }
        }
        
        return res;
    }
}