package SystemDesign.lldPractice.loggerSystem;

/*
    Logger levels
    INFO -> WARN -> ERROR

    log.info("User signedup: userId = 123");
    log.info("product added to cart: iphone 17")

    log.warn("User tried to apply expired coupon: CODE123");
    log.warn("API rate limit almost reached for userId = 1121");

    log.error("Failed to connect to database");
    log.error("Email sending failed for userId = 123 due to SMTP timeout");


    Requirements:
    Extensible

    1. what log levels are supported?
    -> INFO,WARN,ERROR and we able to add new log leves later.

    2. what should be the output destination of the message?
    -> console and file but it should be extensible.

    3. In what format, we should log the message?
    -> plain text and JSON but again it should be extensible.

    High Traffic

    1. Should the logger work correctly when multiple threads log at the same time? (Yes)
    -> Example : If Thread 1 wants to log "World) and Thread 2 wants to log "Shubh", the output should not be "SWorldDhubh"
        output should like "WorldShubh" or "ShubhWorld"

 */


public class LoggerSystem {

    public static void main(String[] args) {

    }
}
