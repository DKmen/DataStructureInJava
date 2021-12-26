package DataStructure.M_StringMatchingAlgorithm;

public class RabinKarpAlgorithm {

    public static int getHashCode(String str){
        int tenthPower = str.length()-1;
        int hashCode=0;
        for(int i=0;i<str.length();i++){
            hashCode+=(int)str.charAt(i)*Math.pow(10,tenthPower);
        }
        return hashCode ;
    }

    public static void main(String[] arr){
        String textString = "ccaccaaedbaaedbaea";
        String pattern = "aae";
        int patternHashCode = getHashCode(pattern);
        int totalMatchingPattern = 0;

        for(int i=0;i<=textString.length()-pattern.length();i++){
            int subStringHashCode = getHashCode(textString.substring(i,i+pattern.length()));
            if(subStringHashCode==patternHashCode){
                if(textString.startsWith(pattern, i)) totalMatchingPattern++;
            }
        }
        System.out.println(totalMatchingPattern);
    }
}
