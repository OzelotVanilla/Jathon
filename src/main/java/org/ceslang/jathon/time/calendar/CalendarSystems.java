package org.ceslang.jathon.time.calendar;

import org.ceslang.jathon.time.ConstantTimeUnit;

public class CalendarSystems
{
    public static final CalendarSystem GREGORIAN = new CalendarSystem.TemplateCalenderSystem(VariableTimeUnit.CENTURY,
            VariableTimeUnit.YEAR, VariableTimeUnit.MONTH, VariableTimeUnit.DAY, ConstantTimeUnit.WEEK);
}
