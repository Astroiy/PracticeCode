package LearnStream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {
    public static void main(String[] args) {
        LocalDate[] dates = new LocalDate[3];
        dates[0]=LocalDate.of(2000,1,20);
        dates[1]=LocalDate.of(1998,12,15);
        dates[2]=LocalDate.of(2022,2,13);
        Stream<LocalDate> dateStream1 = Arrays.stream(dates);
        System.out.println(dateStream1.sorted().collect(Collectors.toList()));

        Stream<LocalDate> dateStream2 = Stream.of(dates);
        System.out.println(dateStream2.sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
