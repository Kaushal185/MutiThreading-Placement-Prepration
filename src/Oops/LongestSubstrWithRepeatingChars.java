package Oops;
import java.util.HashMap;
import java.util.Scanner;
public class LongestSubstrWithRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        int i = 0, j = 0,size = s.length(),ans = 0;
        for(j=0;j<size;j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
            while(map.get(c) > 1){
                char left = s.charAt(i);
                if(map.get(left) == 1){
                    map.remove(left);
                }
                else{
                    map.put(c,map.get(left)-1);
                }
                i++;
            }
            ans = Math.max(ans,map.size());
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string here : ");
        String input = sc.nextLine();
        System.out.println("length of longest char substr is : "+lengthOfLongestSubstring(input));
    }
}
