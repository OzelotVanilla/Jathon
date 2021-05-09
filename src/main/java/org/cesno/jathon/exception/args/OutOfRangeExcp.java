package org.cesno.jathon.exception.args;

import org.cesno.jathon.exception.ExceptionReason;

public class OutOfRangeExcp extends BadArgExcp
{
    public OutOfRangeExcp(String expect, String given)
    {
        super(expect, given);
    }
}