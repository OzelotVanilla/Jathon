package org.ceslang.jathon.time.calendar;

import org.ceslang.jathon.time.Fecha;
import org.ceslang.jathon.time.TimeUnit;
import org.ceslang.jathon.time.Timezone;

import java.math.BigInteger;

/**
 * Calender
 */
public abstract class CalendarSystem
{

    public abstract TimeUnit[] getSupportedTimeUnit();

    public abstract BigInteger[] expressFecha(BigInteger timeStamp, Timezone timezone);

    public abstract Fecha adjust(Fecha o, VariableTimeUnit unit, BigInteger offset);

    public static class TemplateCalenderSystem extends CalendarSystem
    {

        private final TimeUnit[] supportedTimeUnits;

        public TemplateCalenderSystem(TimeUnit... supportedTimeUnits)
        {
            this.supportedTimeUnits = supportedTimeUnits;
        }

        @Override
        public TimeUnit[] getSupportedTimeUnit()
        {
            return supportedTimeUnits;
        }

        @Override
        public BigInteger[] expressFecha(BigInteger timeStamp, Timezone timezone)
        {
            // TODO
            return new BigInteger[0];
        }

        @Override
        public Fecha adjust(Fecha o, VariableTimeUnit unit, BigInteger offset)
        {
            return o;
        }
    }
}