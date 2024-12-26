public class multithread {
 
    public static void main(String[] args) {
        int n =50;
        multithread ma = new multithread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ma.printeven(n);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ma.printodd(n);
            }
        });
    }

    private void printodd(int n) {
    }

    private void printeven(int n) {
    }


}
