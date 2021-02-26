package com.ryanmcvicker12;
//found and edited code from : https://github.com/mkyong/core-java/blob/master/java-basic/src/main/java/com/mkyong/system/OSValidator.java
import java.io.*;
import java.util.*;

public class OSValidator {

    private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
    public static boolean IS_MAC = (OS.indexOf("mac") >= 0);
    public static boolean IS_UNIX = (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    public static boolean IS_SOLARIS = (OS.indexOf("sunos") >= 0);

    //should be called in Garble.java

    public static void ClearScreen() {

        System.out.println("os.name: " + OS);
        try{
            if (IS_WINDOWS) {
        
                // clear the console
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            } else if (IS_MAC) {
                System.out.println("NO SOLUTION FOR MAC AT THE MOMENT.");
            } else if (IS_UNIX) {

                /*
                 *
                 * Found this method of clearing the console from : https://stackoverflow.com/questions/4888362/commands-in-java-to-clear-the-screen
                 * The persons code i found and edited was : @java.is.for.desktop
                 *lines 36-58
                 *
                 */
                char ESC = 27;

                Console c = System.console();
                if (c == null) {
                    System.err.println("no console");
                    System.exit(1);
                }

                // clear screen only the first time
                c.writer().print(ESC + "[2J");
                c.flush();
                //Thread.sleep(200);

                for (int i = 0; i < 100; ++i) {
                        // reposition the cursor to 1|1
                        c.writer().print(ESC + "[1;1H");
                        c.flush();
                        c.flush();
                        //Thread.sleep(200);
                    }
                } else if (IS_SOLARIS) {
                    System.out.println("NO SOLUTION FOR SOLARIS YET.");
                } else {
                    System.out.println("Your OS is not supported yet");
                    System.exit(0);
                }
        }catch (final Exception e)
        {
            System.exit(0);
        }
    }

}
