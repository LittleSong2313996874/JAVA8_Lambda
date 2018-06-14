package LittleCourse.a_Default_Methods_for_Interfaces;

/**
 * 小课堂内容全部翻译自:https://github.com/winterbe/java8-tutorial; 如有错误，还望指正
 *
 * Java8中，你可以通过defaulte关键字，添加非抽象方法
 *
 * 函数式接口运行存在默认方法、静态方法
 *
 * 如下，抽象方法calculate旁还有一个sqrt方法， 实现类只需要实现抽象方法calculate
 * default方法sqrt是开箱即用的(out of the box).
 *
 * 注： Math.sqrt函数是计算平方根的。
 */
@FunctionalInterface
public interface Formula {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}


















/*
*

    static double aa(int a) {
        return Math.sqrt(a);
    }
    default double sqrt1(int a) {
        return Math.sqrt(a);
    }

    static double aa1(int a) {
        return Math.sqrt(a);
    }

* */