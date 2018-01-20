public class AnonClass {

    static class X {
        int a = 10;
    }

    static <T extends X> void myFun(T t) {
        System.out.println(
                t.getClass().getName()
        );
    }

    public static void main(String[] args) {

        myFun(new X() {
            int b = 10;
        });

    }

    // Valid inside main:
    /*
    new X() {
        int b = 5;
    }
    */
}
