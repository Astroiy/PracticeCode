package LearnStream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {
    public static class Person{
        private int id;
        private String name;

        public Person(int id,String name){
            this.id=id;
            this.name=name;
        }

        public int getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public String toString(){
            return getClass().getName()+"[id="+id+",name="+name+"]";
        }
    }
    public static Stream<Person> people(){
        return Stream.of(new Person(1001,"Peter"),new Person(1002,"Paul"),new Person(1003,"Mary"));
    }

    public static void main(String[] args) {
        Map<Integer, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: "+idToName);

        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson: "+idToPerson.getClass().getName()+idToPerson);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(Collectors.toMap(
                Locale::getDisplayLanguage,
                l -> l.getDisplayLanguage(l),
                (e, n) -> e
        ));
        System.out.println("LanguageNames: "+languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(Collectors.toMap(
                Locale::getDisplayCountry,
                l -> Set.of(l.getDisplayLanguage(l)),
                (a, b) -> {
                    HashSet<String> union = new HashSet<>(a);
                    union.addAll(b);
                    return union;
                }
        ));
        System.out.println("countryLanguageSets: "+countryLanguageSets);

    }
    public static class TestGrouping{
        public static void main(String[] args) {
            var locales = Stream.of(Locale.getAvailableLocales());
            Map<String, List<Locale>> collect = locales.collect(Collectors.groupingBy(Locale::getDisplayLanguage));
            System.out.println(collect.get("中文"));

            locales = Stream.of(Locale.getAvailableLocales());
            var locales1 = Stream.of(Locale.getAvailableLocales());
            Map<String, List<Locale>> collect1 = locales.collect(Collectors.groupingBy(Locale::getCountry));
            Map<String, Set<Locale>> collect2 = locales1.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));

            System.out.println(collect1.get("CN").size());
            System.out.println(collect2.get("CN").size());

            locales = Stream.of(Locale.getAvailableLocales());
            Map<String, Long> collect3 = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
            System.out.println(collect3);
        }
    }
    public static class TestDownCollectors{
        public static void main(String[] args) {
            Stream<String> names1 = Stream.of("Tiny", "Tin", "Amy", "Bobby", "Micheal", "Mike", "Candy", "Doggo");
            Stream<String> names2 = Stream.of("Tiny", "Tin", "Amy", "Bobby", "Micheal", "Mike", "Candy", "Doggo");
            Long count1 = names1.count();
            Long count2 = names2.collect(Collectors.counting());
            System.out.println(count1);
            System.out.println(count2);

            Stream<String> names3 = Stream.of("Tiny", "Tin", "Amy", "Bobby", "Micheal", "Mike", "Candy", "Doggo");
            Stream<String> names4 = Stream.of("Tiny", "Tin", "Amy", "Bobby", "Micheal", "Mike", "Candy", "Doggo");
            List<Integer> collect1 = names3.collect(Collectors.mapping(String::length, Collectors.toList()));
            List<Integer> collect2 = names4.map(String::length).collect(Collectors.toList());
            System.out.println(collect1);
            System.out.println(collect2);

        }
    }
    public static class TestCollectorAndThen{
        public static void main(String[] args) {
            Stream<String> names = Stream.of("Tiny", "Tin", "Amy", "Bobby", "Micheal", "Mike", "Candy", "Doggo");
            Map<Integer, Integer> collect = names.collect(Collectors.groupingBy(String::length,
                    Collectors.collectingAndThen(Collectors.toSet(), Set::size)));
            System.out.println(collect);
        }
    }
}
