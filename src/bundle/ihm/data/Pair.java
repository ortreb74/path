package bundle.ihm.data;

/**
 * Created by drncl on 30/12/2016.
 */
public class Pair {

    Integer firstInput = null;
    Integer secondInput = null;

    public void add(String word) {
        Integer figure = null;

        try {
            figure = Integer.parseInt(word);
        } catch (NumberFormatException e) {}

        if (figure != null) {
            if (secondInput != null) {
                firstInput = secondInput;
                secondInput = figure;
            } else
            if (firstInput != null) {
                secondInput = figure;
            } else firstInput = figure;
        }
    }

    public boolean isCompleted() {
        return secondInput != null;
    }

    public double getQ() {
        return isCompleted() ? (double) firstInput / secondInput : 0;
    }
}
