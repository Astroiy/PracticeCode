package AboutInterface.proxy;

import java.util.LinkedList;
public class Stack<T>{
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T t){
        storage.addFirst(t);
    }
    public T peek(){
        return storage.getFirst();
    }
    public T pop(){
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }
    public String toString(){
        return storage.toString();
    }
}
class StackTest{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i*i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
