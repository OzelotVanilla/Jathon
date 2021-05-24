package org.ceslang.jathon.time;

import org.ceslang.jathon.time.calender.CalendarSystem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.math.BigInteger;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Formatter;

import static org.ceslang.jathon.builtin.str;
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
    /**
     * <p>
     * First update of {@code Fecha}.
     * </p>
     */
    public final String $version = "0.2.6.0";
    public final String $default_format = "`MM`-`DD`-`YYYY` `hh24`:`mm`:`ss`";
    private type value_type;
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
    private Timezone zone;
    /**
     * <p>
     * {@code value}は{@code Fecha}の時間の素値です。{@code type}が{@code point}のときはtimestamp， {@code period}のときは経過時間です。
     * </p>
     *
     * <p>
     * Save the value of time. It can mean point of time, or a period of time according to {@code type}.
     * </p>
     */
    private BigInteger value;
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
    private CalendarSystem calendarSystem;

    public Fecha()
    {
        // TODO Empty constructor to be filled
    }

    public Fecha(Date date)
    {
        // TODO Empty constructor to be filled
        this(type.point, date.getTime());
    }


    public Fecha(java.sql.Date date)
    {
        this(type.point, date.getTime());
    }

    public Fecha(long timestamp)
    {
        // TODO Empty constructor to be filled
        this(type.point, timestamp);
    }

    public Fecha(type t, long value)
    {
        // TODO Empty constructor to be filled
    }

    public Fecha(ZoneId zi, long value)
    {
        // TODO Empty constructor to be filled
    }

    public Fecha(type t, ZoneOffset zi, BigInteger value, String format)
    {
        this.value_type = t;
        this.zone = (value_type == type.point || value_type == type.now) ? new Timezone(zi) : null;
        this.value = t == type.now ? null : value;
        this.format = format;
    }

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


    //    @Override
    //    public String toString()
    //    {
    //        // TODO Write it after you have designed format
    //    }

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
     * @param fmt 置き換えたい新しい
     */
    public void setFormat(String fmt)
    {
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
        this.calendarSystem = calendarSystem;
    }

    public void setValue(long value)
    {
        this.setValue(new BigInteger(str(value)));
    }

    public void setValue(BigInteger value)
    {
        this.value = value;
    }

    public BigInteger[] express(TimeUnit... format)
    {
        BigInteger remaining;
        BigInteger[] expression = new BigInteger[format.length];
        BigInteger[] partExpression;
        TimeUnit[] structure;
        switch (this.value_type)
        {
            case now:
                partExpression = calendarSystem.expressFecha(BigInteger.valueOf(System.currentTimeMillis()), zone);
                remaining = partExpression[0];
                structure = calendarSystem.getSupportedTimeUnit();
                break;
            case period:
                remaining = value;
                partExpression = null;
                structure = null;
                break;
            case point:
                partExpression = calendarSystem.expressFecha(value, zone);
                remaining = partExpression[0];
                structure = calendarSystem.getSupportedTimeUnit();
                break;
            default:
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
            } else
            {
                BigInteger[] divideAndRemainder = remaining.divideAndRemainder(((ConstantTimeUnit) format[i]).getLength());
                expression[i] = divideAndRemainder[0];
                remaining = divideAndRemainder[1];
            }
        }
        return expression;
    }

    @Override
    public String toString()
    {
        return "Fecha{" + "value_type=" + value_type + ", zone=" + zone + ", value=" + value + '}';
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
                j++;
            } else
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

    /**
     * <p>
     * {@code type}は{@code Fecha}内部の{@code value}の解釈型(与元型ではない)です。Fechaは
     * </p>
     * <p>
     * Save the meaning of the value of Fecha. It can be a special point of time, or a period of time. If you assign it as
     * {@code now}, it will only mark it is present time, and not saving time in {@code value}.
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

}