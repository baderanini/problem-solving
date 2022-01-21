class SnapshotArray {

    final int SNAP_INDEX = 0, VAL_INDEX = 1;
    Map<Integer, ArrayList<int[]>> map;
    int snapId = 0;
    public SnapshotArray(int length) {
        map = new HashMap<>();
        snapId = 0;
    }
    
    public void set(int index, int val) {
        map.putIfAbsent(index, new ArrayList<>());
        map.get(index).add(new int[] {snapId, val});
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        ArrayList<int[]> setsPerIndex = map.getOrDefault(index, new ArrayList<>());
        int l = 0, h = setsPerIndex.size() - 1;
        while(l <= h) {
            int mid = l + (h-l)/2;
            if(setsPerIndex.get(mid)[SNAP_INDEX] > snap_id) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return h < 0 ? 0 : setsPerIndex.get(h)[VAL_INDEX];
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */