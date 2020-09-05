package offer.FindRepeatNum;

import java.util.Arrays;


/*  数组的原地排序！ ——————> 该代码未考虑到数组中是否有重复值！
*  SortArrayNum: 数组元素大小：0 - n-1之间，此处有个问题，一旦数组中有重复元素，因为排序是使得数组放同下标一样的数值。比如：0 1 2 3下标对应
* 的是数值 0,1,2,3 一一对应，一旦有重复数字，比如0,1,2,3,4,2,5
* 则它将与元素对应的下标交换， 而该对应下标=元素值=要交换的数值， 即两个相同的值交换会无变化，死在了while的下标与元素是否相同的检查里。
* */
public class SortArrayNum {


    public int[] sort(int[] nums){

        for(int i =0; i< nums.length; i++){

            while(i != nums[i]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }


    public  static void main(String[] args){
        SortArrayNum a = new SortArrayNum();
        int[] c= new int[]{2,3,1,0,4,5};         //此处c为数组的索引，即地址
//        int[] c= {2,3,1,0,4,5};
        System.out.println(c.length);
        a.sort(c);
        System.out.println(Arrays.toString(c));
        System.out.println(c.toString());
    }
}
