package Recrusion;

import java.util.Scanner;

public class PalindromeOrNot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s =scanner.nextLine();
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        String string = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        string = toBeChecked(string);
        return string.isEmpty();
    }

    public static String toBeChecked(String string){
        int length=string.length();
        if(!string.isEmpty()){
            if(string.charAt(0)==string.charAt(length-1)){
                if(string.length()>1){
                    string = string.substring(1, string.length()-1);
                }else {
                    string="";
                }
                return toBeChecked(string);
            }
        }
        return string;
    }
}
