package org.ceslang.jathon.time;

import static org.ceslang.jathon.builtin.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;


public class Timezone
{
    /**
     * <p>
     * Save the offset of time in precision of seconds.
     * </p>
     *
     * <p>
     * Example: Paris is {@code UTC +02:00}, its {@code offset} is {@code +7200} (2 * 3600).
     * </p>
     */
    private int offset;

    /**
     * Get OS's timezone as {@code Timezone}.
     */
    public Timezone()
    {
        this(ZoneId.systemDefault());
    }

    public Timezone(ZoneId zid)
    {
        this(zid.getRules().getOffset(Instant.now()));
    }

    public Timezone(ZoneOffset zof)
    {
        this(zof.getTotalSeconds());
    }

    /**
     * @param offset The offset (from UTC +00:00) in second.
     */
    public Timezone(int offset)
    {
        this.setOffset(offset);
    }

    public Timezone(int hrs, int min)
    {
        if (abs(hrs) <= 18 && min >= 0 && min <= 59)
        {
            this.setOffset(hrs * 3600 + min * 60);
        }
        else
        {
            print("You are initializing Timezone in a wrong way.");
            if (abs(hrs) > 18)
            {
                print("\tCannot use a number which abs is greater than 18 for hour.");
                print("\t\tExpected: abs(hrs) <= 18.\tGot " + hrs);
            }
            if (min < 0 || min > 59)
            {
                print("\tCannot use a number which abs is greater than 18");
                print("\t\tExpected: 0 <= min <= 59.\tGot " + min);
            }
            print("\tInit failed.\n");
            throw new IllegalArgumentException("Arg(s) out of range");
        }
    }


    public String getOffHours()
    {
        return (this.offset >= 0 ? "+" : "-") + intFmt(this.offset / 3600);
    }

    public String getOffMinutes()
    {
        return intFmt(this.offset / 60);
    }

    public String getOffHoursColonMinutes()
    {
        return this.getOffHours() + ":" + intFmt(this.offset % 60);
    }

    private String intFmt(int x)
    {
        return abs(x) < 10 ? "0" + x : str(x);
    }


    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public int getOffset()
    {
        return this.offset;
    }
}