class Entry {
    String val;
    int timestamp;
    
    Entry(String val, int timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    Map<String, ArrayList<Entry>> entries;
    public TimeMap() {
        entries = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        entries.putIfAbsent(key, new ArrayList<>());
        entries.get(key).add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Entry> keyEntries = entries.getOrDefault(key, new ArrayList<>());
        return binarySeach(keyEntries, timestamp);
    }
    
    String binarySeach(ArrayList<Entry> entries, int timestamp) {
        int l = 0, h = entries.size() - 1;
        
        while(l <= h) {
            int mid = l + (h-l)/2;
            Entry midEntry = entries.get(mid);
            if(midEntry.timestamp <= timestamp)
                l = mid + 1;
            else
                h = mid - 1;
        }
        
        
        return h >= 0 ? entries.get(h).val : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */