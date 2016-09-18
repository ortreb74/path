package bundle.ihm.data;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by ortrébuchant on 06/08/2016.
 */
public class TypedAffine {

    Map<String, QualifiedNumber> components = new HashMap<String, QualifiedNumber>();
    List<QualifiedNumber> unknown = new ArrayList<QualifiedNumber>();

    Map<String,Integer> position = new HashMap<String,Integer>();
    String target;

    public void add(QualifiedNumber qualifiedNumber) {
        String id = qualifiedNumber.getId();

        switch (id) {
            case "x": components.put("x",qualifiedNumber); break;
            case "y": components.put("y",qualifiedNumber); break;
            case "a": components.put("a",qualifiedNumber); break;
            case "b": components.put("b",qualifiedNumber); break;
            // définition de unknown :
            default : unknown.add(qualifiedNumber);
        }

        if (components.size() == 3) {
            if (!components.containsKey("a")) target = "a";
            if (!components.containsKey("b")) target = "b";
            if (!components.containsKey("x")) target = "x";
            if (!components.containsKey("y")) target = "y";
        }

        if (components.size() <= 3) {
            position.put(id, components.size());
        }  else {
            String[] ids = {"a","b","x","y"};
            Integer pivot = position.get(id);
            // performing the circle
            for (String idi : ids) if (position.get(idi) > pivot) position.put(idi, position.get(idi) - 1);
            position.put(id, 4);
            // retrieving the first
            for (String idi : ids) if (position.get(idi) == 1) target = idi;
        }
    }


    public boolean isCompleted() {
        return components.size()>=3;
    }

    public Affine getAffine() {
        Affine result = new Affine();

        if (target.equals("b")) {
            //result[0] = components.containsKey("b") ? components.get("b").getLastName() : "b";
            //result[1] = calculateB();
        }

        if (target.equals("y")) {
            //result[0] = components.containsKey("y") ? components.get("y").getLastName() : "y";
            //result[1] = calculateY();
        }

        if (target.equals("x")) {
            //result[0] = components.containsKey("x") ? components.get("x").getLastName() : "x";
            //result[1] = calculateX();
        }

        if (target.equals("a")) {
            result.set("a",components.containsKey("a") ? components.get("a").getLastName() : "a",calculateA() );
            result.set("x",components.containsKey("x") ? components.get("x").getLastName() : "x", String.valueOf(components.get("x").getLastValue()));
            result.set("b",components.containsKey("b") ? components.get("b").getLastName() : "b",components.get("b").getLastValue() );
            result.set("y",components.containsKey("y") ? components.get("y").getLastName() : "y",components.get("y").getLastValue() );
        }

        return result;
    }

    public String calculateB() {
        return "";
    }

    public String calculateY() {
        return "";
    }

    public String calculateX() {
        return "";
    }

    public String calculateA() {
        Float b = components.get("b").getLastValue().floatValue();;
        Float y = components.get("y").getLastValue().floatValue();
        Float x = components.get("x").getLastValue().floatValue();

        return String.valueOf((int) ((y - b) / x + 0.5));
    }
}
