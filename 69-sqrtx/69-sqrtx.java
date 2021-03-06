class Solution {
    public int mySqrt(long x) {
        long st = 1, end = x;
        
        while(st <= end) {
            long mid = st + (end - st) / 2;
            if(mid * mid > x)
                end = mid - 1;
            else
                st = mid + 1;
        }
        
        return (int) end;
    }
}