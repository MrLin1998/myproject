package withdraw;


class bThread extends Thread{
    private final Account account;
        bThread(Account account){
        this.account=account;
    }
    @Override
    public void run() {
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
            account.withdraw(200);

/*
            System.out.println(Thread.currentThread().getName() + "账户" + account.getAno() + "取款成功" + "剩余金额" + account.getMoney());
*/
         }
    }
