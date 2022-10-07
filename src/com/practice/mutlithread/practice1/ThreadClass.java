package com.practice.mutlithread.practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/*
PRINT THREAD 1 1 - 10
PRINT THREAD 2 11- 40
PRINT THREAD 3 41 - 65
PRINT THREAD 4 66 - 100
*/
public class ThreadClass {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    volatile int j = 1;
    public void print(){
        List<Runnable> taskList=new ArrayList<>();
        taskList.add(()->{
            synchronized (this){
                while (j <= 10){
                    System.out.println(Thread.currentThread().getName() + " " + j);
                    j += 1;
                }
            }
        });
        taskList.add(()->{
            synchronized (this){
                while(j > 10 && j <= 40){
                    System.out.println(Thread.currentThread().getName() + " " + j);
                    j += 1;
                }
            }
        });
        
        taskList.add(()->{
            synchronized (this){
                while (j > 40 && j <= 65){
                    System.out.println(Thread.currentThread().getName() + " " + j);
                    j += 1;
                }
            }
        });
        taskList.add(()->{
            synchronized (this){
                while (j > 65 && j <= 100){
                    System.out.println(Thread.currentThread().getName() + " " + j);
                    j += 1;
                }
            }
        });
        
        try{
            for(int i = 0; i < 4; i += 1){
                executorService.submit(taskList.get(i));
                executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
            }
        }
        catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
            Thread.currentThread().interrupt();
        }
        executorService.shutdownNow();
    }
}
