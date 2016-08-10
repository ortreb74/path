package bundle.ihm.data;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by ortrébuchant on 06/08/2016.
 */
public class Affine {

    Map<String, QualifiedNumber> components = new HashMap<String, QualifiedNumber>();
    List<QualifiedNumber> unknown = new ArrayList<QualifiedNumber>();

    String target;

    public void add(QualifiedNumber qualifiedNumber) {
        switch (qualifiedNumber.getId()) {
            case "x":
                components.put("x",qualifiedNumber); break;
            case "y": components.put("y",qualifiedNumber); break;
            case "a": components.put("a",qualifiedNumber); break;
            case "b": components.put("b",qualifiedNumber); break;
            default : unknown.add(qualifiedNumber);
        }

        if (components.size() == 3) setTarget();
    }

    private void setTarget() {
        if (!components.containsKey("a")) target = "a";
        if (!components.containsKey("b")) target = "b";
        if (!components.containsKey("x")) target = "x";
        if (!components.containsKey("y")) target = "y";
    }


    public boolean isCompleted() {
        return components.size()>=3;
    }

    public String[] getWords() {
        String[] result = new String[8];

        if (target.equals("b")) {
            result[0] = components.containsKey("b") ? components.get("b").getLastName() : "b";
            result[1] = calculateB();
        }

        if (target.equals("y")) {
            result[0] = components.containsKey("y") ? components.get("y").getLastName() : "y";
            result[1] = calculateY();
        }

        if (target.equals("x")) {
            result[0] = components.containsKey("x") ? components.get("x").getLastName() : "x";
            result[1] = calculateX();
        }

        if (target.equals("a")) {
            result[0] = components.containsKey("a") ? components.get("a").getLastName() : "a";
            result[1] = calculateA();
            result[2] = components.get("x").getLastName();
            result[3] = String.valueOf(components.get("x").getLastValue());
            result[4] = components.get("b").getLastName();
            result[5] = String.valueOf(components.get("b").getLastValue());
            result[6] = components.get("y").getLastName();
            result[7] = String.valueOf(components.get("y").getLastValue());
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
