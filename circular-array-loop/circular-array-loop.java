class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        
        for(int i = 0 ; i < nums.length ; i++) {
            boolean forward = nums[i] > 0;

            int slow = i, fast = i, counter = 0;

            int n = nums.length;

            boolean cont = false;
            do {
                if(forward && nums[slow] < 0) {
                    cont = true;
                    break;
                }
                else if(!forward && nums[slow] > 0) {
                    cont = true;
                    break;
                }
                counter++;
                int prevSlow = slow;
                slow = jump(nums, slow, n);
                if(forward && nums[fast] < 0 || slow == prevSlow) {
                    cont = true;
                    break;
                }
 
                else if(!forward && nums[fast] > 0) {
                    cont = true;
                    break;
                }
                
                int prevFast = fast;
                fast = jump(nums, fast, n);
                if(forward && nums[fast] < 0 || fast == prevFast) {
                    cont = true;
                    break;
                }
                else if(!forward && nums[fast] > 0) {
                    cont = true;
                    break;
                }
                prevFast = fast;
                fast = jump(nums, fast, n);
                if(fast == prevFast) {
                   cont = true;
                    break; 
                }
            } while(slow != fast);

            if(!cont && counter > 1)
                return true;
        }
        
        return false;
    }
    
    int jump(int[] nums, int index, int n) {
        int amount = nums[index];
        int indented = index + amount;
        return (indented%n + n) % n;
    }
}