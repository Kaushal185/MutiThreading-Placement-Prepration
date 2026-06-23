package SystemDesign.lldPractice.loggerSystem.handlers;
/*
import SystemDesign.lldPractice.loggerSystem.model.LogMessage;

import java.util.concurrent.CopyOnWriteArrayList;
/
public abstract class LogHandler {
    public void setNext(LogHandler next) {
        this.next = next;
    }

    protected LogHandler next;
    protected final List<LogAppender> appenders = new CopyOnWriteArrayList<>();
    public void subscribe(LogAppender observer){
        appenders.add(observer);
    }

    public void notifyObservers(LogMessage message){
        for(LogAppender appender: appenders){
            appender.append(message);
        }
    }
    public void handle(LogMessage message){

    }
    protected abstract boolean canHandle(logLevel level);

}

 */
