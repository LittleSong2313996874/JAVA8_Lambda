package LittleCourse.a_Default_Methods_for_Interfaces;

import org.junit.jupiter.api.Test;

/**
 *
 * 这个formula 接口被实现为一个匿名对象，代码是很繁琐的————这么多代码仅仅为了一个简单的运算sqrt(a * 100)
 *
 * 在下一个环节，Java8有一种更好的方式实现单方法对象
 *
 */
public class test {

    @Test // lambda表达式
    public void lambda1(){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a*100);
            }
        };
        System.out.println(        formula.calculate(100)      );

        System.out.println(    formula.sqrt(16)     );


    }
}
