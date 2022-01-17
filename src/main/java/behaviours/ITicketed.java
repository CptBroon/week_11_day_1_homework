package behaviours;

import people.Visitor;

public interface ITicketed {

    public double defaultPrice();
    double priceFor(Visitor visitor);
}
