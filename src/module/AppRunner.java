package module;

public class AppRunner {

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        Runnable a = () -> System.out.println("first");
        Runnable b = () -> System.out.println("second");
        Runnable c = () -> System.out.println("third");


        Thread thread1 = new Thread(() -> {
            try {
                foo.first(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                foo.second(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                foo.third(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
