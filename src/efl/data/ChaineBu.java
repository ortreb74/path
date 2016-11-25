package efl.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ext-pdonzel on 25/11/2016.
 */
public class ChaineBu {

    private List<String> steps = new ArrayList<String>();

    public ChaineBu() {
        steps.add("bu");
        steps.add("linkbu");
        steps.add("livraison");
        steps.add("uaur/sgm");
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

}
