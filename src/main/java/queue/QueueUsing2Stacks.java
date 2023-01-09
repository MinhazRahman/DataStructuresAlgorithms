package queue;

import java.util.Stack;

/**
 * queue: first in first out using two stacks
 * */

public class QueueUsing2Stacks {
   Stack<Integer> stack1 = new Stack<>();
   Stack<Integer> stack2 = new Stack<>();

   public QueueUsing2Stacks(){

   }

   public void enqueue(int val){
      stack1.push(val);
   }

   public int dequeue(){
      int x = -1;
      if (stack1.isEmpty() && stack2.isEmpty()){
         return x;
      }else {
         while (!stack1.isEmpty()){
            stack2.push(stack1.pop()); // pop the value from stack1 and push it to stack2
         }
      }

      return stack2.pop(); // finally, pop the value from stack2
   }
}
