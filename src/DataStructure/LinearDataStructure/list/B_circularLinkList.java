package DataStructure.LinearDataStructure.list;


public class B_circularLinkList {
    private Node head=null;

    public Node getHead(){
        return head;
    }

    public void setHead(Node head){
        this.head=head;
    }
    //Insert Data Into circular list
    public void insertDataAtFront(int data){
        Node newNode=new Node(data);
        Node iterable=head;

        if(head==null){
            head=newNode;
            newNode.setNode(newNode);
            return;
        }

        while (iterable.getNext()!=head) iterable=iterable.getNext();
        iterable.setNode(newNode);
        newNode.setNode(head);
        head=newNode;
    }

    public void insertDataAtEnd(int data){
        Node newNode=new Node(data);
        Node iterable=head;

        if(head==null){
            head=newNode;
            newNode.setNode(newNode);
            return;
        }

        while (iterable.getNext()!=head) iterable=iterable.getNext();
        iterable.setNode(newNode);
        newNode.setNode(head);
    }

    public void insertDataIntoSortedList(int data){
        Node newNode=new Node(data);
        Node iterable=head;

        if(head==null){
            head=newNode;
            newNode.setNode(newNode);
        }else if(iterable.getData()>data){
            insertDataAtFront(data);
        }else{
            while (iterable.getNext()!=head && iterable.getNext().getData()<data){
                iterable=iterable.getNext();
            }
            newNode.setNode(iterable.getNext());
            iterable.setNode(newNode);
        }
    }

    //Split circular list into two part
    private Node getSplitPoint(){
        Node fastJumpNode=head;
        Node slowJumpNode=head;

        while (fastJumpNode.getNext()!=head && fastJumpNode.getNext().getNext()!=head){
            slowJumpNode=slowJumpNode.getNext();
            fastJumpNode=fastJumpNode.getNext().getNext();
        }
        return slowJumpNode;
    }
    public void splitCircularList(B_circularLinkList ListA,B_circularLinkList ListB){
        if(head==null || head.getNext()==null) return;

        Node splitPositionNode=getSplitPoint();
        ListA.setHead(head);
        ListB.setHead(splitPositionNode.getNext());

        splitPositionNode.setNode(ListA.getHead());
        Node iterate=ListB.getHead();
        while (iterate.getNext()!=ListA.getHead()) iterate=iterate.getNext();
        iterate.setNode(ListB.getHead());
    }

    //print circular link list

    void printList(){
        Node iterate=head;

        if (head==null) return;

        while (iterate.getNext()!=head){
            System.out.print(iterate.getData()+"  ");
            iterate=iterate.getNext();
        }
        System.out.print(iterate.getData());
        System.out.println();
    }
}