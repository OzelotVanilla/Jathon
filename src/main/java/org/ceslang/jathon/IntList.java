package org.ceslang.jathon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.ceslang.jathon.builtin.inted;


/**
 * What is new?<br>
 * Add ArrayList<Integer> toArrayList() <br>
 * Add IntList(String) <br>
 * Change expression of some function
 */

public class IntList implements Iterable<Integer>
{

    public final String $version = "0.3.0.0-alpha";
    private int[] data;
    private int length;


    public IntList()
    {
        this(16);
    }

    public IntList(int length)
    {
        data = new int[length];
        this.length = length;
    }

    public IntList(String arg)
    {
        this(arg, " ");
    }

    public IntList(String arg, String split)
    {
        this(inted(arg.split(split)));
    }

    /**
     * This constructor allows you to convert a String array to an IntList array.<br>
     * For example:
     *
     * @param arg
     */
    public IntList(String[] arg)
    {
        this();
        this.data = inted(arg);
        this.length = data.length;
    }

    public IntList(int... args)
    {
        this();
        this.data = Arrays.copyOf(args, args.length);
        length = args.length;
    }

    public IntList(int[]... args)
    {
        this();
        int len = 0;
        for (int[] l : args)
        {
            len += l.length;
        }
        this.data = new int[len];
        this.length = len;
        int c = 0;
        for (int[] l : args)
        {
            for (int e : l)
            {
                this.data[c] = e;
                c += 1;
            }
        }
    }


    public Iterator<Integer> iterator()
    {
        return new Iterator<>()
        {
            int count = 0;

            public boolean hasNext()
            {
                return count < IntList.this.length;
            }

            public Integer next()
            {
                if (count == IntList.this.length)
                {
                    throw new ArrayIndexOutOfBoundsException("Index " + count + " Size " + IntList.this.length);
                }
                return data[count++];
            }
        };
    }


    @Override
    public String toString()
    {
        return "IntList" + toStringPure();
    }

    public String toStringPure()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int j = 0; j < length; j++)
        {
            int i = data[j];
            s.append(i).append(",");
        }
        if (length > 0)
        {
            s.deleteCharAt(s.length() - 1);
        }
        s.append("]");
        return s.toString();
    }


    public ArrayList<Integer> toArrayList()
    {
        ArrayList<Integer> r = new ArrayList<Integer>(this.length);
        for (int i = 0; i < this.length; i++)
        {
            r.add(i, this.data[i]);
        }
        return r;
    }


    public void setAllTo(int target)
    {
        Arrays.fill(this.data, 0, length, target);
    }

    public void sort()
    {
        Arrays.sort(this.data, 0, length);
    }

    public int[] toArray()
    {
        return Arrays.copyOf(this.data, this.length);
    }

    public void append(int x)
    {
        ensureLength(1);
        data[length++] = x;
    }

    private void ensureLength(int lengthAppend)
    {
        if (data.length >= length + lengthAppend)
        {
            return;
        }
        int newLength = data.length;
        while (newLength < length + lengthAppend)
        {
            newLength = Math.max(newLength << 1, 1);
        }
        data = Arrays.copyOf(data, newLength);
    }

    public void append(int[] obj)
    {
        append(obj, obj.length);
    }

    public void append(int[] obj, int length)
    {
        ensureLength(length);
        for (int i = this.length, j = 0; j < length; i++, j++)
        {
            data[i] = obj[j];
        }
        this.length = this.length + length;
    }

    public void append(IntList obj)
    {
        append(obj.data, obj.length);
    }

    public boolean has(int x)
    {
        for (int j = 0; j < length; j++)
        {
            int i = data[j];
            if (i == x)
            {
                return true;
            }
        }
        return false;
    }

    public int popObj(int obj)
    {
        for (int i = 0; i < this.length; i++)
        {
            if (obj == this.data[i])
            {
                if (length - i > 1)
                {
                    System.arraycopy(this.data, i + 1, data, i, length - i);
                }
                length--;
                return i;
            }
        }
        throw new NoSuchElementException("No such Element in this IntList");
    }

    public int popIndex(int index)
    {
        int ret = this.data[index];
        System.arraycopy(data, index + 1, data, index, length - index - 1);
        length--;
        return ret;
    }

    public void reset()
    {
        this.data = new int[16];
        length = 0;
    }
}