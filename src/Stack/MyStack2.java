package Stack;

import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        stackData = new Stack<>();
        stackMin = new Stack<>();

    }

    public void push(int newNum){
        if (stackMin.isEmpty() ){
            stackMin.push(newNum);

        } else if (newNum >= stackMin.peek()){
            stackMin.push(stackMin.peek());
        } else{
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int[] pop() {
        int[] pop_result = new int[2];

        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        pop_result[0] = stackData.pop();
        pop_result[1] = stackMin.pop();
        return pop_result;
    }

    public int getMin(){
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return stackMin.peek();
    }

    public String toString(){

        if(stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty!");
        }
        return stackData.toString();
        
    }

    public static void main(String[] args){
        MyStack2 st1 = new MyStack2();

        for (Integer x: new int[]{3,4,5,1,2,1}){
            st1.push(x);
        }

        System.out.println(st1);
        System.out.println(st1.stackData.toString());
        System.out.println(st1.stackMin.toString());
        System.out.println(st1.getMin());
    }
}
