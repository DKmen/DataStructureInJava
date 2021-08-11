package DataStructure.LinearDataStructure.queue;

public class tested {
    public static void main(String[] arr){
        A_ArrayQueue a=new A_ArrayQueue(10);
        a.enQueue(1);
//        a.enQueue(4);
//        a.enQueue(5);
//        a.enQueue(6);
//        a.enQueue(7);
//        a.enQueue(8);
//        a.enQueue(9);
//        a.enQueue(10);
//        a.enQueue(13);
//        a.enQueue(14);
//        a.enQueue(12);
        a.printQueue();
        a.deQueue();
        a.deQueue();
        a.printQueue();
    }
}
