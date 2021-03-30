package mytest.innerclass;

public class ClassADemo {

    private class ClassB {
        protected void showB() {
            System.out.println("classB show methodB");
        }
    }


    protected void showA() {
        System.out.println("classA show methodA");
        new ClassB().showB();
        new ClassC().showC();
    }

    public static void main(String[] args) {
        new ClassADemo().showA();
    }

}

class ClassC {
    protected void showC(){
        System.out.println("classC show methodC");
    }
}
