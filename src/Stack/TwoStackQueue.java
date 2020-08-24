package Stack;

/*
* 1. 一个stack的数据要一次性全部压人；
* 2. 当另一个stack中有数据时，不能压入。
* */

import java.util.Stack;

public class TwoStackQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

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




    public static void main(String[] args){
        TwoStackQueue str = new TwoStackQueue();

        for(Integer x: new int[]{5,4,3,2,1,0}){
            str.add(x);
            System.out.println(str.stackPush.toString());
            System.out.println(str.stackPop.toString());
        }

        while(!str.stackPush.isEmpty()||!str.stackPop.isEmpty()){
            System.out.println(str.poll());

        }

//        System.out.println(str.stackPop.toString());
//        System.out.println(str.stackPush.toString());

//        System.out.println( str.poll());

    }

}
