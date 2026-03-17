package dsa.dp;

import java.util.HashMap;

public class LongestSubstrWithoutRepeatingChars {
    public static int LCSWithoutRepeatingChars(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0,j = 0,max = Integer.MIN_VALUE;
        for(j=0;j<str.length();j++){
            char currentChar = str.charAt(j);
            if(map.containsKey(currentChar)){
                map.put(currentChar,map.get(currentChar)+1);
            }
            else{
                map.put(currentChar,1);
            }
            while(map.get(currentChar) > 1){
                char ch = str.charAt(i);
                if(map.get(ch) == 1){
                    map.remove(str.charAt(i));
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                i++;
            }
            max = Math.max(max,j-i+1);
        }
        return max;
    }
    public static int LCSWithoutRepeatingCharsNavieApproach(String str){
       int max = Integer.MIN_VALUE, i=0,j=0;
       for(i=0;i<str.length();i++){
           HashMap<Character,Integer> map = new HashMap<>();
           for(j=i;j<str.length();j++){
               if(map.containsKey(str.charAt(j))){
                   break;
               }else{
                   map.put(str.charAt(j),1);
               }
           }
           max = Math.max(max,j-i);
       }
       return max;
    }
    public static void main(String[] args) {
        String input = "abcadbcmdc";
        System.out.println(LCSWithoutRepeatingChars(input));
        System.out.println(LCSWithoutRepeatingCharsNavieApproach(input));
    }
}
