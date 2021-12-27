class Solution {
    public int findKthPositive(int[] nums, int k) {
        
        
        Set<Integer> greatPositives = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++) {
            while(i+1 != nums[i]) {
                int j = nums[i] - 1;
                if(j < 0 || j >= nums.length || nums[i] == nums[j]) {
                    if(j >= nums.length)
                        greatPositives.add(nums[i]);
                    break;
                }
                
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        
        
        int counter, i;
        for(i = 0, counter = 0 ; counter < k ; i++) {
            if(i >= nums.length) {
                if(!greatPositives.contains(i+1))
                    counter++;
            } else {
                if(i+1 != nums[i])
                    counter++;
            }
        }
        
        return i;
    }
}