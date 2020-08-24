package Stack;

import java.util.Stack;

public class Mystack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack1(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if (stackMin.isEmpty() || this.getMin()>=newNum){
            stackMin.push(newNum);
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