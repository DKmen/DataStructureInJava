package DataStructure.J_DynamicPrograming;

public class MatrixChainMultiplication {

    public static void printOptimalParathise(int[][] s,int i,int j){
        if(i==j) System.out.print("A");
        else {
            System.out.print("(");
            printOptimalParathise(s,i,s[i][j]);
            printOptimalParathise(s,s[i][j]+1,j);
            System.out.print(")");
        }
    }

    public static void main(String[] arr){
        int realSize=6;
        int element=realSize+1;
        int[] dimensionArray={30,35,15,5,10,20,25};
        int[][] m=new int[element][element];
        int[][] s=new int[element][element];
        for(int d=1;d<element-1;d++){
            for(int i=1;i<element-d;i++){
                int j=i+d;
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int temp=m[i][k]+m[k+1][j]+dimensionArray[i-1]*dimensionArray[k]*dimensionArray[j];
                    if(min>temp){
                        min=temp;
                        s[i][j]=k;
                    }
                }
                m[i][j]=min;
            }
        }
        System.out.println(m[1][6]);
        printOptimalParathise(s,1,6);
    }
}
