package ch18;

import java.util.*;
import static java.lang.System.*;

/**
 * Project: ch18
 * Date:    5/5/2018
 *
 * @author Jay Morales
 */


public class ex185
{
    private TreeSet<movie18> mList;
    private Scanner scanner;

    /**
     * Constructor
     */
    public ex185()
    {
        this.mList = new TreeSet<>();
        scanner = new Scanner(in);
    }

    /**
     * Looping mechanism
     */
    private void start()
    {
        String input;
        do
        {
            showMenu();
            input = scanner.nextLine();
            switch (input)
            {
                case "1": addMovie();
                    break;
                case "2": peekFirst();
                    break;
                case "3": watchFirst();
                    break;
                case "4": peekLast();
                    break;
                case "5": watchLast();
                    break;
                case "6": showMovies();
                    break;
                case "-1": out.println("Shutting down . . .");
                    break;
                default:
                    out.print("Invalid input: Press any key to continue . . . ");
                    scanner.nextLine();
            }
        }
        while (!input.equals("-1"));
    }

    /**
     * Show detail and menu
     */
    private void showMenu()
    {
        clear();
        out.println("There are " + mList.size() + " movies in TreeSet");
        out.println();
        out.println("Enter 1 to add movie to TreeSet");
        out.println("Enter 2 to see what next movie on TreeSet is");
        out.println("Enter 3 to watch next movie on TreeSet");
        out.println("Enter 4 to see what last movie on TreeSet");
        out.println("Enter 5 to watch last movie on TreeSet");
        out.println("Enter 6 to see TreeSet of movies");
        out.println();
        out.print("Enter pick (-1 to end):  ");
    }

    /**
     * Add movie to the list
     */
    private void addMovie()
    {
        String name;
        int year;

        clear();
        out.print("Enter movie's name: ");
        name = scanner.nextLine();

        while (true)
        {
            try
            {
                out.print("Enter movie's year: ");
                year = scanner.nextInt();
                scanner.nextLine();
                break;
            }
            catch (InputMismatchException e)
            {
                scanner.nextLine();
                out.println("Invalid year! Try again.");
            }
        }

        if (!mList.add(new movie18(name, year)))
        {
            out.println("The movie you are trying to add is already in the TreeSet.");
            pressAnyKey();
        }
    }

    /**
     * Peak the next movie
     */
    private void peekFirst()
    {
        clear();
        if (mList.isEmpty())
        {
            out.println("TreeSet is Empty.");
            pressAnyKey();
        }
        else
        {
            out.println("Next movie: " + mList.first());
            pressAnyKey();
        }
    }

    /**
     * Watch the next movie
     */
    private void watchFirst()
    {
        watch(mList.pollFirst());
    }

    /**
     * Peek the last movie
     */
    private void peekLast()
    {
        clear();
        if (mList.isEmpty())
        {
            out.println("TreeSet is Empty.");
            pressAnyKey();
        }
        else
        {
            out.println("Last movie: " + mList.last());
            pressAnyKey();
        }
    }

    /**
     * Watch the last movie
     */
    private void watchLast()
    {
        watch(mList.pollLast());
    }

    /**
     * Show list of movies
     */
    private void showMovies()
    {
        clear();
        if (mList.isEmpty())
        {
            out.println("TreeSet is Empty.");
            pressAnyKey();
        }
        else
        {
            Iterator<movie18> iterator = mList.iterator();
            while (iterator.hasNext())
            {
                out.println(iterator.next());
            }
            pressAnyKey();
        }
    }

    /**
     * To show what movie the user picked to watch
     * @param movie movie to be watch
     */
    private void watch(movie18 movie)
    {
        clear();
        if (Objects.isNull(movie))
        {
            out.println("TreeSet is Empty.");
            pressAnyKey();
        }
        else
        {
            out.println("Watching: " + movie);
            pressAnyKey();
        }
    }

    /**
     * Clear console area
     */
    private void clear()
    {
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }

    /**
     * To ask the user to confirm result
     */
    private void pressAnyKey()
    {
        out.print("\nPress any key to continue . . . ");
        scanner.nextLine();
    }

    /**
     * The class main method is the entry point of an executable program,
     * it is where the program control starts and ends.
     * @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        new ex185()
                .start();
    }
}
