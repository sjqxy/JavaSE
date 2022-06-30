package h1;

public class h3 {
    public int lengthOfLongestSubstring(String s){
        int[] last = new int[128];
        for (int i=0;i<128;++i){
            last[i]=-1;
        }
        int res=0,start=0;
        for (int i=0;i<s.length();i++){
            int index=s.charAt(i);
            start =Math.max(start,last[index]+1);
            res=Math.max(res,i-start+1);
            last[index]=i;

        }
        return res;
    }
}
