import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private String name;
    private ArrayList<IReviewed> attAndStalls;

    public ThemePark(String name) {
        this.name = name;
        this.attAndStalls = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<IReviewed> getAttAndStalls() {
        return attAndStalls;
    }

    public void addAttOrStall(IReviewed attOrStall) {
        attAndStalls.add(attOrStall);
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.incrementVisitCount();
        visitor.visitAttraction(attraction);
    }

    public HashMap<String, Integer> getReviews() {
        HashMap<String, Integer> allReviews = new HashMap<>();
        for (IReviewed attraction : getAttAndStalls()) {
            allReviews.put(attraction.getName(), attraction.getRating());
        }
        return allReviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allAllowed = new ArrayList<>();
        for (IReviewed attraction : getAttAndStalls()) {
            if (attraction instanceof ISecurity) {
                if (((ISecurity) attraction).isAllowedTo(visitor) == true) {
                    allAllowed.add(attraction);
                };
            }
            else {
                allAllowed.add(attraction);
            }
        }
        return allAllowed;
    }
}
