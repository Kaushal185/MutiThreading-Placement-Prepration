package SystemDesign.lldPractice.rate_limiter.factory;

import SystemDesign.lldPractice.rate_limiter.enums.RateLimitType;
import SystemDesign.lldPractice.rate_limiter.limiter.*;
import SystemDesign.lldPractice.rate_limiter.model.RateLimitConfig;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimitType algo, RateLimitConfig config) {
        return switch (algo) {
            case TOKEN_BUCKET -> new TokenBucketRateLimiter(config);
            case FIXED_WINDOW -> new FixedWindowRateLimiter(config);
            case SLIDING_WINDOW_LOG -> new SlidingWindowLogRateLimiter(config);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algo);
        };
    }
}