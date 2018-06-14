package LittleCourse.c_Functional_Interfaces;

import LittleCourse.a_Default_Methods_for_Interfaces.Formula;
import org.junit.jupiter.api.Test;
import pojo.Person;
import pojo.Something;

public class test {

    @Test
    public void lambda3_1(){
        Converter<String,Integer> converter = (input) -> Integer.valueOf(input);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

    /**
     *
     * 上面的例子可以通过方法引用来简化
     *  类名::方法名
     *
     *  Java8使你可以通过关键字::传递方法或构造方法的引用
     *
     */

    @Test
    public void lambda3_2(){
        Converter<String,Integer> converter = Integer::valueOf;

        Integer output = converter.convert("123");
        System.out.println(output);    // 123
    }

    /**
     * 上面是静态方法的引用，还可以引用对象的方法
     */

    @Test
    public void lambda3_3(){
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);    // "J"
    }


    /**
     * 下面我们看一下如何用::关键字引用构造方法
     *
     *  首先定义一个有不同构造方法的类Person
     *  然后创建一个工厂接口用来创建Person对象
     *
     *  不需要在手动的实现工厂接口，通过构造方法的引用将它们粘合起来
     *
     */

    /**
     * 我们通过Person::new创建了Person构造方法的引用，Java编译器会自动选择
     * 正确的构造方法来匹配 personFactory.create
     *
     */

    @Test
    public void lambda3_4(){
       PersonFactory<Person> personFactory = Person::new;
       Person p = personFactory.create("王","狗蛋");
        System.out.println(p);

    }


    /*******************    lambda作用域    ***************************/

       /* 在Lambda表达式中访问外层作用域，这一点和旧版本的匿名对象中的方式类似。Lambda表达式中可以直接访问外部final变量，
         或者实例的字段以及静态变量。
        */


     @Test
     public void lambda5_1(){
         final int num = 1;
         Converter<Integer, String> stringConverter =
                 (from) -> String.valueOf(from + num);
        // num++;
         stringConverter.convert(2);     // 3

     }

     // 不需要显式的声明final,以下代码有效
    @Test
    public void lambda5_2(){
        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        stringConverter.convert(2);     // 3

    }

/*    在以前的java版本中匿名内部类的参数必须是final的，原因在于保证内部和外部类的数据一致性。
    编译的时候内部类和方法在同一级别上，所以方法中的变量或参数只有为final，内部类才可以引用。
    因为局部变量在方法调用之后就消失了，使用final声明的话该局部变量会存入堆中，和内部类有一样的声明周期。
    然而java8中不加final，
    也可以通过编译，在以前的版本中是不允许的。
 */

    /****
     *   这里的num 必须是隐式的final才能去编译，下面代码编译不通过。
     *   在lambda表达式中对num进行更改也许不允许的。
     */
    @Test
    public void lambda5_3(){
        int num = 1;
        // Effectively final
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);


        new  Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(num);
            }
        });
        // num = 3;
    }
    /****
     *   小总结： lambda表达式对方法内的局部变量只能读，不能写。 编译器是按final进行编译的。
     */



    /****
     *   和 局部变量不同的是，在lambda表达式内对静态变量和全局变量即可读又可写，这一点和内部类一样。
     *
     *   附：lambda表达式中存在一行以上代码需要加大括号｛｝
     */
        static int outerStaticNum;
        int outerNum;

        @Test
        public void lambda5_4(){
            Converter<Integer, String> stringConverter1 = (from) -> {
                outerNum = 23;
                return String.valueOf(from);
            };

            Converter<Integer, String> stringConverter2 = (from) -> {
                outerStaticNum = 72;
                return String.valueOf(from);
            };

            Converter<Integer, String> stringConverter3 = (from) ->
                String.valueOf(from);

        }

    /****
     *   还记得第一节我们在接口Formula定义了 default 方法 sqrt，它可以被每个 Formula实例访问。
     *
     *   但lambda表达式之内不能访问接口中的default方法。
     */
    @Test
    public void lambda5_5(){
        // Formula formula = (a) -> sqrt(a * 100);

    }

}
