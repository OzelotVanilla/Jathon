package org.ceslang.jathon.time.calendar;

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
    }
}