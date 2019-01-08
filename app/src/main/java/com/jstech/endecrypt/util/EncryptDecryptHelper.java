package com.jstech.endecrypt.util;

import java.util.ArrayList;
import java.util.Iterator;

public class EncryptDecryptHelper {
    public String encrypt(String str){
        String temp = "";
        char[] strArray = str.toCharArray();
        ArrayList<Character> data = new ArrayList<>();
        for(int i=0; i<strArray.length; i++) {
            char tempChar = strArray[i];
            int count = 1;
            data.add(strArray[i]);
            if(tempChar != ' ') {
                while(i<strArray.length-1 && strArray[i+1] == tempChar) {
                    count++;
                    i++;
                }
                data.add(Character.forDigit(count, 10));
            }
        }
        Iterator<Character> iterator = data.iterator();
        while(iterator.hasNext()) {
            temp += iterator.next();
        }
        return temp;
    }
    public String decrypt(String str){
        String temp = "";
        int strLen = str.length();
        if(Character.isAlphabetic(str.charAt(strLen-1))) {
            return "Invalid String";
        }
        for(int i=0; i<str.length(); i++) {
            char tempChar = str.charAt(i);

            if(tempChar!= ' ') {
                if(Character.isDigit(tempChar)) {
                    int count = Character.getNumericValue(tempChar);
                    while(count-->1) {
                        temp += str.charAt(i-1);
                    }
                }
                else if(Character.isAlphabetic(tempChar)){
                    if(!Character.isDigit(str.charAt(i+1))) {
                        return "Invalid String";
                    }
                    temp+= tempChar;
                }
            }
            else {
                temp += tempChar;
            }
        }
        return temp;
    }
}
