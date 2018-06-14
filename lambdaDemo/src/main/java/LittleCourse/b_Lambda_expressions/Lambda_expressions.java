package LittleCourse.b_Lambda_expressions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *让我们首先用老版本，通过对一个含字符串的list进行排序来开始
 *
 *静态的工具类方法Collections.sort接受一个list和比较器来对对list中的元素进行排序
 *
 *  创建一个匿名的比较器然后将参数传递给比较方法。
 *
 * compareTo
 * 调用者小于、等于或大于指定对象，则分别返回负整数、零或正整数
 */
public class Lambda_expressions {

    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    @Test
    public void lambda2(){

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int i =  a.compareTo(b);
                //System.out.println(i+"");
                return i;
            }
        });
        //降序排列，如果要升序，改为a.compareTo(b);
        System.out.println(names);  //[xenia, peter, mike, anna]
    }

    /**
     * 不用再整天创建匿名对象了，Java8提供了一种更简洁的语法，即lambda表达式
     *
     */
    @Test
    public void lambda2_1(){

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        System.out.println(names);  //[xenia, peter, mike, anna]
    }
    /**
     * 通过上面可以看到代码更加简单易读，而且可以更短
     */
    @Test
    public void lambda2_2(){

        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        System.out.println(names);
    }
    /**
     * 对于一行的方法体，你可以省略大括号和return关键字，然而，它还可以更短
     *
     * 因为Java8后，list接口里增加了sort方法，可以直接用，不需要再借助Collections
     * 注意，要想让接口里的方法可以有方法体，要用default修饰
     *
     * Java编译器会推断出你的变量类型，所以也省略
     */
    @Test
    public void lambda2_3(){

       names.sort( (a,b) -> b.compareTo(a));

        System.out.println(names);
    }

}
