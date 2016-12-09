package context;

import java.io.File;

/**
 * Created by ext-pdonzel on 09/12/2016.
 */
public class FileAddress {

    public enum OS {LOCAL, SERVER};

    private OS executionContext;

    public FileAddress() {
        File a = new File("c:");

        executionContext = a.canRead() ? OS.LOCAL : OS.SERVER;
    }

    public String interpretAddress(String address) {
        // il faut commencer par interpréter le séparateur
        String separator = address.contains("\\") ? "\\" : "/";

        OS adressContext = (address.contains("\\") || address.contains(":")) ? OS.LOCAL : OS.SERVER;

        if (adressContext == executionContext) return address;

        if (address.contains("\\")) address.replace("\\", "/");

        switch (executionContext) {
            case LOCAL:
                return "i:/liens/" + address;
            case SERVER:
                if (address.contains("liens")) return address.replace("i:/liens/", "");

                return address.replace("i:/", "/u/ext-pdonzel");
        }

        // pouur éviter une erreur de compilation
        return address;
    }

}
