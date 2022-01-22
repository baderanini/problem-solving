class Solution {
    public int minArea(char[][] image, int x, int y) {
        int upper = findLimit(image, 0, x-1, false, false);
        int lower = findLimit(image, x+1, image.length-1, false, true);
        
        int left = findLimit(image, 0, y-1, true, false);
        int right = findLimit(image, y+1, image[0].length-1, true, true);
                
        return (lower-upper-1) * (right-left-1);
    }
    
    int findLimit(char[][] image, int l, int h, boolean checkingCols, boolean needsHigher) {
        while(l <= h) {
            int mid = l+(h-l)/2;
            boolean condition = checkingCols ? colAllZeros(image, mid) : rowAllZeros(image, mid);
            if(condition) {
                if(needsHigher)
                    h = mid-1;
                else
                    l = mid+1;
            } else {
                if(needsHigher)
                    l = mid+1;
                else
                    h = mid-1;
            }
        }
        return needsHigher ? l : h;
    }
    
    boolean rowAllZeros(char[][] image, int row) {
        for(int j = 0 ; j < image[0].length ; j++)
            if(image[row][j] == '1')
                return false;
        return true;
    }
    
    boolean colAllZeros(char[][] image, int col) {
        for(int i = 0 ; i < image.length ; i++)
            if(image[i][col] == '1')
                return false;
        return true;
    }
}