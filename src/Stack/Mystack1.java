package Stack;


/*说明：该项目是《程序员代码面试指南-左程云》上的题目
   题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
   页码：P1

   关键点如下：
* 1. 使用两个栈，一个栈用来保存当前栈中的元素，是一个正常的栈，记为：stackData；
* 2. 另一个栈用来保存每一步的最小值，这个栈记为：stackMin。

   压入规则：
*  1. 将当前数据newNum 压入stackData，若stackMin为空，则也压入stackMin
*  2. 若不空，则比较newNum与stackMin`的栈顶元素的大小，如果newNum更小或者相等，则newNum也压入stackMin中，否则，stackMin不压入数据

   弹出规则：
*  1.stackMin栈顶既是该栈的最小值也是stackData的最小值！
*  2.弹出stackData的栈顶元素，记为：value，然后比较stackMin栈顶元素的大小，若大于stackMin栈顶元素，则stackMin不弹出，只返回value；
*    否则，stackMin`也弹出栈顶元素。======>因为stackMin始终保存的是每一步的最小值，其栈大小 < stackData。


   时间复杂度：O(1) 空间复杂度：O(n)
   该方案与Mystack2相比，压人稍微省空间，但弹出稍费时间；
* */


import java.util.Stack;

public class Mystack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack1(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty() || this.getMin()>=newNum){
            this.stackMin.push(newNum);
            System.out.println("You push num:"+ newNum + " to StackMin");
        }
        stackData.push(newNum);
        System.out.println("You push num:"+ newNum + " to StackData");
    }

    public int pop(){
        if (stackData.isEmpty()){
            throw new RuntimeException("Your stack is Empty!");
        }
        int value = stackData.pop();
        if(value == this.getMin()){
            System.out.println("You pop num:"+ value + " from StackMin");
            stackMin.pop();
        }
        System.out.println("You pop num:"+ value + " from StackData");
        return value;
    }


    public int getMin(){
        if(stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty!");
        }
        return stackMin.peek();
    }

    public String toString(){
        if (stackData.isEmpty()){
            throw new RuntimeException("Your stack is Empty!");
        }
        return stackData.toString();
    }

    public static void main(String[] args) {
        Mystack1 st1 = new Mystack1();
       // Mystack1 st2 = new Mystack1();   no need

        for (Integer x: new int[]{3, 4, 5, 0, 2, 1}){
            st1.push(x);
            //st2.push(x);                 no need
        }
        //System.out.println(st1);                      //利用自己的toString方法
        System.out.println(st1.toString());             //打印的是地址
        System.out.println(st1.stackData.toString());  //法二利用toString方法
        System.out.println(st1.stackMin.toString());   //法二利用toString方法
        System.out.println(st1.getMin());



    }


}