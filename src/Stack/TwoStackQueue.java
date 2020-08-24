package Stack;

/*说明：该项目是《程序员代码面试指南-左程云》上的题目
   题目：编写一个类，用两个栈实现队列，支持队列的基本操作（add，poll， peek）
   页码：P5

   关键点如下：
* 1. 一个stack的数据要一次性全部压人另一个stack；
* 2. 当另一个stack中有数据时，不能被压入数据。
* */

import java.util.Stack;

public class TwoStackQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }


    /**
     * 实现当stackPop为空时且stackPush非空时，才可以压入数据
     */
    public void pushToPop(){
        if (stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.add(pushInt);
        pushToPop();
    }

    public int poll(){
        if(stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Your stack is empty!");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Your stack is empty!");
        }
        pushToPop();
        return stackPop.peek();
    }


    /**
     *
     * @param args
     * 测试上面项目，首先给栈填充数据，其次使用while循环，当一个stack ||(或)另一个stack 非空时，弹出栈中数据，若与队列中弹出顺序
     * 一致，则代码逻辑正确！注意第一个元素从stackPush压入stackPop后，其余元素均压入在stackPush中而无法压入stackPop，只有弹出
     * stackPop中保存的第一个元素，其余元素才会全部一次性压入stackPop中！，然后再弹出，则顺序会和队列一致！
     */


    public static void main(String[] args){
        TwoStackQueue str = new TwoStackQueue();

        for(Integer x: new int[]{5,4,3,2,1,0}){
            str.add(x);
            System.out.println(str.stackPush.toString());
            System.out.println(str.stackPop.toString());
        }
        for(Integer x: new int[]{50,40,30,20,10,11}){
            str.add(x);
//            System.out.println(str.stackPush.toString());
//            System.out.println(str.stackPop.toString());
        }
        while(!str.stackPush.isEmpty()||!str.stackPop.isEmpty()){
            System.out.println(str.poll());

        }

//        System.out.println(str.stackPop.toString());
//        System.out.println(str.stackPush.toString());

//        System.out.println( str.poll());

    }

}
