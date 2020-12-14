package com.company;

import java.util.Arrays;
import java.util.Random;

public class Queue {
    private int [] mass;
    private int elements=0;
    private int begin;
    private int end;

    Queue(int quantity){
        mass=new int[quantity];
        begin=-1;//начало очереди. Обновляется при извлечении poll
        end=-1; //конец очереди. Обновляется при добавление add
    }

    public void generate(){
        Random rand= new Random();
        while(!isFull()){
            add(Math.abs(rand.nextInt())%1000);
        }
    }

    public void add(int element){
        if(!isFull()) {     //переполнение
            elements++;
            end = (end + 1) % mass.length;
            mass[end % mass.length] = element;
        }
        else{
            System.out.println("Чёт вроде места нет");
        }
    }
    public int poll(){
        elements--;
        begin=(begin+1)%mass.length;
        return mass[begin];
    }

    public void del(){
        elements--;
        begin=(begin+1)%mass.length;
    }

    public boolean isFull(){
        if(elements!=mass.length) return false;
        else return true;
    }
    public boolean isEmpty(){
        if(elements==0) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue_mass=" + Arrays.toString(mass) +
                ", begin=" + (begin+1)%mass.length +
                ", end=" + end +
                ", isFull=" + isFull() +
                ", isEmpty=" + isEmpty() +
                ", elements=" + elements +
                '}';
    }
}
