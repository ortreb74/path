package bundle.ihm.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ortrébuchant on 18/09/2016.
 */
public class Affine {

    Map<String, String> h1 = new HashMap<String, String>();
    Map<String, String> h2 = new HashMap<String, String>();

    public void set(String id, String name, String value) {
        h1.put(name, value);
        h2.put(id, value);
    }

    public void set(String id, String name, float value) {
        h1.put(name, String.valueOf(value));
        h2.put(id, String.valueOf(value));
    }


    public Map<String, String> get() {
        return h2;
    }

}
