package SystemDesign.lldPractice.rateLimiter;

import java.util.*;

class RateLimiter {

    private final int maxRequests;
    private final long windowSizeInMillis;

    // userId -> timestamps of requests
    private Map<String, Deque<Long>> userRequests;

    public RateLimiter(int maxRequests, long windowSizeInSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInSeconds * 1000;
        this.userRequests = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();

        userRequests.putIfAbsent(userId, new LinkedList<>());
        Deque<Long> timestamps = userRequests.get(userId);

        // Remove expired requests
        while (!timestamps.isEmpty() &&
                currentTime - timestamps.peekFirst() >= windowSizeInMillis) {
            System.out.println(currentTime - timestamps.peekFirst());
            timestamps.pollFirst();
        }

        // Check limit
        if (timestamps.size() < maxRequests) {
            timestamps.addLast(currentTime);
            return true;
        }

        return false;
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {

        RateLimiter limiter = new RateLimiter(3, 5); // 3 requests per 5 seconds

        String user = "user1";

        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " allowed: " + allowed);
            Thread.sleep(1000);
        }
    }
}