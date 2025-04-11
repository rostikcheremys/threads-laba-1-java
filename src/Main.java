import java.util.Random;

public class Main {
    private static final int NUMBER_OF_THREADS = 4;
    private final Random random = new Random();

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        ThreadInfo[] threads = new ThreadInfo[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int threadId = i + 1;
            int timeInMillis = 10000 + random.nextInt(20000);

            threads[i] = new ThreadInfo(threadId, timeInMillis);
            System.out.printf("Потiк №%d почав виконання на %.1f сек.\n", threadId, timeInMillis / 1000.0);
        }

        for (ThreadInfo info : threads) {
            Thread thread = new Thread(() -> counter(info));
            info.setThread(thread);
            info.setStartTime(System.currentTimeMillis());
            thread.start();
        }

        Thread managerThread = new Thread(() -> manageThreads(threads));
        managerThread.start();
    }

    private void counter(ThreadInfo info) {
        long sum = 0;
        long count = 0;

        info.setStartTime(System.currentTimeMillis());

        while (info.shouldStop()) {
            sum += count;
            count++;
        }

        System.out.printf("\n[Потiк #%d] зупинено через %.1f сек.\n", info.getId(), info.getTimeInSeconds() / 1000.0);
        System.out.println("Кiлькiсть елементiв: " + count);
        System.out.println("Сума: " + sum);
    }

    private void manageThreads(ThreadInfo[] threadInfo) {
        boolean isFinished = false;

        while (!isFinished) {
            isFinished = true;

            for (ThreadInfo info : threadInfo) {
                if (info.shouldStop() && System.currentTimeMillis() - info.getStartTime() >= info.getTimeInSeconds()) {
                    info.setShouldStop(true);
                }

                if (info.shouldStop()) {
                    isFinished = false;
                }
            }
        }
    }
}
