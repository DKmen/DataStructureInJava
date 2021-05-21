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


class DNode{
    private int data;
    private DNode next=null;
    private DNode previous=null;

    public DNode(int data){
        this.data=data;
    }

    public void setNextNode(DNode next){
        this.next=next;
    }

    public DNode getNext(){
        return next;
    }

    public void setPreviousNode(DNode previous){
        this.previous=previous;
    }

    public DNode getPrevious(){
        return previous;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }
}