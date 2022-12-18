package Obchod;

/**interface pre návrhový vzor Visitor, ktorý implementuje trieda Keramika*/

public interface Visitable {
    public double accept(ObjednavkaVisitor visitor);
}
