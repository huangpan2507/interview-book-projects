package Stack;

/*说明：该项目是《程序员代码面试指南-左程云》上的题目
   题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
   页码：P1

   关键点如下：
* 1. 使用两个栈，一个栈用来保存当前栈中的元素，是一个正常的栈，记为：stackData；
* 2. 另一个栈用来保存每一步的最小值，这个栈记为：stackMin。

   压入规则：
*  1. 将当前数据newNum 压入stackData，若stackMin为空，则也压入stackMin
*  2. 若不空，则比较newNum与stackMin`的栈顶元素的大小，如果newNum更小或者相等，则newNum也压入stackMin中，否则，在stackMin中重复压入
      stackMin栈顶元素。

   弹出规则：
*  1.stackMin栈顶既是该栈的最小值也是stackData的最小值！
*  2.弹出stackData的栈顶元素，记为：value，也弹出stackMin栈顶元素，返回stackData的栈顶value；=====>两个栈大小一样！


   时间复杂度：O(1)  空间复杂度：O(n)
   该方案与Mystack1相比，压人稍费空间，但弹出稍省时间；
* */








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
