package reflect;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sex=" + sex +
                '}';
    }

    public  String sno;
    private String sname;
    protected int sage;
    boolean sex;

    public Student(String sno, String sname, int sage, boolean sex) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.sex = sex;
    }
}
