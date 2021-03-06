package org.ceslang.jathon.serialization.marker;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Archives.class)
public @interface Archive
{

    String departedTagName();

}