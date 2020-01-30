package com.sumitranjan.encript_descipt;



public class EncryptMethods {
public static String encryptString(String text){
      String encrypted="";//hello

        for (int i=0;i<text.length();i++){
            int count=0;
            count++;

            for ( int j=i+1 ; j < text.length(); j++) {
                if (text.charAt(i) == (text.charAt(j))) {
                    count++;
                    i=j;
                }
                break;
            }
          //  j=j+count;
            encrypted=encrypted+text.charAt(i)+count;
        }

return encrypted;
}


}
