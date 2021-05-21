package DataStructure.LinearDataStructure.list;

public class C_DoublyLinkList {
    private DNode head=null;

    //set and get head pointer
    public void setHead(DNode head){
        this.head=head;
    }
    public DNode getHead(){
        return head;
    }

    //add node in doubly list
    public void insertDataAtFront(int data){
        DNode newNode=new DNode(data);

        if(head==null){
            head=newNode;
            return;
        }

        newNode.setNextNode(head);
        head.setPreviousNode(newNode);
        head=newNode;
    }

    public void insertDataAtEnd(int data){
        DNode newNode=new DNode(data);

        if(head==null){
            head=newNode;
            return;
        }

        DNode iterative=head;
        while (iterative.getNext()!=null) iterative=iterative.getNext();
        iterative.setNextNode(newNode);
        newNode.setPreviousNode(iterative);
    }

    public void insertDataAtPosition(int data,int position){
        DNode newNode=new DNode(data);
        int countIndex=1;
        DNode iterative=head;

        if(head==null){
            head=newNode;
            return;
        }else if(position==1){
            insertDataAtFront(data);
            return;
        }

        while (iterative.getNext()!=null && countIndex<position){
            iterative=iterative.getNext();
            countIndex++;
        }

        newNode.setNextNode(iterative);
        newNode.setPreviousNode(iterative.getPrevious());

        if(iterative.getPrevious()!=null){
            iterative.getPrevious().setNextNode(newNode);
        }
        iterative.setPreviousNode(newNode);
    }

    //delete node doubly from list
    public void deleteNode(int position){
        DNode iterative=head;
        int countIndex=1;

        while (iterative.getNext()!=null && countIndex<position){
            iterative=iterative.getNext();
            countIndex++;
        }

        if(iterative.getPrevious()!=null){
            iterative.getPrevious().setNextNode(iterative.getNext());
        }else{
            head=head.getNext();
            head.setPreviousNode(null);
            return;
        }
        if(iterative.getNext()!=null){
            iterative.getNext().setPreviousNode(iterative.getPrevious());
        }else {
            iterative.getPrevious().setNextNode(null);
            iterative.setPreviousNode(null);
            iterative.setNextNode(null);
        }
    }

    //reverse list
    public void reverseList(){
        DNode iterative=head;

        while (iterative.getNext()!=null){
            DNode temp=iterative.getPrevious();
            iterative.setPreviousNode(iterative.getNext());
            iterative.setNextNode(temp);
            iterative=iterative.getPrevious();
        }
        DNode temp=iterative.getPrevious();
        iterative.setPreviousNode(iterative.getNext());
        iterative.setNextNode(temp);
        head=iterative;
    }

    //swap node data in double link list
    public void swap(DNode nodeA,DNode nodeB){
        int team=nodeA.getData();
        nodeA.setData(nodeB.getData());
        nodeB.setData(team);
    }
    public void swapNode(DNode nodeA,DNode nodeB){
        DNode tempNext=nodeA.getNext();
        DNode tempPrevious=nodeA.getPrevious();


        nodeA.setNextNode(nodeB.getNext());
        nodeA.setPreviousNode(nodeB.getPrevious());
        nodeB.setNextNode(tempNext);
        nodeB.setPreviousNode(tempPrevious);

        if(nodeA.getPrevious()!=null) nodeA.getPrevious().setNextNode(nodeB);
        if(nodeA.getNext()!=null) nodeA.getNext().setPreviousNode(nodeB);

        if(nodeB.getPrevious()!=null) nodeB.getPrevious().setNextNode(nodeA);
        if(nodeB.getNext()!=null) nodeB.getNext().setPreviousNode(nodeA);
    }

    //quick sort on doubly link list
    private DNode partitionSort(DNode start, DNode end){
        int key=end.getData();
        DNode swapping=start;
        DNode iterative=start;

        while (iterative!=end){
            if(iterative.getData()<=key){
                swap(swapping,iterative);
                swapping=swapping.getNext();
            }
            iterative=iterative.getNext();
        }
        swap(swapping,end);
        return swapping;
    }
    private void quickSort(DNode start,DNode end){
        if(start!=null && end!=null && start!=end && start!=end.getNext()){
            DNode partitionNode= partitionSort(start,end);
            quickSort(start,partitionNode.getPrevious());
            quickSort(partitionNode.getNext(),end);
        }
    }
    private DNode lastNode(){
        DNode iterative=head;
        while (iterative.getNext()!=null) iterative=iterative.getNext();
        return iterative;
    }
    public void sort(){
        quickSort(head,lastNode());
    }

    //merge sort on doubly link list
    private DNode getMiddleNode(DNode start){
        DNode slowJumpNode=start;
        DNode fastJumpNode=start;

        while (fastJumpNode.getNext()!=null && fastJumpNode.getNext().getNext()!=null){
            slowJumpNode=slowJumpNode.getNext();
            fastJumpNode=fastJumpNode.getNext().getNext();
        }
        DNode ret=slowJumpNode.getNext();
        slowJumpNode.setNextNode(null);
        return ret;
    }
    private DNode mergeList(DNode ListA,DNode ListB){
        DNode result=new DNode(-1);
        DNode iterate=result;
        while (ListA!=null && ListB!=null){
            if(ListA.getData()<ListB.getData()){
                iterate.setNextNode(new DNode(ListA.getData()));
                ListA=ListA.getNext();
            }else {
                iterate.setNextNode(new DNode(ListB.getData()));
                ListB=ListB.getNext();
            }
            iterate=iterate.getNext();
        }

        if(ListA!=null) iterate.setNextNode(ListA);
        if(ListB!=null) iterate.setNextNode(ListB);
        return result.getNext();
    }
    private DNode mergeSort(DNode head){

        if(head==null || head.getNext()==null) return head;

        DNode midNode = getMiddleNode(head);

        DNode left=mergeSort(head);
        DNode right=mergeSort(midNode);

        return mergeList(left,right);
    }
    public void mergeSortList(){
        head=mergeSort(head);
    }


    //print list
    public void printList(){
        DNode iterative=head;

        if(head==null) return;

        while (iterative!=null){
            System.out.print(iterative.getData()+"  ");
            iterative=iterative.getNext();
        }
        System.out.println();
    }
}
