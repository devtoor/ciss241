package ch13.ex1;

import java.io.File;
import java.util.Date;
import java.util.Scanner;
import static java.lang.System.*;

/**
 * Project: ch13.ex1
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex131
{
    public void start()
    {
        Scanner console = new Scanner(System.in);
        out.print("Enter filename and extension: ");
        String filename = console.nextLine();
        console.close();

        File file = new File(filename);
        if(file.exists())
        {
            // Show name
            out.println("========== " + file.getName() + " ==========");

            // Show parent directory
            String parent = file.getParent();
            if (parent != null)
                out.println("Parent directory: " + parent);
            else
                out.println("Parent directory: root");

            // Show absolute path
            out.println("Absolute path: " + file.getAbsolutePath());

            // Show file size
            out.printf("File size: %,d bytes\n", getSize(file));

            // Show date and time last modified
            out.print("Last modified: " + new Date(file.lastModified()));
        }
        else
        {
            err.println("File doesn't exist");
            exit(1);
        }
    }

    /**
     * Returns the size of the file or directory denoted by the pathname.
     * @param root Abstract pathname.
     * @return The length in bytes of file or directory.
     */
    private long getSize(File root)
    {
        if (root.isFile())
            return root.length();
        else
        {
            File[] files = root.listFiles();
            long size = 0;

            if (files != null)
            {
                for (File file : files)
                    size += getSize(file);
            }
            return size;
        }
    }

    public static void main(String[] args)
    {
        new ex131().start();
    }
}
