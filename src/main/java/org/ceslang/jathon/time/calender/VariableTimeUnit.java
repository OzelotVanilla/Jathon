package org.ceslang.jathon.time.calender;

import org.ceslang.jathon.time.TimeUnit;

public class VariableTimeUnit extends TimeUnit
{
    public static final VariableTimeUnit MINUTE = new VariableTimeUnit("minute");
    public static final VariableTimeUnit DAY_OF_WEEK = new VariableTimeUnit("dayOfWeek");
    public static final VariableTimeUnit MONTH = new VariableTimeUnit("month");
    public static final VariableTimeUnit YEAR = new VariableTimeUnit("year");
    public static final VariableTimeUnit CENTURY = new VariableTimeUnit("century");

    public VariableTimeUnit(String name)
    {
        super(name);
    }

    @Override
    public String toString()
    {
        return "VariableTimeUnit{" + "name='" + getName() + '\'' + '}';
    }
}
