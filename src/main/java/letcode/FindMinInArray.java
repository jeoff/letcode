package letcode;

import org.apache.log4j.Logger;

public class FindMinInArray {
    public final static Logger logger = Logger.getLogger(FindMinInArray.class);

    private static int findMinInArray(int[] nums){

        if(nums != null && nums.length>0) {
            //only 1 elements
            if(nums.length == 1) {
                return 0;
            }

            //递增
            if(nums[0]<nums[1]) {
                return 0;
            }

            //递减
            int index = nums.length - 1;
            if(nums[index-1] > nums[index]) {
                return index;
            }

            //二分查找
            int i = 0;
            int j = index;
            int mid ;
            while (i < j) {
                mid = (i+j) / 2 ;
                if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid+1]){
                    return mid;
                }else if(nums[mid] < nums[mid - 1]){
                    //递减阶段
                    i = mid + 1;
                }else if(nums[mid] < nums[mid + 1]){
                    //递增阶段
                    j = mid - 1;
                }
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 9, 7, 13, 18};
        logger.info(FindMinInArray.findMinInArray(nums));
    }
}
