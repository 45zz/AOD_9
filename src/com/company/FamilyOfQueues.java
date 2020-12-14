package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyOfQueues {
    ArrayList<Queue> queues;
    int maxEl=(int)(Math.random()+1)*20;
    int [][] allNum;
    FamilyOfQueues(int quantity){
        queues=new ArrayList<>();
        allNum = new int[quantity][];

        for (int i = 0; i < quantity ; i++) {
            allNum[i]=new int[maxEl];//инициализируем cтолбцы массива для каждой очереди
        }

        for (int i = 0; i < quantity ; i++) {
            Queue ex= new Queue(maxEl);
            ex.generate();//заполняем очередь
            queues.add(ex);
        }

        for (int i = 0; i < queues.size() ; i++) {//заполняем массив
            int j=0;
            while(!queues.get(i).isEmpty()){
                allNum[i][j]= queues.get(i).poll();
                j++;
            }
        }
    }

    public void sort(){
        for (int i = 0; i < allNum.length; i++) {
            allNum[i]=edSort(allNum[i]);
        }
    }

    public void out(){
        for (int i = 0; i < queues.size() ; i++) {
            System.out.print(i+1+": ");
            for (int j = 0; j < allNum[i].length ; j++) {
                System.out.print(allNum[i][j] +" ");
            }
            System.out.println();
        }
    }

    private int [] edSort(int[] input){
        int[]b=Arrays.copyOf(input,input.length);

        ArrayList<Integer>[] buckets = new ArrayList[10]; //куда подвешивать числа
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        int  divisor = 1,max=0;//делитель
        for (int i = 0; i < b.length ; i++) {
            max=Integer.max(b[i],max);
        }
        label:
        while (true) {
            for (int i=0; i<b.length;i++) {
                int tmp = b[i] / divisor;
                buckets[tmp % 10].add(b[i]);//подвешимаем числа
            }
            for (int l = 0,k=0; l < 10; l++) {
                for (int i : buckets[l]) { //проходим по числам с разрядами 0,1,2,...
                    b[k++] = i; //сортируем исходный массив по соотвествующим разрядам
                }
                if(buckets[0].size()==b.length && max/divisor==0) break label; // если все числа подвешены к 0
                buckets[l].clear(); //убираем подвешенные цифры
            }
            divisor *= 10;
        }
        return b;
    }
}
