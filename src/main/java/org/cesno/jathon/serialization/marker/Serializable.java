package org.cesno.jathon.serialization.marker;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Serializable
{

    String typeName();

    boolean isComplete() default false;

}
