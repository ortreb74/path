package bundle.ihm.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ortrébuchant on 06/08/2016.
 */

public class QualifiedNumber {

    private List<String> names = new ArrayList<String>();
    private List<Integer> figures = new ArrayList<Integer>();

    public void add(String word) {
        Integer figure = null;

        try {
            figure = Integer.parseInt(word);
        } catch (NumberFormatException e) {}

        if (figure == null) names.add(word); else figures.add(figure);
    }

    public boolean isCompleted() {
        return (names.size() != 0) && (figures.size() != 0);
    }

    public String[] getArray() {
        // TODO : cette méthode ne devrait pas être appelée si le QualifiedNumber n'est pas null
        if (!isCompleted()) return null;

        String[] result = new String[2];
        result[0] = getLastName();
        result[1] = String.valueOf(getLastValue());

        return result;
    }

    public String getId() {
        if (names.contains("x")) return "x";
        if (names.contains("y")) return "y";
        if (names.contains("a")) return "a";
        if (names.contains("b")) return "b";
        return null;
    }

    public String getLastName() {
        return names.get(names.size()-1);
    }

    public Integer getLastValue() {
        return figures.get(figures.size()-1);
    }
}
