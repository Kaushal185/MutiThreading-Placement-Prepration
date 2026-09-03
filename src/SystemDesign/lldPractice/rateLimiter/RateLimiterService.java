//package SystemDesign.lldPractice.rateLimiter;
///
//import java.sql.Timestamp;
//import java.util.HashMap;
//
//class User{
//    String userId;
//    Timestamp timestamp;
//}
//enum UserTeir{
//    FREE,
//    PREMIUM
//}
//enum RateLimiterType{
//    FIXED_WINDOW,
//    TOKEN_BUCKEt
//}
//class RateLimiterConfig{
//    int maxRequests;
//    int windowInSeconds;
//    RateLimiterConfig(){
//        maxRequests = 5;
//        windowInSeconds = 60;
//    }
//    RateLimiterConfig(int maxRequests,int windowInSeconds){
//        this.maxRequests = maxRequests;
//        this.windowInSeconds = windowInSeconds;
//    }
//}
//class RateLimiterFactory{
//    public RateLimiter createRateLimiter(RateLimiterType rateLimiterType,RateLimitConfig rateLimitConfig){
//        return new RateLimiterConfig()
//    }
//
//}
//public class RateLimiterService {
//    private final HashMap<User,UserTeir> ratelimiter = new HashMap<>();
//    public RateLimiterService(){
//
//
//    }
//    static void main() {
//
//    }
//}
