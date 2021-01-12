package com.peter;

public class MyQueue {

    private int[] array;
    private int front, rear = 0;

    private final static int DEFAULT_CAPACITY = 4;

    public MyQueue() {
        array = new int[DEFAULT_CAPACITY];
    }

    public void push(int value) {
        if (array[rear] != 0 ) {
            System.out.println("Queue cannot add more");
            return;
        }

        array[rear] = value;
        rear++;
        if (rear >= array.length) {
            rear = 0;
        }
    }

    public int pop() {
        if (array[front] == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int res = array[front];
        array[front] = 0;

        front++;
        if (front >= array.length) {
            front = 0;
        }

        return res;
    }

    public boolean isEmpty() {
        return array[front] == 0 && array[rear] == 0;
    }
}
