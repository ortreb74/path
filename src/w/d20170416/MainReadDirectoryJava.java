package w.d20170416;

import java.io.File;

/**
 * Created by drncl on 16/04/2017.
 */
public class MainReadDirectoryJava {

    // read directory java
    // http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder

    // final File folder

    public static void main(String args[]) {
        String rootDirectoryName;

        rootDirectoryName = (args.length == 0) ? "." : args[0] ;

        File folder = new File(rootDirectoryName);

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                //listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

}
