package AboutInterface.InnerClass;

import java.util.Objects;

public class InnerAndOuterTest {
    public static void main(String[] args) {

        DotThis dt_outer = new DotThis("outer1","outer2");
        DotThis.Inner dt_inner = dt_outer.new Inner();
        System.out.println(dt_inner.get_innerOuter());
        System.out.println(dt_inner.get_newOuter());

        System.out.println();

        DotNew dn_outer = new DotNew();
        DotNew.Inner dn_inner_first = dn_outer.new Inner();
        DotNew.Inner dn_inner_second = dn_outer.new Inner("first","second");
        System.out.println(dn_inner_first);
        System.out.println(dn_inner_second);

        DotThis.Inner.value();
    }
}
class DotThis{
    private String outer1;
    private String outer2;
    public DotThis(){}
    public DotThis(String outer1,String outer2){
        this.outer1 = outer1;
        this.outer2 = outer2;
    }
    public DotThis getAnonymousObject(){
        return new DotThis(){
            private String ano;
        };
    }
    public DotThis getAnonymousObject1(){
        return new DotThis(){
            private String ano;
            private String ano1;
        };
    }
    public class Inner{
        private String inner1;
        private String inner2;
        public Inner(){}
        public Inner(String inner1,String inner2){
            this.inner1 = inner1;
            this.inner2 = inner2;
        }
        public static void value(){
            System.out.println("static");
        }
        public DotThis get_innerOuter(){
            return DotThis.this;
        }
        public DotThis get_newOuter(){
            return new DotThis();
        }
    }
    public String toString(){
        return "Outer1: "+outer1+" "+"Outer2: "+outer2;
    }

    public boolean equals(Object other_object){
        if(this==other_object)
            return true;
        else if(other_object==null)
            return false;
        else if(getClass()!=other_object.getClass())
            return false;
        var other = (DotThis) other_object;
        return Objects.equals(outer1,other.outer1) && Objects.equals(outer2,other.outer2);
    }
}
class DotNew {
    public class Inner {
        private String inner1;
        private String inner2;
        public Inner(){}
        public Inner(String inner1,String inner2){
            this.inner1 = inner1;
            this.inner2 = inner2;
        }

        public String toString(){
            return "Inner1: "+inner1+" "+"Inner2: "+inner2;
        }
    }
}

