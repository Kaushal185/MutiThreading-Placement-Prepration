package SystemDesign.lldPractice.loggerSystem.formatter;

import SystemDesign.lldPractice.loggerSystem.model.LogMessage;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PlainTextFormatter implements LogFormatter{
    private static final DateTimeFormatter FFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public String format(LogMessage message) {
        String formattedTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(message.getTimestamp()), ZoneId.systemDefault()
        ).format(FFORMATTER);

        return String.format("%s [%s] - %s",formattedTime,message.getMessage());
    }
}
