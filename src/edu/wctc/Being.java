package edu.wctc;

public interface Being {
    /**Actually we could probably make this an abstract class since methods are same per subclasses**/
    void damageHealth(int damage);
    int getHealth();
    String getName();
}
