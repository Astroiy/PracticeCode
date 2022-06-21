package LearnMaps;
import java.util.HashMap;
public class MapTest {
    public static void main(String[] args) {
        var staff = new HashMap<String,Employee>();
        staff.put("144-25-5464",new MapTest().new Employee("Amy Lee"));
        staff.put("567-24-2546",new MapTest().new Employee("Harry Hacker"));
        staff.put("157-62-7935",new MapTest().new Employee("Gary Cooper"));
        staff.put("456-62-5527",new MapTest().new Employee("Francesca Cruz"));

        System.out.println(staff);

        staff.remove("567-24-2546");

        staff.put("456-62-5527",new MapTest().new Employee("Francesca Miller"));

        System.out.println(staff.get("157-62-7935"));

        staff.replace("157-62-7935",new MapTest().new Employee("Tiny Chou"));

        staff.forEach((k,v)-> System.out.println("key="+k+","+"value="+v));

    }
    private class Employee{
        private String name;
        Employee(String name){
            this.name=name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

