package codechef.December2021.longChallenge;

import java.util.Scanner;

public class primedTravels {

    public static int binomialCoefficientNumber(int n, int k){
        if(k==n || k==0) return 1;
        return binomialCoefficientNumber(n-1,k-1)+ binomialCoefficientNumber(n-1,k);
    }

    public static int[] getRowNumber(int startingElement,int endingElement){
        int counter=1;
        int totalElementInNextRow=2;
        int[] rowNumber=new int[]{1,1};
        while (counter<endingElement){
            if(counter < startingElement) rowNumber[0]++;
            rowNumber[1]++;
            counter+=totalElementInNextRow;
            totalElementInNextRow++;
        }
        return rowNumber;
    }

    public static int[] getMinMaxElementInGivenRow(int element,int elemeRowNumber,int givenRow){
        int[] result=new int[]{element,element};
        result[0]=((givenRow)*(givenRow+1)/2)+((elemeRowNumber-1)*2)+element;
        result[1]=((givenRow)*(givenRow+1)/2)+((elemeRowNumber)*2)+element;
        return result;
    }

    public static int getAnswer(int startingElement,int endingElement){
        if(startingElement>endingElement) return 0;
        int[] elementRowNumber= getRowNumber(startingElement,endingElement);
        int startingElementRowNumber =elementRowNumber[0];
        int endingElementRowNumber =elementRowNumber[1];

        if(startingElementRowNumber==endingElementRowNumber) return 0;

        int[] elementMinMaxElementOfEndingRow=getMinMaxElementInGivenRow(startingElement,startingElementRowNumber,endingElementRowNumber-startingElementRowNumber);

        int startingElementOfEndingRow = elementMinMaxElementOfEndingRow[0];
        int endingElementOfEndingRow=elementMinMaxElementOfEndingRow[1];
        int endingElementNumberInPaskalTringal = endingElement - startingElementOfEndingRow;

        if(endingElement<startingElementOfEndingRow || endingElement>endingElementOfEndingRow){
            return 0;
        }else{
            return binomialCoefficientNumber(endingElementRowNumber-startingElementRowNumber,endingElementNumberInPaskalTringal)%1000000007;
        }
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        while (N--!=0){
        int startingElement = sc.nextInt();
        int endingElement= sc.nextInt();
        System.out.println(getAnswer(startingElement,endingElement));
        }
    }
}
