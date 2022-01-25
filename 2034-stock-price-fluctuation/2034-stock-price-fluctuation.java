class Node {
    int val;
    int timestamp;
    boolean valid = true;
    
    Node(int val, int timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }
}

class StockPrice {
    
    int current;
    int lastTimestamp;
    Map<Integer, Node> nodes;
    PriorityQueue<Node> maxNodes;
    PriorityQueue<Node> minNodes;
    
    public StockPrice() {
        current = -1;
        lastTimestamp = -1;
        nodes = new HashMap<>();
        maxNodes = new PriorityQueue<>((x, y) -> Integer.compare(y.val, x.val));
        minNodes = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
    }

    public void update(int timestamp, int price) {
        if(timestamp >= lastTimestamp) {
            lastTimestamp = timestamp;
            current = price;
        }
        Node node = new Node(price, timestamp);
        if(nodes.containsKey(timestamp))
            nodes.get(timestamp).valid = false;
        nodes.put(timestamp, node);
        maxNodes.offer(node);
        minNodes.offer(node);
    }
    
    public int current() {
        return current;
    }
    
    public int maximum() {
        while(!maxNodes.peek().valid) {
            maxNodes.poll();
        }
        return maxNodes.peek().val;
    }
    
    public int minimum() {
        while(!minNodes.peek().valid) {
            minNodes.poll();
        }
        return minNodes.peek().val;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */