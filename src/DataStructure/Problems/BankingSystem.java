package DataStructure.Problems;

public class BankingSystem {
    public static void main(String[] arr){
        String[] nameArray={"a","abd","abcd","bc","bed","beddd","cddaa","cfed","kvx"};
        String givenString="beddd";

        for(int i=0;i<nameArray.length;i++){
            if(nameArray[i].length()!=givenString.length()) continue;
            if(nameArray[i].charAt(0)==givenString.charAt(0) && nameArray[i].charAt(givenString.length()-1)==givenString.charAt(givenString.length()-1)){
                if(nameArray[i].equals(givenString)){
                    System.out.println(i);
                    break;
                }
            }else if(nameArray[i].charAt(0)>givenString.charAt(0) || nameArray[i].charAt(givenString.length()-1)>givenString.charAt(givenString.length()-1)){
                break;
            }
        }
    }
}
