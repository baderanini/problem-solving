class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> freqs = new HashMap<>();
        
    
        for(int num: arr) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        
        Arrays.sort(arr);
        int count = 0;
        
        arr = sortAbsolute(arr);
        for(int i = 0 ; i < arr.length ; i++) {
            int num = arr[i];
            if(freqs.getOrDefault(num, 0) > 0) {
                if(freqs.getOrDefault(2*num, 0) > 0) {
                     freqs.put(num, freqs.getOrDefault(num, 0) - 1);
                    freqs.put(2*num, freqs.getOrDefault(2*num, 0) - 1);
                    count++;
                } else {
                    return false;
                }
            }
        }
        
        return count >= arr.length/2;
    }
    
    int[] sortAbsolute(int[] arr) {
        int[] res = new int[arr.length];
        int l = 0, h = arr.length - 1, resIndex = arr.length - 1;
        while(l <= h) {
            if(Math.abs(arr[l]) > Math.abs(arr[h])) {
                res[resIndex] = arr[l];
                resIndex--;
                l++;
            } else {
                res[resIndex] = arr[h];
                resIndex--;
                h--;
            }
        }
        
        return res;
    }
}