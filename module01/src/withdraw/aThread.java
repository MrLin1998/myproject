package withdraw;

class aThread extends Thread{
     private final Account account;
     aThread(Account account){
         this.account=account;
     }
     @Override
    public void run() {
         /*synchronized (account) {*/
             account.withdraw(200);
        /* try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }*/
             /*System.out.println(Thread.currentThread().getName() + "账户" + account.getAno() + "取款成功" + "剩余金额" + account.getMoney());*/
         }

}
