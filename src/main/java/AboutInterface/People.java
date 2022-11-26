package AboutInterface;

import java.util.Arrays;
import java.util.Comparator;

public class People {
    private int id;

    private String firstName;
    private String middleName;
    private String lastName;

    public People(){}

    public People(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +" Name: "+String.join(" ",firstName,middleName,lastName)+"}";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
class Test{
    public static void main(String[] args) {
        People[] people = new People[3];
        people[0] = new People(3,"Harry",null,"Potter");
        people[1] = new People(1,"Tiny","Lia","Tony");
        people[2] = new People(2,"Hathaway","Noah","Green");

        System.out.println("原数组:\n"+Arrays.toString(people));

        Arrays.sort(people, Comparator.comparing(People::getFirstName).thenComparing(People::getLastName));
        System.out.println("先按fistName的字典序排序然后按lastName的字典序排序:\n"+Arrays.toString(people));
        Arrays.sort(people,Comparator.comparing(People::getLastName).thenComparing(People::getFirstName));
        System.out.println("先按lastName的字典序排序然后按fistName的字典序排序:\n"+Arrays.toString(people));

        Arrays.sort(people,Comparator.comparing(People::getFirstName,(x,y)->Integer.compare(x.length(),y.length())));
        Arrays.sort(people,Comparator.comparing(People::getFirstName,(x,y)->x.length()-y.length()));
        Arrays.sort(people,Comparator.comparing(People::getFirstName,Comparator.comparingInt(x->x.length())));
        System.out.println("三种方式按firstName的长度排序:\n"+Arrays.toString(people));

        Arrays.sort(people,Comparator.comparingInt(People::getId));
        System.out.println("按照id排序:\n"+Arrays.toString(people));
        Arrays.sort(people,Comparator.<People>comparingInt(x->x.getId()).reversed());
        System.out.println("按照id逆序排序:\n"+Arrays.toString(people));

        Arrays.sort(people,Comparator.comparing(People::getMiddleName, Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println("按照middleName的字典序排序，null排前:\n"+Arrays.toString(people));
        Arrays.sort(people,Comparator.comparing(People::getMiddleName,Comparator.nullsLast(Comparator.reverseOrder())));
        System.out.println("按照middleName的字典序排序，null排后:\n"+Arrays.toString(people));
    }
}