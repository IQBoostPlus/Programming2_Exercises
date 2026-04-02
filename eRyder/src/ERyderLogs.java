
import java.time.LocalDateTime;

public class ERyderLogs {
    String log;
    String event;
    LocalDateTime timeStamp;
    public ERyderLogs(String log, String event, LocalDateTime timeStamp) {
        this.log = log;
        this.event = event;
        this.timeStamp = timeStamp;
    }
    public String getLog() {
        return log;
    }
    public void setLog(String log) {
        this.log = log;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void viewSystemLogs()    {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "ERyderLogs:" + "\n" + 
                "log : " + log + "\n" + 
                "event : " + event + "\n" + 
                "timeStamp : " + timeStamp;
    }
}
