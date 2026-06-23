package SystemDesign.lldPractice.loggerSystem.formatter;

import SystemDesign.lldPractice.loggerSystem.model.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}
