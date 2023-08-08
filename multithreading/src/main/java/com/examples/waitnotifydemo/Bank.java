package com.examples.waitnotifydemo;

public class Bank implements Runnable {

    Thread thread1, thread2;

    Account account1 = new Account(101, 0);

    public Bank() {
        thread1 = new Thread(this);
        thread1.setName("T1");
        thread1.start();

        thread2 = new Thread(this);
        thread2.setName("T2");
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(account1);
    }

    @Override
    public void run() {
        if(Thread.currentThread()==thread1){
            withdraw(account1,200);
        }

        if(Thread.currentThread()==thread2){
            deposit(account1,1000);
        }
    }

    public void withdraw(final Account account, final double amount)
    {
        synchronized (account){
            System.out.println(Thread.currentThread().getName()+" withdraw started in Account Number= "
                    +account.getAccountNo()+" Balance ="+account.getBalance());

            double temp=account.getBalance();

            try
            {
                if(temp<amount){
                    System.out.println(Thread.currentThread().getName()+ " waiting for withdraw");
                    account.wait();
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            temp=account.getBalance();
            temp-=amount;

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            account.setBalance(temp);

            System.out.println(Thread.currentThread().getName()+" withdraw completed in Account Number= "
                    +account.getAccountNo()+" Balance ="+account.getBalance());
        }
    }

    public void deposit(final Account account, final double amount)
    {
        synchronized (account){
            System.out.println(Thread.currentThread().getName()+" deposit started in Account Number= "
                    +account.getAccountNo()+" Balance ="+account.getBalance());

            double temp=account.getBalance();
            temp+=amount;

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            account.setBalance(temp);

            System.out.println(Thread.currentThread().getName()+" deposit completed in Account Number= "
                    +account.getAccountNo()+" Balance ="+account.getBalance());
            account.notify();
        }
    }

    public static void main(String[] args) {
        new Bank();
    }
}
