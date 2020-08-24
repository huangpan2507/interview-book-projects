package Stack;

import java.util.Stack;

public class RecurReverseStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public RecurReverseStack(){
        this.stack1 = new Stack<>();
//        this.stack2 = new Stack<>();
       }

    public static int getAndRemoveElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveElement(stack);
            stack.push(result);
            return last;
        }

    }

    public static void Reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return ;
        }
        int i = getAndRemoveElement(stack);                      // 调用递归，返回最后一个last=2，栈顶到栈底：3,4,5
        System.out.println(i);                                  // 打印last=2
        Reverse(stack);                                         // 调用递归Reverse，里面继续调用递归getAndRemoveElement将栈顶到栈底：3,4,5 ---》last=i=3， 栈顶到栈底：4,5
        stack.push(i);                                          // 再次调用Reverse， 非空，又将栈里面最下面的 last=i=4 吐出来，栈顶到栈底：5，再调用Reverse 里面调用getAndRemoveElement
    }                                                           // 再次吐出最下面的 last=i=5， 栈为空，本层Reverse递归结束。压入栈：i=5，继续依次压入 i=4,3,2

    public static void main(String[] args){
        RecurReverseStack sta = new RecurReverseStack();

        for(Integer x: new int[]{1,2,3,4,5}){
            sta.stack1.add(x);
        }
        System.out.println(sta.stack1.toString());
        int last = sta.getAndRemoveElement(sta.stack1);          // 比如栈顶到栈底5,4,3,2,1则调用getAndRemoveElement后为 5,4,3,2四个数，last=1未放入,所以需要把栈最底层的数字重新放回去
        System.out.println(sta.stack1.toString());
        sta.Reverse(sta.stack1);
        sta.stack1.push(last);



        System.out.println(sta.stack1.toString());
    }

}
