package JUnit;

import org.junit.*;

public class Student {
    @Test
    public void test1(){                 //测试方法不能有参数和返回值,而且必须是public实例方法,可以有异常声明,  一次执行全部测试方法会按照方法名升序排序运行
        System.out.println("Test method1");
    }

    @Test
    public void test2(){
        System.out.println("Test method2");
    }

    @Before
    public void b1(){                     //所有Before方法会每个测试方法前倒序执行
        System.out.println("b1");
    }
    @Before
    public void b2(){
        System.out.println("b2");
    }

    @After
    public void a1(){
        System.out.println("a1");
    }

    @After
    public void a2(){
        System.out.println("a2");
    }

    @BeforeClass
    public static void bc(){
        System.out.println("bc");
    }

    @AfterClass
    public static void ac(){
        System.out.println("ac");
    }

}

