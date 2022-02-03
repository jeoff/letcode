package mytest;

public class Demo {

    /**
     * 1,2,3
     * 4,5,6. => 1,2,3,6,9,8,7,4,5
     * 7,8,9
     * @param args
     */
    public static void main(String[] args) {

        //int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] array = {{1,2,3}};
        int[][] array = {{6},{3},{9}};
        int[] intMatrix = {1, 3, 5};

        rotatePrint(array);

    }

    public static void rotatePrint(int[][] array) {
        if (array == null) {return ;}

        int tR = 0;
        int tC = 0;
        int dR = array.length - 1;
        int dC = array[0].length - 1;

        while(tR <= dR && tC <= dC) {
            printEdge(array, tR++, tC++, dR--, dC--);
        }
    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if(tR == dR) {
            for(int i = tC; i <= dC; i++) {
                System.out.println(m[tR][i]);
            }
        }else if(tC == dC) {
            for(int i=tR; i <= dR; i++) {
                System.out.println(m[i][tC]);
            }
        }else{
            int currentR = tR;
            int currentC = tC;
            while(currentC != dC) {
                System.out.println(m[tR][currentC] + " ");
                currentC++;
            }

            while(currentR != dR) {
                System.out.println(m[currentR][dC] + " ");
                currentR++;
            }

            while(currentC != tC){
                System.out.println(m[dR][currentC] + " ");
                currentC--;
            }

            while(currentR != tR) {
                System.out.println(m[currentR][tC] + " ");
                currentR--;
            }
        }

    }
}
