package ch17;

import java.lang.reflect.Method;
import java.util.Arrays;
import static java.lang.System.*;

/**
 * Project: ch17
 * Date:    4/25/2018
 *
 * @author Jay Morales
 */

public class ex173
{
    /**
     * The class main method is the entry point of an executable program,
     * it is where the program control starts and ends.
     * @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        try
        {
            for (String arg : args)
            {
                Class x = Class.forName(arg);
                getm(x);
                out.println();
                setm(x);
                out.println();
            }
        } catch (ClassNotFoundException e)
        {
            err.println(e.getMessage());
            exit(1);
        }
    }

    /**
     * This method prints all the method(s) of the cls object that start with get,
     * is not a void return, and hast no argument(s).
     * @param cls Class object to be filtered.
     */
    private static void getm(Class cls)
    {
        /* get all methods for the cls Class, loop through methods and
        print all methods that are get methods - start with get, is
        not a void return, and has no arguments
        */
        System.out.println("Listing get methods for " + cls);
        Method[] ma = cls.getMethods();
        Arrays.stream(ma)
                .filter(e -> e.getName().startsWith("get"))
                .filter(e -> !e.getReturnType().equals(void.class))
                .filter(e -> e.getParameterTypes().length == 0)
                .forEach(out::println);
    }

    /**
     * This method prints all the method(s) of the cls object that start with set,
     * is a void return, and has one argument.
     * @param cls
     */
    private static void setm(Class cls)
    {
        /* get all methods for the cls Class, loop through methods and
        print all methods that are set methods - start with set, is
        a void return, and has one argument
        */
        System.out.println("Listing set methods for " + cls);
        Method[] ma = cls.getMethods();
        Arrays.stream(ma)
                .filter(e -> e.getName().startsWith("set"))
                .filter(e -> e.getReturnType().equals(void.class))
                .filter(e -> e.getParameterTypes().length == 1)
                .forEach(out::println);
    }
}
