class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++) {
            while(nums[i] != i+1) {
                int j = nums[i] - 1;
                if(j >= nums.length || nums[j] == nums[i])
                    break;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(i+1 != nums[i])
                res.add(i+1);
        }
        
        return res;
    }
}