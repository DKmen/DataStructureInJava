package DataStructure.I_Queue;

public class QueueArray {
    private int[] queueArray;
    private int front=-1;
    private int rear=-1;

    public QueueArray(int size){
        queueArray=new int[size];
    }

    public void enQueue(int data){
        if(rear==-1 && front==-1){
            rear++;
            front++;
            queueArray[rear]=data;
            return;
        }

        if((rear+1)<queueArray.length){
            rear++;
            queueArray[rear]=data;
            return;
        }
        System.out.println("queue is full");
    }

    public void deQueue(){
        if(front==-1 || front>rear){
            System.out.println("queue is empty");
            return;
        }
        queueArray[front]=0;
        front++;
    }

    public int peek(){
        if(front==-1 || front>rear) return -1;
        return queueArray[front];
    }

    public boolean isEmpty(){
        return front == -1 || front > rear;
    }

    public void display(){
        if(front==-1 || front>rear){
            System.out.println("queue is empty");
            return;
        }

        for (int i=front;i<=rear;i++) System.out.print(queueArray[i]+" ");
        System.out.println();
    }

    public static void main(String[] arr){
        QueueArray queue= new QueueArray(4);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.display();
        System.out.println(queue.peek());
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue.isEmpty());
    }
}
