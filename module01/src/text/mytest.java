package text;

import org.junit.Test;

public class mytest {
    @Test
    public void addtest(){
        myadd myadd = new myadd();
        try{
            int a=3/0;
        }catch(RuntimeException e){
            System.out.println("数学错误");
            int c=myadd.add(3,8);
            System.out.println(c);
        }
    }
}
