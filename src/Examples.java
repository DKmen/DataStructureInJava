

public class Examples {
    public static void main(String[] arr){
        int[][] inputArray={{0,2,6,7},{0,4,8,3},{0,9,5,1}};
        int minTime=0;
        for(int i=1;i<inputArray[0].length;i++){
            int min=Integer.MAX_VALUE;
            int selectedIndex=0;
            for(int j=0;j<inputArray.length;j++){
                if(inputArray[j][0]==1) continue;
                if(min>inputArray[j][i]){
                    selectedIndex=j;
                    min=inputArray[j][i];
                }
            }
            inputArray[selectedIndex][0]=1;
            System.out.println(min);
        }
    }
}
