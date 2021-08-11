package DataStructure.LinearDataStructure.queue;

public class A_ArrayQueue {
    private int front=0;
    private int rear=-1;
    private int size=0;
    private final int capacity;
    private int[] Array;

    public A_ArrayQueue(int capacity){
        this.capacity =capacity;
        this.Array=new int[capacity];
    }

    public boolean isFull(){
        return size== capacity;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void enQueue(int data){
        if(this.isFull()) return;
        rear=(rear+1)%capacity;
        Array[rear]=data;
        size++;
    }

    public void deQueue(){
        if(this.isEmpty()) return;
        front=(front+1)%capacity;
        size--;
    }

    public int getFront(){
        if(this.isEmpty()) return Integer.MIN_VALUE;
        return Array[front];
    }

    public int getRear(){
        if(this.isEmpty()) return Integer.MIN_VALUE;
        return Array[rear];
    }

    public void printQueue(){
        if(this.isEmpty()) return;
        if(rear<front){
            for (int i=front;i<capacity;i++) System.out.print(Array[i]+" ");
            for (int i=0;i<=rear;i++) System.out.print(Array[i]+" ");
        }else {
            for (int i=front;i<=rear;i++) System.out.print(Array[i]+" ");
        }
        System.out.println();
    }
}
