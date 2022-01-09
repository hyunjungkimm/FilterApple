package Runnable_;

public class Test4 {
    public static void main(String[] args) {

        Thread t = new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });

        t.run();

        Thread t1 = new Thread(() -> System.out.println("Hello World"));
        t1.run();
    }
}
