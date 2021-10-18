package com.noelle;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] list){
        for(var i = 1; i < list.length; i++){
            var current = list[i];
            for(var j = i - 1; j >= 0; j--){
                if(list[j] < current){
                    break;
                }
                shift(list, j);
            }
        }
    }

    public void shift(int[] list, int j){
        int temp = list[j + 1];
        list[j + 1] = list[j];
        list[j] = temp;
        System.out.println(Arrays.toString(list));
    }

}
