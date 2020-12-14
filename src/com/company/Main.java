package com.company;

public class Main {
    public static void main(String[] args) {
        FamilyOfQueues f=new FamilyOfQueues(7);
        System.out.println("До сортировки: ");
        f.out();
        f.sort();
        System.out.println("После сортировки:");
        f.out();
    }
}
