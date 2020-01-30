package com.sumitranjan.encript_descipt;

public class DecryptionMethod {

    public static String decryptionString(String text){
        String decryption="";//hello

        for (int i=0;i<text.length();i++){

            for (int j=0;j<Integer.parseInt(String.valueOf(text.charAt(i+1)));j++){
                decryption=decryption+text.charAt(i);

            }
            i++;

        }

        return decryption;
    }

}
