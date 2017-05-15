package home.file;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by drncl on 02/01/2017.
 */

public class HomeUri {

    private String[] words;
    private Map<String,String> map = new HashMap<String,String>();

    HomeFile homeFile;

    public HomeUri(String parameter) throws URISyntaxException {
        try {
            URL url = new URL(parameter);

            map.put("authority", url.getAuthority());

            // cela lève une IOException donc ce doit être le contenu de l'URL
            // map.put("content", url.getContent());
            map.put("default port", String.valueOf(url.getDefaultPort()));

            map.put("file", url.getFile());
            map.put("host", url.getHost());
            map.put("path", url.getPath());
            map.put("port", String.valueOf(url.getPort()));
            map.put("protocol", url.getProtocol());

            map.put("query", url.getQuery());
            map.put("ref/anchor", url.getRef()); // Gets the anchor (also known as the "reference") of this URL.

            map.put("user", url.getUserInfo());

            for (Map.Entry<String,String> e : map.entrySet()) {
                System.out.println (e.getKey() + " : " + e.getValue());
            }

            homeFile = new HomeFile(url);

            words = parameter.split ("/");

        }  catch (MalformedURLException e) {
            System.out.println("Impossible de parser l'URL");
            words = parameter.split ("/");

            homeFile = new HomeFile(parameter);
        }
    }

    public String[] getWords() {
        return words;
    }

}
