package reflect;

import java.lang.reflect.Constructor;

public class reflectTxet01 {
    public static void main(String[] args) throws Exception {
        Class<?> student=Class.forName("reflect.Student");
     /*   Field[] sfields = student.getDeclaredFields();
        for (Field sfield:sfields) {
            System.out.println(sfield.getName());
            System.out.println(Modifier.toString(sfield.getModifiers()));
            System.out.println(sfield.getType());
        }*/
        Constructor<?> c=student.getDeclaredConstructor(String.class,String.class,int.class,boolean.class);
        Object o=c.newInstance("110","zhansan",18,true);
        System.out.println(o);
    }
}
