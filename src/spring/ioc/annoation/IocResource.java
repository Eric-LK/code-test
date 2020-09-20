package spring.ioc.annoation;

import java.lang.annotation.*;

/***
 * 自动注入类的注解
 * @author 17734
 */

/*
 *  Documented注解表明这个注释是由 javadoc记录的，
 *  在默认情况下也有类似的记录工具。 如果一个类型声明被注释了文档化，它的注释成为公共API的一部分。
 */
@Documented
/*
 * 表示注释在哪里记录
 * SOURCE：源码级别，编译时就忽略
 * CLASS：编译时在类文件中记录，但运行时不需要jvm保留，这是默认的
 * RUNTIME：不仅在类文件中记录，而且在jvm中保留，因此可以反读
 */
@Retention(RetentionPolicy.RUNTIME)
/*
 * 表示注解用在哪
 * TYPE：类，接口，枚举；
 * FIELD：字段声明；
 * METHOD；方法；
 * CONSTRUCTOR：构造函数
 * LOCAL_VARIABLE：局部变量
 * ANNOTATION_TYPE：注释类型声明
 * PACKAGE：包声明
 */
@Target(ElementType.FIELD)
public @interface IocResource {
}
