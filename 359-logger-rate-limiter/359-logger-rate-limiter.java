class Message {
    String message;
    int timestamp;
    
    Message(String message, int timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
class Logger {

    final int SECONDS_DIFFERENCE = 10; 
    Deque<Message> deque;
    Set<String> set;
    public Logger() {
        deque = new LinkedList<>();
        set = new HashSet<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!deque.isEmpty() && timestamp - deque.getLast().timestamp >= SECONDS_DIFFERENCE) {
            set.remove(deque.getLast().message);
            deque.removeLast();
        }
        boolean shouldPrintMessage = !set.contains(message);
        if(shouldPrintMessage) {
            deque.addFirst(new Message(message, timestamp));
            set.add(message);
        }
    
        return shouldPrintMessage;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */