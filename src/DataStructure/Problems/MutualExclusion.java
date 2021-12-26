package DataStructure.Problems;

public class MutualExclusion {

    private static int Mux=1;
    private static int Keyboard =1;
//    private static int ProcessOrder=0;
//
//    public static void waitFunctionProcess(int i){
//        while (ProcessOrder==i) Thread.onSpinWait();
//    }
//
//    public static void signalFunctionProcess(){
//        Mux++;
//    }

    public static void waitFunctionMux(){
        while (Mux <= 0) Thread.onSpinWait();
        Mux--;
    }

    public static void signalFunctionMux(){
        Mux++;
    }

    public static void waitFunctionKeyboard() throws InterruptedException {
        while (Keyboard <= 0) Thread.onSpinWait();
        Keyboard--;
    }

    public static void signalFunctionKeyboard() throws InterruptedException {
        Thread.sleep(3000);
        Keyboard++;
    }

    public static void printName(){
        System.out.println("C.S");
    }

    public static void firstProcess() throws InterruptedException {
        System.out.println(" process 1");
        waitFunctionMux();
        waitFunctionKeyboard();
        printName();
        signalFunctionKeyboard();
        signalFunctionMux();
    }

    public static void secondProcess() throws InterruptedException {
        System.out.println(" process 2");
        waitFunctionMux();
        waitFunctionKeyboard();
        printName();
        signalFunctionKeyboard();
        signalFunctionMux();
    }

    public static void main(String[] arr) throws InterruptedException {
        firstProcess();
        secondProcess();
    }
}
