package designpattern.dependencyinverse;

public class FrontCourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("Study Front Course");
    }
}
