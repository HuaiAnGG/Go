package wiki.laona.eventbus;

import com.google.common.annotations.Beta;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author huaian
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.METHOD)
@Beta
public @interface Subscribe {
    String[] value();
}
