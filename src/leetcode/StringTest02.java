package leetcode;

import javax.management.StandardEmitterMBean;
import java.util.ArrayList;
import java.util.List;

public class StringTest02 {

    /*
    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
    返回 s 所有可能的分割方案
    示例:
        输入: "aab"
        输出:
        [
          ["aa","b"],
          ["a","a","b"]
        ]
    */


    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs("12322",res,temp,0);
        System.out.println(res);
    }


    public static void dfs(String s, List<List<String>> res , List<String> temp ,int start){
        // s.substring()
        if(start == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start ; i < s.length() ; i ++){
            if (isP(s,start,i)){
                temp.add(s.substring(start,i+1));
                dfs(s,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }

    }

    /**
     * 判断字符串是否是回文
     * @param s 字符串
     * @param start 起始坐标
     * @param end 终止坐标
     * @return 是否为回文的结果
     */
    public static boolean isP(String s , int start , int end){
        while(start < end){
            if (s.charAt(start) == s.charAt(end)) {
                start ++;
                end --;
            }else{
                return false;
            }
        }
        return true;
    }
}
