package org.ceslang.jathon.time;

import org.ceslang.jathon.time.calendar.CalendarSystem;
import org.ceslang.jathon.time.calendar.CalendarSystems;
import org.ceslang.jathon.time.calendar.VariableTimeUnit;

import java.io.*;
import java.math.*;
import java.time.*;
import java.util.*;

import static org.ceslang.jathon.builtin.*;


// import java.sql.Date;

/**
 * <p>
 * {@code org.ceslang.jathon.time.Fecha} ({@code Fecha}) は，Javaの従来の時間と関連する類(Class)と型(Type)を統合し，より使いやすいと機能が多い型です。
 * </p>
 *
 * <p>
 * {@code Fecha}型の物(Object)を作るには，構造関数{@code Fecha(Date)}や{@code Fecha(long timestamp)}を使うで十分。<br />
 * だだし，{@code type}が指定されない場合は{@code type=point}として見る(既定値)。
 * </p>
 *
 * <p>
 * The class <code>Fecha</code> can be seen as an enhanced version of original <code>java.util.Date</code>. It combines
 * time classes in Java, and can change it into one type.
 * </p>
 *
 * @author Ozelot Vanilla
 * @author Sean Yu
 * @since 1.16
 */
public class Fecha implements Externalizable, Cloneable, Comparable<Fecha>
{
    public static final String $default_format = "`default`";
    /**
     * <p>
     * First update of {@code Fecha}.
     * </p>
     */
    public final String $version = "0.2.6.0";

    public static final String $default_point_format = "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss` `UTC_tz`";

    private final type value_type;

    /**
     * <p>
     * 時間帯情報を{@code jathon.time.Timezone}で保存する。<br>
     * 既定値は使用者が使っているOSの時間帯です。
     * </p>
     *
     * <p>
     * {@code zone_info}を設定するには{@link #bindZone(ZoneOffset)}や{@link #bindZone(int)}を使ってください。
     * </p>
     */
    private final Timezone zone;

    /**
     * <p>
     * {@code value}は{@code Fecha}の時間の素値です。{@code type}が{@code point}のときはtimestamp， {@code period}のときは経過時間です。
     * </p>
     *
     * <p>
     * Save the value of time. It can mean point of time, or a period of time according to {@code type}.
     * </p>
     */
    private final BigInteger value;

    /**
     * <p>
     * {@code format}は{@code Fecha}の表現形式を制御します。<br>
     * "格式化情報提供子" (格式提供子) と言います。 <br>
     * 既定値は{@code "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss` `UTC`"}です。
     * </p>
     *
     * @see #setFormat(String)
     */
    private String format;

    private CalendarSystem calendar_system = CalendarSystems.GREGORIAN;


    public Fecha()
    {
        this(type.point, System.currentTimeMillis(), new Timezone(), $default_point_format);
    }

    public Fecha(Date date)
    {
        this(type.point, date.getTime());
    }

    public Fecha(java.sql.Date date)
    {
        this(type.point, date.getTime());
    }

    public Fecha(LocalDate ld)
    {
        this(type.point, Instant.from(ld).toEpochMilli());
    }

    public Fecha(LocalDateTime ldt)
    {
        this(type.point, Instant.from(ldt).toEpochMilli());
    }

    public Fecha(long timestamp)
    {
        this(type.point, timestamp);
    }

    /**
     * If there is only type specified, {@code point} will use current time as value, {@code period} use 0, {@code now}
     * use null.
     */
    public Fecha(type t)
    {
        this(t, t == type.now
                ? null
                : (t == type.period ? BigInteger.ZERO : new BigInteger(str(System.currentTimeMillis()))));
    }

    public Fecha(type t, long value)
    {
        this(t, new BigInteger(str(value)));
    }

    public Fecha(type t, BigInteger value)
    {
        this(t, value, t == type.period ? null : new Timezone(), $default_point_format);
    }

    public Fecha(ZoneId zi, long value)
    {
        this(zi, new BigInteger(str(value)));
    }

    public Fecha(ZoneId zi, BigInteger value)
    {
        this(type.point, value, new Timezone(zi), $default_point_format);
    }

    public Fecha(type t, long value, Timezone tz, String format)
    {
        this(t, new BigInteger(str(value)), tz, format);
    }

    /**
     * Standard initializer.
     */
    public Fecha(type t, BigInteger value, Timezone tz, String format)
    {
        this.value_type = t;
        this.value = value;
        this.zone = tz;
        this.format = format;
    }


    // @Override
    // public String toString()
    // {
    // // TODO Write it after you have designed format
    // }

    @Override
    public int compareTo(Fecha o)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        // TODO Auto-generated method stub

    }


    /**
     * <p>
     * {@code setFormat}は，{@code Fecha}の表現形式を制御する格式提供子{@link Fecha#format}を設定する関数です。<br>
     * "格式化(かくしきか)設定関数"とも言います。
     * </p>
     * <p>
     * 使い方は，表現したいのものを，下記のリストを参照し，backquote (`)で囲む，{@code format}の中に置きてください。
     * </p>
     * <p>
     * 例えば，"月(2位)-日(2位)-年(4位)"のような格式化された文字列をほしいなら，"`MM`-`DD`-`YYYY`"
     * </p>
     * <p>
     * 使える引数
     * <table>
     * <th>
     * <td>Placeholder</td>
     * <td>説明</td></th><br>
     * <tr>
     * </tr>
     * </table>
     * </p>
     * <p>
     * {@code format}の既定値は{@code "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss`"}です。
     * </p>
     * Save the format of formatted output. By default, it is {@code "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss`"}
     *
     * @param fmt 置き換えたい新しい格式提供子
     */
    public void setFormat(String fmt)
    {
        // See if the format is wrong
        // If missing '`' (the number of paired backquote is odd)
        // Count idea from https://www.baeldung.com/java-count-chars#4-using-java-8-features
        if ((fmt.replaceAll("```", "``").chars().filter(c -> c == '`').count() & 1) == 1)
        {
            throw new InputMismatchException("Check whether your backquote is put correctly");
        }

        this.format = fmt;
    }

    public void bindZone(ZoneOffset zone_info)
    {
        // TODO Auto-generated method stub
    }

    public void bindZone(int offset)
    {
        // TODO Auto-generated method stub
    }

    public void bindZone(Timezone tz)
    {
        // TODO Auto-generated method stub
    }

    public void bindCalendarSystem(CalendarSystem calendarSystem)
    {
        this.calendar_system = calendarSystem;
    }

    public void setValue(long value)
    {
        this.setValue(new BigInteger(str(value)));
    }

    public Fecha setValue(BigInteger value)
    {
        return new Fecha(value_type, value);
    }

    public type getValueType()
    {
        return value_type;
    }

    public Fecha setValueType(type value_type)
    {
        return new Fecha(value_type, value);
    }

    /**
     * @param period
     * @return
     */
    public Fecha adjust(Fecha period)
    {
        if (period.value_type == type.period)
        {
            return new Fecha(value_type, value.add(period.value));
        }
        else
        {
            throw new IllegalStateException("You can't offset with a Fecha who's type isn't period.");
        }
    }

    public Fecha adjust(TimeUnit unit, BigInteger offset)
    {
        switch (value_type)
        {
            case period :
                if (unit instanceof ConstantTimeUnit)
                {
                    return new Fecha(value_type, value.add(((ConstantTimeUnit) unit).getLength().multiply(value)));
                }
                else
                {
                    throw new IllegalArgumentException("You can't offset a period with a VariableTimeUnit.");
                }
            case point :
                return calendar_system.adjust(this, (VariableTimeUnit) unit, value);
            case now :
                throw new IllegalStateException("You can't offset a Fecha who's type is now.");
            default :
                throw new IllegalStateException("Unexpected value: " + value_type);
        }
    }

    /**
     * Express Fecha object in given format unit, and then give back number sequence using given unit.
     *
     * @param format The time unit you want to let Fecha to change format to
     * @return Array of BigInteger corresponding to given time unit
     */
    public BigInteger[] express(TimeUnit... format)
    {
        BigInteger remaining;
        BigInteger[] expression = new BigInteger[format.length];
        BigInteger[] partExpression;
        TimeUnit[] structure;
        switch (this.value_type)
        {
            case now :
                partExpression = calendar_system.expressFecha(BigInteger.valueOf(System.currentTimeMillis()), zone);
                remaining = partExpression[0];
                structure = calendar_system.getSupportedTimeUnit();
                break;
            case period :
                remaining = value;
                partExpression = null;
                structure = null;
                break;
            case point :
                partExpression = calendar_system.expressFecha(value, zone);
                remaining = partExpression[0];
                structure = calendar_system.getSupportedTimeUnit();
                break;
            default :
                throw new IllegalStateException("Unexpected value: " + value_type);
        }
        for (int i = 0; i < format.length; i++)
        {
            int j = 0;
            if (partExpression != null)
            {
                for (int length = partExpression.length - 1; j < length; j++)
                {
                    TimeUnit oneBit = structure[j];
                    if (format[i] == oneBit)
                    {
                        break;
                    }
                }
            }
            if (j != 0)
            {
                expression[i] = partExpression[j + 1];
            }
            else
            {
                BigInteger[] divideAndRemainder = remaining
                        .divideAndRemainder(((ConstantTimeUnit) format[i]).getLength());
                expression[i] = divideAndRemainder[0];
                remaining = divideAndRemainder[1];
            }
        }
        return expression;
    }

    /**
     * @return Format according to {@code self.format}.
     */
    @Override
    public String toString()
    {
        // Read self.format
        String[] parts = matchWithRegex(this.format, "(`[\\w\\d]+?`)|(.+?)");

        // Work using different pattern according to Fecha's type
        // If more type is add to Fecha, do not forget to change this part
        switch (this.value_type)
        {
            case period :
                return toStringPeriod(parts);
            case point :
            case now :
                return toStringPoint(parts);
            default :
                throw new IllegalStateException("No such data type: " + this.value_type);
        }
    }

    public String toString(String format, Object... args)
    {
        Formatter formatter = new Formatter();
        Object[] shifted = new Object[args.length];
        TimeUnit[] units = new TimeUnit[args.length];
        int[] difference = new int[args.length];
        for (int i = 0, j = 0; i < args.length; i++)
        {
            Object bit = args[i];
            if (bit instanceof TimeUnit)
            {
                difference[j] = i;
                units[j] = (TimeUnit) bit;
                j += 1;
            }
            else
            {
                shifted[i] = bit;
            }
        }
        BigInteger[] expression = express(units);
        for (int i = 0; difference[i] != 0; i++)
        {
            shifted[difference[i]] = expression[i];
        }
        formatter.format(format, shifted);
        return formatter.toString();
    }

    private String toStringPoint(String[] parts)
    {

        StringBuilder ret = new StringBuilder();
        int index = 0;

        // While the string is not end
        while (index < len(parts))
        {
            // If it is a symbol text
            if (parts[index].startsWith("`"))
            {
                // Use switch statement to translate each symbol to string
                switch (parts[index].substring(1, parts[index].length() - 1))
                {
                    case "YYYY" :
                        ret.append(this.value.mod(new BigInteger("1461")));
                        break;

                    default :
                        break;
                }
            }
            // If it is plain text
            else
            {
                ret.append(parts[index++]);
            }
        }

        return ret.toString();
    }

    /**
     * Use Geogorian calendar to convert timestamp to info.<br>
     * The order is: Year, Month, Day, Hour, Minute, Second
     *
     * @return Basic info of year, month, day and so on, saved in array
     */
    public int[] toStringPointGetNumbers()
    {
        // There are 1461 days in one year
        // you can count how many cycle are passed
        BigInteger year, day, hour, minute, second;
        BigInteger days = this.value.divide(new BigInteger("86400000"));
        print("days: " + days);
        BigInteger cycle = this.value.divide(new BigInteger("126230400000"));
        print("cycle: " + cycle);
        BigInteger remain = days.subtract(cycle.multiply(new BigInteger("1461")));
        print("remain: " + remain);

        // Get year
        // Use minus method, when smaller than 0, stop
        {
            BigInteger remain_temp = remain.add(BigInteger.ZERO);
            byte index = 0;
            while (remain_temp.compareTo(BigInteger.ZERO) > 0)
            {
                remain = remain_temp;
                remain_temp = remain_temp
                        .subtract(new BigInteger("365").add(index == 2 ? BigInteger.ONE : BigInteger.ZERO));
                index += 1;
            }

            year = cycle.multiply(new BigInteger("4")).add(new BigInteger("1970")).add(new BigInteger("" + index));
        }

        // Get month
        // Use minus method, when smaller than 0, stop
        print("Remain: " + remain);
        byte month = 1;
        {
            BigInteger remain_temp = remain.add(BigInteger.ZERO);
            while (remain_temp.compareTo(BigInteger.ZERO) > 0)
            {
                remain = remain_temp;
                switch (month)
                {
                    case 4 :
                    case 6 :
                    case 9 :
                    case 11 :
                        remain_temp = remain_temp.subtract(new BigInteger("30"));
                        break;
                    case 1 :
                    case 3 :
                    case 5 :
                    case 7 :
                    case 8 :
                    case 10 :
                    case 12 :
                        remain_temp = remain_temp.subtract(new BigInteger("31"));
                        break;
                    case 2 :
                        if (year.mod(new BigInteger("100")).compareTo(BigInteger.ZERO) == 0)
                        {
                            if (year.mod(new BigInteger("400")).compareTo(BigInteger.ZERO) == 0)
                            {
                                remain_temp = remain_temp.subtract(new BigInteger("30"));
                            }
                            else
                            {
                                remain_temp = remain_temp.subtract(new BigInteger("29"));
                            }
                        }
                        else
                        {
                            if (year.mod(new BigInteger("4")).compareTo(BigInteger.ZERO) == 0)
                            {
                                remain_temp = remain_temp.subtract(new BigInteger("30"));
                            }
                            else
                            {
                                remain_temp = remain_temp.subtract(new BigInteger("29"));
                            }
                        }
                        break;
                    default :
                        throw new IllegalStateException("No such month");
                }
                print(remain_temp);
                month += 1;
            }
            day = remain_temp;
        }

        return new int[]{year.intValue(), month, remain.intValue(), day.intValue()};
    }

    private String toStringPeriod(String[] parts)
    {
        return null;
    }


    /**
     * <p>
     * {@code type}は{@code Fecha}内部の{@code value}の解釈型(与元型ではない)です。Fechaは
     * </p>
     * <p>
     * Save the meaning of the value of Fecha. It can be a special point of time, or a period of time. If you assign it
     * as {@code now}, it will only mark it is present time, and not saving time in {@code value}.
     * </p>
     */
    enum type
    {
        point, period, now
    }

    enum prop
    {
        century, year, month, day, hour, minute, second, timezone
    }

    public static void main(String[] args)
    {
        Fecha fd = new Fecha(System.currentTimeMillis());
        System.out.println(Arrays.toString(CalendarSystems.GREGORIAN.expressFecha(fd.value, fd.zone)));
    }
}