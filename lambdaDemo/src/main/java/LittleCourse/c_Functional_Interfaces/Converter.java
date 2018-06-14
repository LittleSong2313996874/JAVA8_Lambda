package LittleCourse.c_Functional_Interfaces;


/**
 * 每个lambda对应一个类型，这个类型有接口指定。
 *
 * 函数式节诶看不学包含一个抽象方法的声明，每个对应类型lambda表达式将可以和这个抽象方法匹配
 *
 * default方法不是抽象的，你随便加
 *
 * 我们可以用任意接口作为lambda表达式，只要这个接口仅含有一个抽象方法。为了确保这一点，你可以在你的接口上加上
 *  @FunctionalInterface 注解，这样在你视图再次增加抽象方法是，编译器会检查报错
 *
 *  但是，即使 @FunctionalInterface 注解被省略代码也依然有效
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

