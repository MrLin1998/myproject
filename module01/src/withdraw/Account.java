package withdraw;

class Account {
    private final String ano;
    private int money;

    public Account(String ano, int money) {
        this.ano = ano;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAno() {
        return ano;
    }


    @Override
    public String toString() {
        return "Account{" +
                "ano='" + ano + '\'' +
                ", money=" + money +
                '}';
    }

    public /*synchronized*/ void withdraw(int q) {
       /* Scanner s = new Scanner(System.in);
        System.out.println("请输入取款金额：");
            String line = s.nextLine();
            int b=Integer.parseInt(line);*/
        synchronized ("this") {
            int before = money;
            int after = before - q;
            /*try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }*/
            this.setMoney(after);
            System.out.println(Thread.currentThread().getName() + "账户" + this.getAno() + "取款成功" + "剩余金额" + this.getMoney());
        }
    }
}

