package InformationSecurity;

public class practical1_caesarCipher {
    public static int generateKey(){
        return (int)(Math.random()*26);
    }

    public static String encryptData(String planeTxt, int key){
        String cryptText = "";
        for(int i=0;i<planeTxt.length();i++){
            int charNumber = (int)planeTxt.charAt(i);
            charNumber=(charNumber-65+key)%26+65;
            cryptText+=String.valueOf((char)charNumber);
        }
        return cryptText;
    }

    public static String decryptData(String createdText,int key){
        String planText = "";
        for(int i=0;i<createdText.length();i++){
            int charNumber = (int)createdText.charAt(i);
            if(charNumber-65-key<0){
                charNumber=26+charNumber-key+1;
            }
            else charNumber=(charNumber-65-key)%26+65;
            planText+=String.valueOf((char)charNumber);
        }
        return planText;
    }

    public static void decryptAnalyse(String createdText){
        for(int key=1;key<=26;key++) {
            String planText = "";
            for (int i = 0; i < createdText.length(); i++) {
                int charNumber = (int) createdText.charAt(i);
                if (charNumber - 65 - key < 0) {
                    charNumber = 26 + charNumber - key + 1;
                } else charNumber = (charNumber - 65 - key) % 26 + 65;
                planText += String.valueOf((char) charNumber);
            }
            System.out.println(planText);
        }
    }

    public static void main(String[] arr){
        int key = generateKey() | 1;
        System.out.println(key);
        System.out.println(encryptData("ABCD",key));
        System.out.println(decryptData(encryptData("ABCD",key),key));
        decryptAnalyse(decryptData(encryptData("ABCD",key),key));
    }
}
