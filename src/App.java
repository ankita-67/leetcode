public class App {

    private static int counter = 0;

    public static synchronized void increment() {
        //synchronized (this) {
            for (int i = 0; i < 100_000; i++) {
                counter++;
            }
      //  }
    }

    public static void main(String[] args) throws Exception {
        var threadOne = new Thread(App::increment);
        var threadTwo = new Thread(App::increment);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("Value : " + counter);
    }

}
