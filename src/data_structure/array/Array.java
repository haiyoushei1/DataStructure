package data_structure.array;

import java.util.Arrays;
import java.util.Vector;

public class Array {
/*
二分查找：
时间复杂度为 logn
算法思路：通过比较中间秩与目标数的大小，确定找到并执行返回对应秩，将左边界设为中间秩+1，将右边界设为中间秩。
        当左边界大于等于有边界时，退出返回-1表示未找到。
难点：边界条件的确定。
 */
    public int binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        int mid = (low + high) / 2;  // 区间为[ , )

        while(low < high){
            if(target > nums[mid]){
                low = mid + 1;
            }else if(target < nums[mid]){
                high = mid;
            }else{
                return mid;
            }
            mid = (low + high) / 2;
        }

        return -1;
    }
}
