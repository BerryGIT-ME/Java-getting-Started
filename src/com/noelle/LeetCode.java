package com.noelle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode {

    public boolean isValid(String s) {
        ArrayList<Character> list = new ArrayList<>();
        char[] str = s.toCharArray();
        int pointer = 0;
        boolean terminated = false;
        for(char ch : str){
            if(ch == '(' || ch == '{' || ch == '[') {
                list.add(ch);
                pointer++;
            }
            else{
                if(pointer == 0) {
                    terminated = true;
                    break;
                }
                char opener = list.get(pointer - 1);
                if((ch == ')' && opener == '(') ||
                        (ch == '}' && opener == '{')||
                        (ch == ']' && opener == '[')){
                    pointer--;
                    list.remove(pointer);
                } else {
                    terminated = true;
                    break;
                }
            }
        }

        return !terminated && pointer == 0;
    }

    public String longestCommonPrefix(String[] strs){

        char[] prefix = strs[0].toCharArray();
        int pointer = prefix.length;

        for (String str : strs) {
            char[] current = str.toCharArray();
            int tempPointer = 0;
            while(tempPointer < pointer && tempPointer < current.length){
                if(prefix[tempPointer] != current[tempPointer]) break;
                tempPointer++;
            }
            pointer = tempPointer;

            if(pointer == 0) break;
        }

       return pointer == 0 ? "" : String.copyValueOf(prefix, 0, pointer);
    }

    public int romanToInt(String s){
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        String S = s.toUpperCase();

        int sum = 0;
        int i = 0;
        while(i < S.length()){
            char currentChar = S.charAt(i);
            char nextChar = i == (S.length() - 1) ? S.charAt(i) : S.charAt(i + 1);
            int currentValue = roman.get(currentChar);
            int nextValue = roman.get(nextChar);
            if(currentValue < nextValue) sum -= currentValue;
            else sum += currentValue;
            i++;
        }
        return sum;
    }

    public boolean isPalindrome(int x){
        String str = Integer.toString(x);
        int start = 0;
        int end = str.length() - 1;
        boolean isPalindrome = true;

        while(end > start){
            if(str.charAt(start++) != str.charAt(end--)){
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    public int[] twoSum(int[] nums, int value){
        // complement, index
        HashMap<Integer, Integer> compliment = new HashMap<>();

        compliment.put((value - nums[0]), 0);
        int index1 = -1;
        int index2 = -1;
        for(var i = 1; i < nums.length; i++){
            if(compliment.containsKey(nums[i])){
                index1 = compliment.get(nums[i]);
                index2 = i;
                break;
            }
            int difference = value - nums[i];
            compliment.put(difference, i);
        }
        return new int[]{index1, index2};
    }

}
