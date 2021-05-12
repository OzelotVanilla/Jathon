package org.ceslang.jathon.exception.args;

public abstract class BadArgExcp extends Throwable
{
    String expect;
    String given;

    public BadArgExcp(String expect, String given)
    {
        this.expect = expect;
        this.given = given;
    }
}