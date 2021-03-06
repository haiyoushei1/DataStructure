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

/*
冒泡排序：
时间复杂度：n方
算法思路：
1.从头比较相邻的数组元素的值，按递增或递减，比较到最后的一个值，必定是最大或最小
2.在回到头部，重复1，比较到n-1的位置
3.重复2，直到比较到头部
 */
    public int[] bubblingSort(int[] nums){

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

/*
选择排序：
时间复杂度：n方
算法思路：
1.从第一个数组元素开始，与后面的进行比较
2.从第二个元素开始，重复1
3.重复2直到最后一个元素
 */
    public int[] choiceSort(int[] nums){

        for(int i = 0 ; i < nums.length - 1; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }

/*
插入排序：
时间复杂度：n方
算法思路：
1.从第二个元素开始，向前找合适的位置
2.插入
注：链表使用插入排序比数组好，数组有一个插入，完了要挪后续数组
 */
    public int[] insertSort(int[] nums){

        for(int i = 1; i < nums.length; i++){
            int j = 0;
            int temp = nums[i];
            for( j = i; temp < nums[j - 1] && j > 0; j--){  // 将插入元素向前与数组元素进行比较
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
        return nums;
    }
    /*
归并排序：
时间复杂度：O(nlogn)
算法思路：很典型的分治思路
1、将数组从中间分开，不断的递归，直到每个区间只有一个元素  --分
2、在一个区间将左右两侧的元素进行归并操作，哪个小就进入数组  --治
 */
    public int[] mergeSort(int[] nums, int begin, int end){
        int mid = (begin + end) / 2;
        if(nums == null || begin >= mid)
            return null;
        mergeSort(nums, begin, mid);  // 对左边进行归并排序
        mergeSort(nums, mid, end);
        merge(nums, begin, mid, end);  // 对两边进行归并
        return nums;
    }
    public void merge(int[] nums, int begin,int mid,  int end){
        int[] temp = new int[end - begin];
        int i = begin;
        int j = mid;
        int k = 0;
        while(i < mid && j < end){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        if(i < mid){
            while(i < mid){
                temp[k++] = nums[i++];
            }
        }
        if(j < mid){
            while(j < mid){
                temp[k++] = nums[j++];
            }
        }
        for(k = 0; begin < end; begin++, k++){
            nums[begin] = temp[k];
        }
    }
}

