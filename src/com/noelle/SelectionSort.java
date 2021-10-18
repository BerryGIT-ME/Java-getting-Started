package com.noelle;

public class SelectionSort {
    public void sort(int[] list){
        for(var i = 0; i < list.length; i++){
            int minIndex = i;
            for(var j = i + 1; j< list.length; j++){
                if(list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            swap(list, minIndex, i);
        }
    }

    private void swap(int[] list, int first, int second){
        var temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
