package com.examples.semiphore;

import java.util.concurrent.Semaphore;
public class SemaphoreExample
{

    static Semaphore semaphore = new Semaphore(3);

    static class DemoThread extends Thread
    {
        String name = "";

        public DemoThread(String name)
        {
            this.name = name;
        }


        public void run()
        {
            try
            {
                System.out.println("Thread "+name + " : acquiring lock...");
                System.out.println("Thread "+name + " : available Semaphore permits is: "+ semaphore.availablePermits());

                semaphore.acquire();
                System.out.println("Thread "+name + " : got the permit!");
                try
                {
                    for (int i = 1; i <= 5; i++)
                    {
                        System.out.println("Thread "+name + " : is performing operation "
                                + i+ ", available Semaphore permits : "+ semaphore.availablePermits());
                        Thread.sleep(2000);
                    }
                }
                finally
                {
                    System.out.println("Thread "+name + " : releasing lock...");
                    semaphore.release();
                    System.out.println("Thread "+name + " : available Semaphore permits is: "
                            + semaphore.availablePermits());
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {

        System.out.println("Total available Semaphore permits is: "+ semaphore.availablePermits());
        DemoThread t1 = new DemoThread("A");
        t1.start();

        DemoThread t2 = new DemoThread("B");
        t2.start();

        DemoThread t3 = new DemoThread("C");
        t3.start();

        DemoThread t4 = new DemoThread("D");
        t4.start();

    }
}