package DataStructure.LinearDataStructure.list;

class Node{
    private final int data;
    private Node next=null;

    public Node(int data){
        this.data=data;
    }

    public void setNode(Node next){
        this.next=next;
    }

    public Node getNext(){
        return next;
    }

    public int getData(){
        return data;
    }
}