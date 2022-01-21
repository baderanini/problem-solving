class Solution {
    
    public int[] findOriginalArray(int[] changed) {
        
        int[] emptyArr = new int[] {};
        
        if(changed.length % 2 != 0)
            return emptyArr;
        
        Map<Integer, Integer> freqs = new HashMap<>();
        for(int num: changed)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        
        
        int[] originalArr = new int[changed.length/2];
        
        Map<Integer, Integer> set1 = new HashMap<>();
        
        Arrays.sort(changed);
        
        int zeroC = 0;
        for(int num: changed) {
            if(num == 0)
                zeroC++;
            else {
                if(freqs.getOrDefault(num, 0) > 0) {
                    if(freqs.getOrDefault(num*2, 0) > 0) {
                        set1.put(num, set1.getOrDefault(num, 0) + 1);
                        freqs.put(num, freqs.get(num) - 1);
                        freqs.put(num*2, freqs.get(num*2) - 1);
                    } else {
                        return emptyArr;
                    }
                }
            }
        }
        
        if(zeroC % 2 != 0)
            return emptyArr;
        
        int resIndex = 0;
        for(int i = 0 ; i < zeroC/2 ; i++) {
            originalArr[resIndex++] = 0;
        }
        for(int num: set1.keySet()) {
            for(int i = 0 ; i < set1.get(num) ; i++) 
                originalArr[resIndex++] = num;
        }
        
        return originalArr;
    }
}