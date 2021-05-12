package org.ceslang.jathon.exception.args;

public class OutOfRangeExcp extends BadArgExcp
{
    public OutOfRangeExcp(String expect, String given)
    {
        super(expect, given);
    }
}