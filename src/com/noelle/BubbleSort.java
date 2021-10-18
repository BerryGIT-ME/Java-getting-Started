package com.noelle;

public class BubbleSort {
    public void sort(int[] list){

        for(var i = 0; i < list.length; i++){
            boolean isSorted = true;
            for(var j = 1; j < list.length - i; j++){
                if (list[j] < list[j-1]) {
                    isSorted = false;
                    swap(list, j, j - 1);
                }
            }
            if(isSorted) break;
        }
    }

    private void swap(int[] list, int first, int second){
        var temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
