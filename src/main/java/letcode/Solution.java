package letcode;

class Solution {
    public boolean find(int [][] array,int target) {
        boolean found = false;
        int lie = array[0].length;
        int hang = array.length;
        int column = lie -1;
        int row =0;

        if (target > array[hang][lie] || target < array[0][0]) {
            found = true;
        }

        while(row<hang &&column>=0){
            int value = array[row][column];
            if(target>value){
                row++;
            }else if(value>target){
                column--;
            }else{
                found = true;
                break;
            }

        }
        return found;
    }
}

class findTarget
{
    public static void main(String[] args) {
        int[][] array = { {11, 24, 29},
                            {12, 25, 30},
                            {13, 26, 31}};

        Solution st = new Solution();
        st.find(array, 18);
    }
}