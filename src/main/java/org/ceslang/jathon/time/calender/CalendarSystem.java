package org.ceslang.jathon.time.calender;

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

        private final TimeUnit[] supported_time_units;

        public TemplateCalenderSystem(TimeUnit... supported_time_units)
        {
            this.supported_time_units = supported_time_units;
        }

        @Override
        public TimeUnit[] getSupportedTimeUnit()
        {
            return supported_time_units;
        }

        @Override
        public BigInteger[] expressFecha(BigInteger timeStamp, Timezone timezone)
        {
            //TODO
            return new BigInteger[0];
        }
    }
}