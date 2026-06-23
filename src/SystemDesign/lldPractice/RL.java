package SystemDesign.lldPractice;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class RateLimiter{
    private final int maxRequest;
    private final long windowSizeMili;
    HashMap<String, Deque<Long>> userRequest;
    RateLimiter(int maxRequest,long windowSizeMili){
        this.maxRequest = maxRequest;
        this.windowSizeMili = windowSizeMili * 1000;
        userRequest = new HashMap<>();
    }
    public synchronized boolean allowRequest(String userId){
        long currentTime = System.currentTimeMillis();
        userRequest.putIfAbsent(userId,new LinkedList<>());
        Deque<Long> timestamps = userRequest.get(userId);

        while(!timestamps.isEmpty() && currentTime - timestamps.peekFirst() >= windowSizeMili){
            timestamps.pollFirst();
        }
        if(timestamps.size() < maxRequest){
            timestamps.addLast(currentTime);
            return true;
        }
        return false;
    }
}
public class RL {
    public static void main(String[] args) throws InterruptedException{
        RateLimiter limiter = new RateLimiter(3, 5); // 3 requests per 5 seconds

        String user = "user1";

        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " allowed: " + allowed);
            Thread.sleep(1000);
        }
    }
}
