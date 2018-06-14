package LittleCourse.c_Functional_Interfaces;
import pojo.Person;

/**
 *  泛型上下限
 *
 * ？extends E: 接收E类型或者E的子类型。
 *  ? super E: 接收E类型或者E的父类型
 * @param <P>
 */

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}