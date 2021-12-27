class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int fPointer = 0, sPointer = 0;
        
        
        List<int[]> resList = new ArrayList<>();
        while(fPointer < firstList.length && sPointer < secondList.length) {
            int[] fInterval = firstList[fPointer], sInterval = secondList[sPointer];  
            if(isOverlapping(firstList[fPointer], secondList[sPointer]))
                resList.add(new int[] {Math.max(fInterval[0], sInterval[0]), Math.min(fInterval[1], sInterval[1])});
            if(fInterval[1] < sInterval[1])
                fPointer++;
            else if(sInterval[1] < fInterval[1])
                sPointer++;
            else {
                fPointer++;
                sPointer++;
            }    
        }
        
        int[][] res = new int[resList.size()][];
        
        int index = 0;
        for(int[] interval: resList)
            res[index++] = interval;

        return res;
    }
    
    boolean isOverlapping(int[] f, int[] s) {
        return !(f[0] > s[1]) && !(s[0] > f[1]);
    }
}