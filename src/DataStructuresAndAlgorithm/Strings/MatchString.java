package DataStructuresAndAlgorithm.Strings;

public class MatchString {
    public static boolean matchString(String str,String template){
        int i=0;
        while(true){
            boolean allMatch=true;
            for (int j = 0; j < template.length(); j++) {
                if(template.charAt(j)!='*') {
                    allMatch=false;
                    break;
                }
            }
            if(allMatch)
                return true;
            if(template.charAt(i)==str.charAt(i)){
                if(i==str.length()-1){
                    for(int j=i+1;j<template.length();j++){
                        if(template.charAt(j)!='*')
                            return false;
                    }
                    return true;
                }
                else if(i!=str.length()-1 && i==template.length()-1)
                    return false;
                else {
                    i++;
                    continue;
                }
            }
            if(template.charAt(i)!=str.charAt(i) && template.charAt(i)!='*'){
                return false;
            }
            if(template.charAt(i)!=str.charAt(i) && template.charAt(i)=='*'){
               for(int j=0;j<str.length()-i;j++){
                   if(matchString(str.substring(i+j),template.substring(i+1)))
                       return true;
               }
               return false;
            }
        }
    }
    public static void main(String[] args) {
        String str="awdsoaicjdosaoiwhdiosa";
        String regex="**a***c**d*";
        System.out.println(matchString(str,regex));
    }
}
