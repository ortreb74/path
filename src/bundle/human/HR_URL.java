package bundle.human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by drncl on 02/01/2017.
 */

public class HR_URL {

    private String[] words;
    private Map<String,String> map = new HashMap<String,String>();

    public HR_URL(String parameter) {
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

            words = parameter.split ("/");

        }  catch (MalformedURLException e) {
            System.out.println("Impossible de parser l'URL");
            words = parameter.split ("/");
        }
    }

    public String[] getWords() {
        return words;
    }

}
