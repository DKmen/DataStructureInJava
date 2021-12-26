package DataStructure.Problems;

import java.util.Arrays;

public class bestFitMemoryAllocation {
    public static void bestMemoryAllocationMethod(int[] memoryBlock,int[] processBlock){
        int[] allocateProcess=new int[processBlock.length];
        Arrays.fill(allocateProcess,-1);

        for(int i=0;i<processBlock.length;i++){
            int allocationSize=Integer.MAX_VALUE;
            int allocationInsex=-1;
            for(int j=0;j<memoryBlock.length;j++){
                if(processBlock[i]<=memoryBlock[j] && memoryBlock[j]<allocationSize){
                    allocationSize=memoryBlock[j];
                    allocationInsex=j;
                }
            }
            if(allocationInsex!=-1){
                allocateProcess[i]=allocationInsex+1;
                memoryBlock[allocationInsex]-=processBlock[i];
            }
        }

        System.out.println("No. Size Block");
        for(int i=0;i<processBlock.length;i++){
            if(allocateProcess[i]!=-1) System.out.println(" "+(i+1)+"   "+processBlock[i]+"  "+allocateProcess[i]);
            else System.out.println(" "+(i+1)+"   "+processBlock[i]+"  not allocate");
        }
    }

    public static void main(String[] arr){
//        Scanner sc=new Scanner(System.in);
//
//        System.out.println("Enter number of memory block");
//        int totalMemoryBlock=sc.nextInt();
//        int[] memoryBlock=new int[totalMemoryBlock];
//        for(int i=0;i<memoryBlock.length;i++) memoryBlock[i]=sc.nextInt();
//
//
//        System.out.println("Enter total number of process ");
//        int totalProcessBlock=sc.nextInt();
//        int[] processBlock =new int[totalProcessBlock];
//        for(int i=0;i<processBlock.length;i++) processBlock[i]=sc.nextInt();
//
//        System.out.println("input memory block");
//        for(int item : memoryBlock) System.out.print(item+" ");
//        System.out.println();
//
//        System.out.println("input process block");
//        for(int item : processBlock) System.out.print(item+" ");
//
//        System.out.println();
        int[] memoryBlock={200,400,200,100,550,25};
        int[] processBlock={115,400,258,100,275};
        bestMemoryAllocationMethod(memoryBlock,processBlock);
    }
}
