package org.ceslang.jathon.time;

public class TimeUnit
{

    private final String name;

    /**
     * @apiNote TimeUnit is an abstract concept. It has two meaning.
     * One is a constant length of time like one second is 1,000 milliseconds.
     * Another meaning is a number based on calender system.
     * For example, one year can be 365 days, 366 days in gregorian or many other cases in other calender systems.
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
