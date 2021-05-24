package org.ceslang.jathon.time.calender;

import org.ceslang.jathon.time.ConstantTimeUnit;

public class CalenderSystems
{
    public static final CalendarSystem GREGORIAN =
            new CalendarSystem.TemplateCalenderSystem(
            VariableTimeUnit.CENTURY,
            VariableTimeUnit.YEAR,
            VariableTimeUnit.MONTH,
            ConstantTimeUnit.DAY,
            VariableTimeUnit.DAY_OF_WEEK);
}
