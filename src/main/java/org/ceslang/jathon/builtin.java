package org.ceslang.jathon;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.*;
import java.util.*;

/**
 * What is new? <br>
 * inted(String) can parse hex, bin, and oct (start with "0o", not "0") string now <br>
 * Now developing printc() function! Having colours in console! <br>
 * readParam() function family <br>
 * booled() now support string <br>
 * Making open() family
 */

@SuppressWarnings("unused")
public final class builtin
{
    public final String $version = "0.3.1.0";

    /**
     * This is the builtin file in Jathon. Do not try to initialize instance of this class.<br>
     * You can use this freely.
     */
    private builtin()
    {
    }


    // print() function family: Shorter name, print what you want.

    /**
     * An easy function for print data. Shorter than "System.out.println", easier to use (use comma to separate
     * variables, do not worry about data type).
     */
    public static void printx(Object... args)
    {
        if (args.length == 0)
        {
            System.out.println();
        }
        else if (args.length == 1 && !args[0].getClass().isArray())
        {
            System.out.print(args[0]);
        }
        else
        {
            StringBuilder r = new StringBuilder(Arrays.deepToString(args));
            // Delete the brackets of Arrays.deepToString() and print
            System.out.print(r.deleteCharAt(r.length() - 1).deleteCharAt(0));
        }
    }

    /**
     * <p>
     * Print a empty line to the console, and move cursor to the next line.
     * </p>
     *
     * @see builtin#print(Object...)
     * @since 1.8
     */
    public static void print()
    {
        System.out.println();
    }

    /**
     * <p>
     * Print each element and separate by comma, support array.
     * </p>
     *
     * @param args The things you want to print. Separated by comma when printing.
     * @see builtin#printx(Object...)
     * @since 1.8
     */
    public static void print(Object... args)
    {
        printx(args);
        print();
    }

    public static void print(IntList arg)
    {
        printx(arg);
        printx();
    }

    public static void printxf(String option_str, Object... object_str)
    {
        System.out.printf(option_str, object_str);
    }

    public static void printf(String option_str, Object... object_str)
    {
        System.out.printf(option_str + "\n", object_str);
    }

    /**
     * Set back to default fg/bg colour, it might clear your previous set colour!
     */
    public static void printcx()
    {
        printx("\033[0;39;49m");
    }

    /**
     * Set back to default fg/bg colour, and move to next line. <br />
     * it might clear your previous set colour!
     */
    public static void printc()
    {
        printcx();
        print();
    }

    /**
     * Use simple {@code option string} to configure the style of text.
     * <table>
     * <tbody>
     * <tr>
     * <th>Part</th>
     * <th>Meaning</th>
     * <th>Option</th>
     * </tr>
     * <tr>
     * <td>Colour String (6-digits)</td>
     * <td>The hex colour of the colour you want.</td>
     * <td>For example: 0xc0a247</td>
     * </tr>
     * <tr>
     * <td>Font Style</td>
     * <td>The style of font, like underline<br />
     * Some of them might not be supported</td>
     * <td>b: bold<br />
     * u: underline<br />
     * i: italic<br />
     * f: flashing</td>
     * </tr>
     * </tbody>
     * </table>
     */
    public static void printcx(String option_str, Object... arg)
    {
        int hex_colour;
        StringBuilder option = new StringBuilder("\033[");

        // Get Colour String
        if (option_str.startsWith("0x"))
        {
            hex_colour = inted(option_str.substring(0, 8));
            option_str = option_str.substring(8);
        }
        else
        {
            hex_colour = inted("0x" + option_str.substring(0, 6));
            option_str = option_str.substring(6);
        }

        // Print with colour
        int hex_b = hex_colour % 0x100;
        int hex_g_b = hex_colour % 0x10000;
        int hex_g = (hex_g_b - hex_b) / 0x100;
        int hex_r = (hex_colour % 0x1000000 - hex_g_b) / 0x10000;
        option.append("0;38;2;").append(hex_r).append(";").append(hex_g).append(";").append(hex_b).append(";");

        // Check if there are still options for printc
        if (option_str.length() > 0)
        {
            for (char c : option_str.toCharArray())
            {
                switch (c)
                {
                    case 'b' -> option.append("1;");
                    case 'i' -> option.append("3;");
                    case 'u' -> option.append("4;");
                    case 'f' -> option.append("5;");
                    default -> print("The argument you have inputted, '" + c + "' is wrong, or not supported");
                }
            }
            printx(option.toString());
        }

        option.deleteCharAt(option.length() - 1).append("m");
        printx(option.toString());
        printx(arg);
        printc();
    }

    public static void printc(String option_str, Object... arg)
    {
        printcx(option_str, arg);
        print();
    }


    public static void printc(int hex_r, int hex_g, int hex_b, Object... arg)
    {
        printSet(hex_r, hex_g, hex_b);
        printx(arg);
        printc();
    }

    public enum TextOpt
    {
        bold, italic, underlined, flashing
    }

    public static void printSet(int hex_colour)
    {
        int hex_b = hex_colour % 0x100;
        int hex_g_b = hex_colour % 0x10000;
        int hex_g = (hex_g_b - hex_b) / 0x100;
        int hex_r = (hex_colour % 0x1000000 - hex_g_b) / 0x10000;
        printSet(hex_r, hex_g, hex_b);
    }

    public static void printSet(int r, int g, int b)
    {
        printx("\033[0;38;2;" + r + ";" + g + ";" + b + "m");

    }

    public static void printSet(int hex_colour, TextOpt... options)
    {
        // TODO Not Finished
        printSet(hex_colour);
        StringBuilder option = new StringBuilder("\033[");
        for (TextOpt o : options)
        {
            switch (o)
            {
                case bold -> option.append("1;");
                case italic -> option.append("3;");
                case underlined -> option.append("4;");
                case flashing -> option.append("5;");
            }
        }
        option.deleteCharAt(option.length()).append("m");
        printx(option.toString());
    }


    // len() function: If you only want to get length, then we will give you its length

    /**
     * Return the length of the object you have inputted. Currently return string's length.
     * <p>
     * Note: because string is commonly used, it appears in the first
     *
     * @param s The string you want to get its length
     * @return Length of string
     */
    public static int len(String s)
    {
        return s.length();
    }

    public static int len(int i)
    {
        return inted(StrictMath.log10(i)) + 1;
    }

    public static int len(int[] arr)
    {
        return arr.length;
    }

    public static <U> int len(U[] a)
    {
        return a.length;
    }

    public static <U> int len(Collection<U> c)
    {
        return c.size();
    }

    public static int len(CharSequence cs)
    {
        return cs.length();
    }

    /**
     * Notice: Boundary is contained
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static String slice(String s, int start, int end)
    {
        // Change all negative number to positive, then pass to substring method
        int len_bound = len(s);
        start = start < 0 ? start + len_bound : start;
        end = end < 0 ? end + len_bound : end;
        if (start < end)
        {
            return s.substring(start, end + 1);
        }
        else if (start > end)
        {
            return reversed(s.substring(end, start + 1));
        }
        else
        {
            return "";
        }
    }


    // console.family: Make cmd command easier.

    public static void cls()
    {
        // Idea from https://stackoverflow.com/questions/2979383/java-clear-the-console
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception e)
        {
            print("Failed to clean the screen.");
        }
    }

    public static void exit()
    {
        System.exit(0);
    }

    public static void exit(int status)
    {
        System.exit(status);
    }

    public static String[] readOptionParam(String[] args)
    {
        ArrayList<String> ret_args = new ArrayList<>();
        for (String s : args)
        {
            // If it is "-o" or "--option"
            if (s.startsWith("-"))
            {
                ret_args.add(s);
            }
        }
        return ret_args.toArray(new String[0]);
    }

    public static String[] readObjectParams(String[] args)
    {

        ArrayList<String> ret_args = new ArrayList<>();
        for (String s : args)
        {
            if (!s.startsWith("-"))
            {
                ret_args.add(s);
            }
        }
        return ret_args.toArray(new String[0]);
    }

    // TODO Alternative for Option Param (like "-h", "-?", and "--help" is the same)
    // public static String[] readObjectParam(String[] args, int number_to_read, String... after)
    // {

    // }

    // TODO Strict ream param: only the obj param next to option param is accepted
    // Like this: --strict-mode I_can_be_read --separate I_cannot_be_read

    public static String[] readObjectParam(String[] args, String after, int number_to_read)
    {
        ArrayList<String> ret_args = new ArrayList<>();
        {
            boolean can_read = false;
            for (int i = 0; i < args.length && number_to_read > 0; i++)
            {
                // Get can_read status
                // If after is null, then read from the first one
                if (args[i].equals(after) || after == null)
                {
                    can_read = true;
                    continue;
                }

                // If can read
                if (can_read)
                {
                    ret_args.add(args[i]);
                    number_to_read -= 1;
                }
            }
        }
        return ret_args.toArray(new String[0]);
    }


    public static String deciFmt(double d)
    {
        return deciFmt(d, 4);
    }

    public static String deciFmt(double d, int scale)
    {
        BigDecimal x = new BigDecimal(d);
        x = x.setScale(scale, RoundingMode.HALF_DOWN);
        return x.toString();
    }


    public static int inted(String x)
    {
        if (x.startsWith("0x"))
        {
            return Integer.parseInt(x.strip().substring(2), 16);
        }
        else if (x.startsWith("0b"))
        {
            return Integer.parseInt(x.strip().substring(2), 2);
        }
        else if (x.startsWith("0o"))
        {
            return Integer.parseInt(x.strip().substring(2), 8);
        }
        else
        {
            return Integer.parseInt(x.strip());
        }
    }

    public static int inted(float x)
    {
        return (int) x;
    }

    public static int inted(double x)
    {
        return (int) x;
    }

    public static int inted(Number num)
    {
        return num.intValue();
    }

    public static int[] inted(String[] arg)
    {
        int[] ret = new int[arg.length];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = inted(arg[i]);
        }
        return ret;
    }

    public static double doubled(int x)
    {
        return x;
    }

    public static double[] doubled(String[] arg)
    {
        double[] ret = new double[arg.length];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = doubled(arg[i]);
        }
        return ret;
    }

    public static double doubled(String x)
    {
        return Double.parseDouble(x);
    }

    public static double doubled(Number num)
    {
        return num.doubleValue();
    }

    public static boolean booled(int x)
    {
        return x != 0;
    }

    public static boolean booled(double x)
    {
        return x != 0.0;
    }

    public static boolean booled(String x)
    {
        if (x.equalsIgnoreCase("true"))
        {
            return true;
        }
        if (x.equalsIgnoreCase("false"))
        {
            return false;
        }
        else
        {
            throw new IllegalArgumentException("Invalid string to change to boolean type");
        }
    }

    public static String str(long number)
    {
        return Long.toString(number);
    }

    public static String str(boolean bool)
    {
        return bool ? "true" : "false";
    }


    private static final Scanner scanner_s = new Scanner(System.in);

    public static String input()
    {
        return scanner_s.nextLine();
    }

    public static String input(String prompt)
    {
        printx(prompt);
        return input();
    }

    public static int inputOneInt()
    {
        return scanner_s.nextInt();
    }

    public static int inputOneInt(String prompt)
    {
        printx(prompt);
        return inputOneInt();
    }

    public static double inputOneDouble()
    {
        return scanner_s.nextDouble();
    }

    public static double inputOneDouble(String x)
    {
        printx(x);
        return inputOneInt();
    }

    public static int[] sorted(int[] x)
    {
        int[] t = Arrays.copyOf(x, x.length);
        Arrays.sort(t);
        return t;
    }

    public static int[] sorted(IntList x)
    {
        return sorted(x.toArray());
    }

    public static int reversed(int x)
    {
        return inted(reversed(Integer.toString(x)));
    }

    public static String reversed(String s)
    {
        StringBuilder b = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--)
        {
            b.append(c[i]);
        }
        return b.toString();
    }

    @SuppressWarnings("unchecked")
    public static <E> E reversed(E[] arr)
    {
        int i = arr.length;
        Object[] ret = new Object[i];
        for (E x : arr)
        {
            ret[i--] = x;
        }
        return (E) ret;
    }


    // Math function.

    private static final Random random = new Random();

    /**
     * Use system time to return a random number.<br>
     *
     * @return int from 0 to 100 (both edges are included)
     */
    public static int randint()
    {
        return randint(0, 100);
    }

    /**
     * Use system time to return a random number.<br>
     *
     * @param s The start number of random int
     * @param e The e number of random int
     * @return int from <i>s</i> to <i>e</i> (both edges are included)
     */
    public static int randint(int s, int e)
    {
        return random.nextInt(e - s + 1) + s;
    }


    public static int abs(int x)
    {
        return x >= 0 ? x : -x;
    }

    /**
     * @param x The value you want to get absolute value
     * @return The absolute data of the input number
     */
    public static <numeric extends Number> double abs(numeric x)
    {
        return x.doubleValue() >= 0 ? x.doubleValue() : -x.doubleValue();
    }

    /**
     * @param args The data you want to pick.
     * @return The max data from input
     */
    @SafeVarargs
    public static <cmpable extends Number> cmpable max(cmpable... args)
    {
        cmpable r = args[0];
        for (cmpable x : args)
        {
            r = (x.doubleValue() > r.doubleValue() ? x : r);
        }
        return r;
    }

    @SafeVarargs
    public static <cmpable extends Number> cmpable max(cmpable[]... args)
    {
        cmpable r = args[0][0];
        for (cmpable[] c : args)
        {
            r = max(c);
        }
        return r;
    }

    /**
     * @param args The data you want to pick.
     * @return The min data from input
     */
    @SafeVarargs
    public static <cmpable extends Number> cmpable min(cmpable... args)
    {
        cmpable r = args[0];
        for (cmpable x : args)
        {
            r = (x.doubleValue() < r.doubleValue() ? x : r);
        }
        return r;
    }

    @SafeVarargs
    public static <cmpable extends Number> cmpable min(cmpable[]... args)
    {
        cmpable r = args[0][0];
        for (cmpable[] c : args)
        {
            r = min(c);
        }
        return r;
    }

    public static double pow(double a, double b)
    {
        return StrictMath.pow(a, b);
    }

    public static double sqrt(double a)
    {
        return StrictMath.sqrt(a);
    }

    public static double ln(double x)
    {
        return Math.log(x);
    }

    public static String hex(int x)
    {
        return "0x" + Integer.toHexString(x);
    }

    public static String bin(int x)
    {
        return "0b" + Integer.toBinaryString(x);
    }

    public static String oct(int x)
    {
        return "0o" + Integer.toOctalString(x);
    }


    // Start File Processing parts

    public static Scanner openURL(String url)
    {
        try
        {
            URL url_obj = new URL(url);
            return new Scanner(url_obj.openStream());
        }
        catch (MalformedURLException e)
        {
            printc("e60033b", "[!ERR] You have provided a wrong URL");
            printc("e60033b", "\tNo such URL: " + url);
            e.printStackTrace();
        }
        catch (ConnectException e)
        {
            printc("e60033b", "[!ERR] Failed to connect.");
            printc("e60033b", "\tTarget URL: " + url);
            e.printStackTrace();
        }
        catch (IOException e)
        {
            printc("e60033b", "[!ERR] You have encountered an IO Exception");
            e.printStackTrace();
        }

        return null;
    }


    public static String[] matchWithRegex(String origin, String regex)
    {
        ArrayList<String> ret = new ArrayList<>();

        java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(origin);
        while (m.find())
        {
            ret.add(m.group());
        }

        return (String[]) ret.toArray(new String[0]);
    }


    // End File Processing parts


    // // Start Error Processing parts

    // public static void printErr(ExceptionReason r)
    // {
    // // TODO need param (ErrorReason r)
    // }

    // public static void printErrDetail()
    // {
    // // TODO need param (ErrorReason r, ErrorExample t)
    // }
}