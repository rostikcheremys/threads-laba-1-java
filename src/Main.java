import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 1; i <= 4; i++) {
            int time = 15000 + random.nextInt(15000);

            ThreadInfo info = new ThreadInfo(i, time);
            Thread thread = new MyThread(info);
            thread.start();
        }
    }
}