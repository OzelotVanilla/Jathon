package org.ceslang.jathon.funcutil;

import org.ceslang.jathon.builtin;

import java.util.function.BiConsumer;

public class CompareChain<EleType> extends FuncInvokeChain
{
    private BiConsumer<EleType, EleType> a_greater_b, a_equal_b, a_less_b;

    public CompareChain(EleType a, EleType b)
    {
        
    }

    public CompareChain<EleType> ifLess(BiConsumer<EleType, EleType> action)
    {
        this.a_less_b = action;
        return this;
    }

    public CompareChain<EleType> ifGreater(BiConsumer<EleType, EleType> action)
    {
        this.a_greater_b = action;
        return this;
    }

    public CompareChain<EleType> ifEqual(BiConsumer<EleType, EleType> action)
    {
        this.a_equal_b = action;
        return this;
    }
}