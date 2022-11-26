package LearnMaps;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class CopyEnumSet {
    public static void main(String[] args) {
        var list = new ArrayList<Test>(List.of(Test.TEST1));
        var list1 = new ArrayList();
        list1.add(Test.TEST1);
        list1.add(DayOfWeek.FRIDAY);
        var set = EnumSet.copyOf(list);
        var set1 = EnumSet.copyOf(list1);
    }
}

enum Test{
    TEST1,TEST2,TEST3;
}
