package AboutInterface;

import java.util.Objects;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Animal Momo = new Animal("Monkey","Male");
        Animal anonymous = null;
        Animal Another1 = Objects.requireNonNullElse(Momo,new Animal("Unknown","Unknown"));
        Animal Another2 = Objects.requireNonNullElseGet(anonymous,new Animal("ImpleSupplier","None"));
        Animal Another3 = Objects.requireNonNullElseGet(anonymous,()->new Animal("LambdaImple","None"));
        Animal Another4 = Objects.requireNonNullElseGet(anonymous,new Animal()::get);
        Animal Another5 = Objects.requireNonNullElseGet(anonymous,()->new Animal().get());
        Animal Another6 = Objects.requireNonNullElseGet(anonymous,Animal::new);
        System.out.println(Another1);
        System.out.println(Another2);
        System.out.println(Another3);
        System.out.println(Another4);
        System.out.println(Another5);
        System.out.println(Another6);
    }
}

class Animal implements Supplier<Animal> {
    private String species;
    private String gender;
    public Animal(){};
    public Animal(String species,String gender){
        this.species = species;
        this.gender = gender;
    }
    @Override
    public Animal get(){
        return new Animal();
    }
    @Override
    public String toString(){
        return "Species: "+species+" "+"Gender: "+gender;
    }
}
