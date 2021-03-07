package myannotation;

@myAnnotation(uername="zhangman",password =123456 )
public class annotationText {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("myannotation.annotationText");
        if (aClass.isAnnotationPresent(myAnnotation.class)){
            myAnnotation annotation = aClass.getAnnotation(myAnnotation.class);
            int password = annotation.password();
            String uername = annotation.uername();
            System.out.println(password+uername);
        }
    }
}
