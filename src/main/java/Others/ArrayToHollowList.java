package Others;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ArrayToHollowList {

    public static void main(String[] args) {
        Object[] oriArray = Stream.iterate(1, ori -> Integer.sum(ori, 1)).limit(12).toArray();

        List<Object> result = arrayToHollowList(oriArray,2);

        System.out.println(result);
    }


    // 将一个非空数组转变为期望的含空洞 null 的集合，要求数字间间隔依次增大，且在超过 2的hollowLimit次方 时重置间隔。间隔默认从1开始计算
    public static List<Object> arrayToHollowList(Object[] oriArray,Integer hollowLimit) {

        Assert.assertTrue(Objects.nonNull(oriArray) && oriArray.length > 0);

        ArrayList<Object> result = new ArrayList<>();
        HollowBuilder hollowBuilder = new HollowBuilder(hollowLimit);

        for (int i = 0; i < oriArray.length; i++) {
            result.add(oriArray[i]);
            if(i != oriArray.length-1) {
                boolean initOccur = hollowBuilder.buildHollow(result);
                if(initOccur) {
                    System.err.println("Hollow Count Reset To 1 after" + oriArray[i]);
                }
            }
        }
        return result;
    }


}

class HollowBuilder {
    private Integer hollow = 1;
    private Integer initLimit;

    // 构造器规定了2的多少次方后空洞后复原为1
    public HollowBuilder(Integer initLimit) {
        this.initLimit = initLimit;
    }
    private boolean initHollow() {
        hollow = hollow >> initLimit == 1 ? 1 : ++hollow;
        return hollow == 1;
    }
    // 若本次打洞发生了初始化，返回true，否则返回false
    public boolean buildHollow(List<?> target) {
        Integer curHollow = hollow;

        for (Integer i = 0; i < curHollow; i++) {
            target.add(null);
        }

        return initHollow();
    }
}
