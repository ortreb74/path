package home.file;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by drncl on 15/05/2017.
 */
public class HomeFile {

    File file;

    public HomeFile(URL url) throws URISyntaxException {
        file = new File(url.toURI());
    }

    public HomeFile(String parameter) {
        file = new File(parameter);
    }
}
