package pgm.mementoLocation;

import context.FileAddress;

import java.io.File;

/**
 * Created by ext-pdonzel on 09/12/2016.
 */
public class MementoLocation {

    //public static void main(String[] args)

    static public void main(String[] args) {
        File a = new File("/e3/mementos/mte/mte_fus.sgm");
        System.out.println(a.canRead());

        a = new File("/i:/liens/e3/mementos/mte/mte_fus.sgm");

        System.out.println(a.canRead());

        FileAddress n = new FileAddress();

        String f = "/e3/mementos/mte/mte_fus.sgm";
        String g = n.interpretAddress(f);
        a = new File(g);
        System.out.println(a.canRead());



    }
}
