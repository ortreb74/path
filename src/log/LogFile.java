package log;

import home.file.HomeUri;

import java.net.URISyntaxException;

/**
 * Created by drncl on 15/05/2017.
 */

public class LogFile {

    private HomeUri uri;

    /*
    private Log log;
    private Context context;
    private Program program;
    private Parameters parameters;
    */

    public LogFile(String filePath) {
        try {
            uri = new HomeUri(filePath);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        //XMLStreamWriter xsw =
    }

}
