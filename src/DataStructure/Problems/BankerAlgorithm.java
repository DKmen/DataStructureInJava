package DataStructure.Problems;

import java.util.Scanner;

public class BankerAlgorithm {
    int n;
    int m;
    int [][]need;
    int [][]max;
    int [][]alloc;
    int []avail;
    int []safeSequence;

    public BankerAlgorithm(int totalProcess,int totalResources,int[][] alloc,int[][] max,int[] avail){
        n=totalProcess;
        m=totalResources;
        need=new int[n][m];
        safeSequence=new int[n];
        this.alloc=alloc;
        this.max=max;
        this.avail=avail;
    }

    void requestMoreResource(int processNumber, int[] resourceArray){
        for(int i=0;i<alloc[processNumber].length;i++){
            max[processNumber][i]+=resourceArray[i];
        }
    }

//    void initializeValues()
//    {
//        // P0, P1, P2, P3, P4 are the Process names here
//        // Allocation Matrix
//        alloc = new int[][] { { 0, 1, 0 }, //P0
//                { 2, 0, 0 }, //P1
//                { 3, 0, 2 }, //P2
//                { 2, 1, 1 }, //P3
//                { 0, 0, 2 } }; //P4
//
//        // MAX Matrix
//        max = new int[][] { { 7, 5, 3 }, //P0
//                { 3, 2, 2 }, //P1
//                { 9, 0, 2 }, //P2
//                { 2, 2, 2 }, //P3
//                { 4, 3, 3 } }; //P4
//
//        // Available Resources
//        avail = new int[] { 3, 3, 2 };
//    }

    void isSafe()
    {
        int count=0;

        //visited array to find the already allocated process
        boolean visited[] = new boolean[n];
        for (int i = 0;i < n; i++)
        {
            visited[i] = false;
        }

        //work array to store the copy of available resources
        int work[] = new int[m];
        for (int i = 0;i < m; i++)
        {
            work[i] = avail[i];
        }

        while (count<n)
        {
            boolean flag = false;
            for (int i = 0;i < n; i++)
            {
                if (visited[i] == false)
                {
                    int j;
                    for (j = 0;j < m; j++)
                    {
                        if (need[i][j] > work[j])
                            break;
                    }
                    if (j == m)
                    {
                        safeSequence[count++]=i;
                        visited[i]=true;
                        flag=true;

                        for (j = 0;j < m; j++)
                        {
                            work[j] = work[j]+alloc[i][j];
                        }
                    }
                }
            }
            if (flag == false)
            {
                break;
            }
        }
        if (count < n)
        {
            System.out.println("The System is UnSafe!");
        }
        else
        {
            //System.out.println("The given System is Safe");
            System.out.println("Following is the SAFE Sequence");
            for (int i = 0;i < n; i++)
            {
                System.out.print("P" + safeSequence[i]);
                if (i != n-1)
                    System.out.print(" -> ");
            }
            System.out.println();
        }
    }

    void calculateNeed()
    {
        for (int i = 0;i < n; i++)
        {
            for (int j = 0;j < m; j++)
            {
                need[i][j] = max[i][j]-alloc[i][j];
            }
        }
    }

    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        int totalProcess=sc.nextInt();
        int totalNumberOfResources= sc.nextInt();

        int[][] allocateResourcesArray=new int[totalProcess][totalNumberOfResources];
        int[][] maxAllocationResourcesArray=new int[totalProcess][totalNumberOfResources];
        int[] availableResources=new int[totalNumberOfResources];

        for(int i=0;i<allocateResourcesArray.length;i++){
            for(int j=0;j<allocateResourcesArray[i].length;j++){
                int tempVariable=sc.nextInt();
                allocateResourcesArray[i][j]=tempVariable;
            }
        }

        for(int i=0;i<maxAllocationResourcesArray.length;i++){
            for(int j=0;j<maxAllocationResourcesArray[i].length;j++){
                int tempVariable=sc.nextInt();
                maxAllocationResourcesArray[i][j]=tempVariable;
            }
        }

        for(int i=0;i<availableResources.length;i++){
            int tempVariable=sc.nextInt();
            availableResources[i]=tempVariable;
        }

        BankerAlgorithm gfg = new BankerAlgorithm(totalProcess,totalNumberOfResources,allocateResourcesArray,maxAllocationResourcesArray,availableResources);

        gfg.calculateNeed();
        gfg.isSafe();

        gfg.requestMoreResource(2,new int[]{5,0,0});
        gfg.calculateNeed();
        gfg.isSafe();
    }

}
