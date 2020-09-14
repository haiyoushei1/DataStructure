package structure_test.arrayTest;

import data_structure.array.Array;

public class Test {
    public static void main(String[] str){
        int[] nums = {1, 3, 5, 6};
        Array array = new Array();
        System.out.println(array.binarySearch(nums, 3));
    }
}
