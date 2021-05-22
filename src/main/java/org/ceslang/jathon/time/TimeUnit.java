package org.ceslang.jathon.time;

public class TimeUnit
{

    private final String name;

    /**
     * @param name
     * @apiNote TimeUnit is an abstract concept. It has two meaning.
     * One is a constant length of time like one hour is 3,600,000 seconds.
     * Another meaning is a number based on calender system.
     * For example, one year can be 265 days, 366 days in gregorian or many other cases in other calender systems.
     */
    public TimeUnit(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "TimeUnit{" + "name='" + getName() + '\'' + '}';
    }

}
