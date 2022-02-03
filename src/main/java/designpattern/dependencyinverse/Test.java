package designpattern.dependencyinverse;

public class Test {

    public String userName;



    public static void main(String[] args) {
        ICourse javaCourse = new JavaCourse();
        javaCourse.studyCourse();

        int debugChange = 9;
        System.out.println("debugChange value, " + debugChange);
        javaCourse.studyCourse();
    }
}
