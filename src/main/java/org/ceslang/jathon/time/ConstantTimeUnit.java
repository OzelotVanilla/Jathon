package org.ceslang.jathon.time;

import java.math.BigInteger;

public class ConstantTimeUnit extends TimeUnit
{

    public static ConstantTimeUnit MILLISECOND = new ConstantTimeUnit("millisecond", BigInteger.valueOf(1));
    public static ConstantTimeUnit SECOND = new ConstantTimeUnit("second", BigInteger.valueOf(1000).multiply(MILLISECOND.getLength()));
    public static ConstantTimeUnit MINUTE = new ConstantTimeUnit("minute", BigInteger.valueOf(60).multiply(SECOND.getLength()));
    public static ConstantTimeUnit HOUR = new ConstantTimeUnit("hour", BigInteger.valueOf(60).multiply(MINUTE.getLength()));
    public static ConstantTimeUnit DAY = new ConstantTimeUnit("day", BigInteger.valueOf(24).multiply(HOUR.getLength()));
    public static ConstantTimeUnit WEEK = new ConstantTimeUnit("week", BigInteger.valueOf(7).multiply(DAY.getLength()));
    public static ConstantTimeUnit MONTH = new ConstantTimeUnit("month", BigInteger.valueOf(30).multiply(DAY.getLength()));
    public static ConstantTimeUnit YEAR = new ConstantTimeUnit("year", BigInteger.valueOf(365).multiply(DAY.getLength()));

    private final BigInteger length;

    public ConstantTimeUnit(String name, long length)
    {
        this(name, BigInteger.valueOf(length));
    }

    public ConstantTimeUnit(String name, BigInteger length)
    {
        super(name);
        this.length = length;
    }

    public BigInteger getLength()
    {
        return length;
    }

    @Override
    public String toString()
    {
        return "ConstantTimeUnit{" + "name=" + getName() + "length=" + getLength() + '}';
    }
}
