package spring.ioc.annoation;

import java.lang.annotation.*;

/**
 * @author 17734
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IocService {
    String name() default "";
}
