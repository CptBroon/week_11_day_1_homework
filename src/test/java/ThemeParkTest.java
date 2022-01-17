import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;

    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;

    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;

    private Visitor youngVisitor;
    private Visitor shortTeenVisitor;
    private Visitor tallTeenVisitor;
    private Visitor adultVisitor;


    @Before
    public void before() {
//        Make theme park
        themePark = new ThemePark("Magic Kingdom");
//        Make attractions
        dodgems = new Dodgems("Dodgems", 5);
        park = new Park("Central Perk", 5);
        playground = new Playground("Mickey's Playground", 7);
        rollerCoaster = new RollerCoaster("Space Mountain", 9);
//        Make stalls
        candyflossStall = new CandyflossStall("Flossing is fun", "Dave", ParkingSpot.A1);
        iceCreamStall = new IceCreamStall("I Scream, You Scream, We all Scream for IceCream", "Goofy", ParkingSpot.A2);
        tobaccoStall = new TobaccoStall("Jasmine is SMOKIN hot", "Al Addin", ParkingSpot.B1 );
//        Add attractions and stalls to theme park list
        themePark.addAttOrStall(dodgems);
        themePark.addAttOrStall(park);
        themePark.addAttOrStall(playground);
        themePark.addAttOrStall(rollerCoaster);
        themePark.addAttOrStall(candyflossStall);
        themePark.addAttOrStall(iceCreamStall);
        themePark.addAttOrStall(tobaccoStall);
//        Make test visitors
        youngVisitor = new Visitor(8, 110, 20.50);
        shortTeenVisitor = new Visitor(13, 140, 15.80);
        tallTeenVisitor = new Visitor(14, 160, 18.10);
        adultVisitor = new Visitor(28, 190, 50.00);
    }

    @Test
    public void hasName() {
        assertEquals("Magic Kingdom", themePark.getName());
    }

    @Test
    public void hasAttractionList() {
        assertEquals(7, themePark.getAttAndStalls().size());
    }

    @Test
    public void canReturnReviewsHashMap() {
        assertEquals(HashMap.class, themePark.getReviews().getClass());
    }

    @Test
    public void canReturnAllAllowedAttractionsForYoungVisitor() {
        assertEquals(5, themePark.getAllAllowedFor(youngVisitor).size());
    }

    @Test
    public void canReturnAllAllowedAttractionsForShortTeen() {
        assertEquals(5, themePark.getAllAllowedFor(shortTeenVisitor).size());
    }

    @Test
    public void canReturnAllAllowedAttractionsForTallTeen() {
        assertEquals(6, themePark.getAllAllowedFor(tallTeenVisitor).size());
    }

    @Test
    public void canReturnAllAllowedAttractionsForAdult() {
        assertEquals(6, themePark.getAllAllowedFor(adultVisitor).size());
    }
}
