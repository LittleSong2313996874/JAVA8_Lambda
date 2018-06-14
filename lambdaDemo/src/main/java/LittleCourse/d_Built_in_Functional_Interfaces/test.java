package LittleCourse.d_Built_in_Functional_Interfaces;

import LittleCourse.a_Default_Methods_for_Interfaces.Formula;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 *Predicate是一个接受一个参数的布尔型方法，内置了多个默认方法，用来构成复杂的逻辑术语
 * and, or, negate 且 或  取反
 *
 */
public class test {

    @Test // lambda表达式
    public void lambda16_1(){
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(   predicate.test("foo")   );              // true
        System.out.println(        predicate.negate().test("foo")        );     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


    }



    /**
     *  Function接受一个参数并产生一个返回值，内置的默认方法可以将多个Function连起来
     *   Default methods can be used to chain multiple functions together (compose, andThen).
     */
    @Test // lambda表达式
    public void lambda16_2(){
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        //System.out.println(   toInteger.apply("123456")   );
        System.out.println(             backToString.apply("123")       );     // "123"

    }


    @Test // 开启线程示例
    public void lambda16_3(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("线程1");
            }
        }).start();

       new Thread( () -> System.out.println("线程1")).start();

    }



}
