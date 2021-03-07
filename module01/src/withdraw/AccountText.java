package withdraw;

public class AccountText {
    public static void main(String[] args) {
        Account account = new Account("110",5000);
        /*Account account1=new Account("110",5000);*/
        aThread a=new aThread(account);
        bThread  b=new bThread(account);
        a.start();
        b.start();
    }
}
