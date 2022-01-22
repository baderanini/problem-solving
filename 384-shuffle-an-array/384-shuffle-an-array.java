class Solution {

    int[] original;
    Random random;
    public Solution(int[] nums) {
        random = new Random();
        this.original = nums; 
    }
    
    public int[] reset() {
        random = new Random();
        return original;
    }
    
    public int[] shuffle() {        
        int[] result = new int[original.length];
        
        for(int i = 0 ; i < original.length ; i++) {
            result[i] = original[i];
        }
        
        for(int i = 0 ; i < result.length ; i++) {
            int randomRndex = random.nextInt(result.length - i) + i;
            replace(result, i, randomRndex);
        }
        
        return result;
    }
    
    void replace(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */