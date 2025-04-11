public class ThreadInfo {
    private final int id;
    private final int timeInSeconds;
    private Thread thread;
    private long startTime;
    private volatile boolean shouldStop;

    public ThreadInfo(int id, int timeInMillis) {
        this.id = id;
        this.timeInSeconds = timeInMillis;
    }

    public int getId() {
        return id;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Thread getThread() {
        return thread;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public boolean shouldStop() {
        return !shouldStop;
    }

    public void setShouldStop(boolean shouldStop) {
        this.shouldStop = shouldStop;
    }
}
