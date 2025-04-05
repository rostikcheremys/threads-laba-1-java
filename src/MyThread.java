import java.math.BigInteger;

public class MyThread extends Thread {
    private final ThreadInfo info;

    public MyThread(ThreadInfo info) {
        this.info = info;
    }

    @Override
    public void run() {
        BigInteger number = BigInteger.valueOf(0);
        BigInteger sum = BigInteger.valueOf(0);

        long endTime = System.currentTimeMillis() + info.timeToRun();

        while (System.currentTimeMillis() < endTime) {
            sum = sum.add(number);
            number = number.add(BigInteger.ONE);
        }

        System.out.printf("\n[Потік №%d] завершився через %.1f сек.\n", info.id(), info.timeToRun() / 1000.0);
        System.out.println("Кількість елементів: " + number);
        System.out.println("Сума: " + sum);
    }
}
