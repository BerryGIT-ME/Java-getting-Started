package com.noelle;

public class MergeSort {
    public void sort(int[] list){
        if(list.length == 1) return;
        // divide array into two
        var middle = list.length/2;
        int[] left = new int[middle];
        for(var i = 0; i < middle; i++)
            left[i] = list[i];

        int[] right = new int[list.length - middle];
        for (var i = middle; i < list.length; i++)
            right[i -middle] = list[i];

        // sort each half
        sort(left);
        sort(right);

        // merge the result
        merge(right, left, list);
    }

    private void merge(int[] right, int[] left, int[] list){
        int i = 0, j = 0, k = 0;

        while(i < right.length && j < left.length){
            if(right[i] < left[j]) list[k++] = right[i++];
            else list[k++] = left[j++];
        }

        while (i < right.length)
            list[k++] = right[i++];
        while (j < left.length)
            list[k++] = right[j++];
    }

}
