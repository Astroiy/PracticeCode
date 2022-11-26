package AboutInterface.ProccessingLambda;

import java.util.function.IntConsumer;
import java.util.function.Predicate;

public class RepeatAction {
    /**只是单纯执行action而不需要其他参数参与
     * 使用Runnable接口
     * 其抽象方法为run()
     * 无参数返回void*/
    public static void repeat(int count,Runnable action){
        for(int i=0;i<count;i++)
            action.run();
    }
    /**想要让action知道自己在重复执行中的序数
     * 使用IntConsumer接口
     * 其抽象方法为accept(int i)
     * 整数参数返回void*/

    public static void repeat(int count, IntConsumer action){
        for(int i=0;i<count;i++)
            action.accept(i);
    }
    /**测试类*/
    public static void main(String[] args) {
        RepeatAction.repeat(10,()->System.out.println("Hello!"));
        RepeatAction.repeat(10,(k)->System.out.println("Countdown: "+(9-k)));
        RepeatAction.repeat(10,System.out::print);
    }
}
