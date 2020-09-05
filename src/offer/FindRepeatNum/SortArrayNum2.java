package offer.FindRepeatNum;

import java.util.Arrays;

/*
* SortArrayNum2： 在while循环里，增加了判断nums[i] != nums[nums[i]]，即交换元素本来应呆位置上的元素是否与该i下标 的值一样
* 这里有个关键点： 数组元素值从0-length
*              
*              1.找出数组中重复的值
* */

public class SortArrayNum2 {

//    int[] duplication=new int[10];
    public int sort(int[] nums){

//        int k=0;
        for(int i=0; i< nums.length; i++){
            while(i != nums[i]){        //因为是下标值与元素值大小一一对应，0 1 2 对应 0 1 2即交换元素本该呆位置上的值与交换元素相等，那就会陷入无限相同值交换的循环中
                if(nums[i] != nums[nums[i]]) {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
                else
//                    duplication[k++] = nums[i];        //其实就算数组中存在多个值，也只能返回第一个，因为return掉，或者这里i++， 但其他的都乱掉了
//                    return duplication;
                    return  nums[i];
            }

        }
        return -1;   
    }

    public static void main(String[] args){
        SortArrayNum2 a = new SortArrayNum2();

        int[] c = new int[]{2,1,2,1};
        int b = a.sort(c);
        System.out.println(Arrays.toString(c)+ " duplication: "+ b);

    }
}
