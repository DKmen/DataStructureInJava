package AIsubjectProblems.practical2;

import java.util.*;

public class eightPuzzle {

    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void changeBlankSpaceInArray(int[][] currentArray,int oldBlankX,int oldBlankY,int newBlankX,int newBlankY){
        int tempVariable = currentArray[oldBlankX][oldBlankY];
        currentArray[oldBlankX][oldBlankY]=currentArray[newBlankX][newBlankY];
        currentArray[newBlankX][newBlankY]=tempVariable;
    }

    public static int findHInSpecificMovement(int[][] currentState,int[][] finalState,int blankX,int blankY,int movementBlankX,int movementBlankY){
        changeBlankSpaceInArray(currentState,blankX,blankY,movementBlankX,movementBlankY);
        int unArrangeElement=0;
        for(int i=0;i<currentState.length;i++){
            for(int j=0;j<currentState.length;j++){
                if(currentState[i][j]!=finalState[i][j] && currentState[i][j]!=-1) unArrangeElement++;
            }
        }
        return unArrangeElement;
    }

    public static int solvePuzzle(int[][] currentState,int[][] finalState,int blankX,int blankY){
        int h = findHInSpecificMovement(currentState,finalState,blankX,blankY,blankX,blankY);
        System.out.println(blankX+"  "+blankY+"    "+h);
        if(h!=0){
            HashMap<Integer,Integer> movementMap = new HashMap<Integer,Integer>();
            movementMap.put(1,Integer.MAX_VALUE);
            movementMap.put(2,Integer.MAX_VALUE);
            movementMap.put(3,Integer.MAX_VALUE);
            movementMap.put(4,Integer.MAX_VALUE);
            if((blankX-1)>=0 && blankY<currentState[0].length){
                movementMap.put(2,findHInSpecificMovement(currentState,finalState,blankX,blankY,blankX-1,blankY));
                changeBlankSpaceInArray(currentState,blankX-1,blankY,blankX,blankY);
            }
            if((blankX+1)<currentState.length && blankY<currentState[0].length){
                movementMap.put(4,findHInSpecificMovement(currentState,finalState,blankX,blankY,blankX+1,blankY));
                changeBlankSpaceInArray(currentState,blankX+1,blankY,blankX,blankY);
            }
            if(blankX<currentState.length && (blankY+1)<currentState[0].length){
                movementMap.put(1,findHInSpecificMovement(currentState,finalState,blankX,blankY,blankX,blankY+1));
                changeBlankSpaceInArray(currentState,blankX,blankY+1,blankX,blankY);
            }
            if(blankX<currentState.length && (blankY-1)>=0){
                movementMap.put(3,findHInSpecificMovement(currentState,finalState,blankX,blankY,blankX,blankY-1));
                changeBlankSpaceInArray(currentState,blankX,blankY-1,blankX,blankY);
            }
            movementMap = sortByValue(movementMap);
            int firstCount = Integer.MAX_VALUE;
            int minTemp = Integer.MAX_VALUE;
            for(Map.Entry<Integer,Integer> item : movementMap.entrySet()){
                if(firstCount==Integer.MAX_VALUE) firstCount = item.getValue();
                int temp=Integer.MAX_VALUE;
                if(item.getValue()==firstCount){
                    if(item.getKey()==1){
                        changeBlankSpaceInArray(currentState,blankX,blankY,blankX,blankY+1);
                        temp=solvePuzzle(currentState,finalState,blankX,blankY+1);
                    }
                    else if(item.getKey()==2){
                        changeBlankSpaceInArray(currentState,blankX,blankY,blankX-1,blankY);
                        temp=solvePuzzle(currentState,finalState,blankX-1,blankY);
                    }
                    else if(item.getKey()==3){
                        changeBlankSpaceInArray(currentState,blankX,blankY,blankX,blankY-1);
                        temp=solvePuzzle(currentState,finalState,blankX,blankY-1);
                    }
                    else if(item.getKey()==4){
                        changeBlankSpaceInArray(currentState,blankX,blankY,blankX+1,blankY);
                        temp=solvePuzzle(currentState,finalState,blankX+1,blankY);
                    }
                }
                minTemp=Math.min(minTemp,temp);
            }
            return (minTemp+1);
        }
        return 0;
    }

    public static void main(String[] arr){
        int[][] currentState =new int[][]{
                {2,8,3},
                {1,6,4},
                {7,-1,5}
        };
        int[][] finalState =new int[][]{
                {1,2,3},
                {8,-1,4},
                {7,6,5}
        };
        System.out.println(solvePuzzle(currentState,finalState,2,1));
    }
}
