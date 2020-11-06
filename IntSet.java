/**
 * An abstract class that inclues an add, contains, union and toString method.  
 *
 * @author (Lauren)
 * @version (01/11/20)
 */
abstract class IntSet
{
    public int value;
    //value in the singleton set
    
    public abstract IntSet add(int x);
    
    public abstract boolean contains(int x);
    
    public abstract IntSet union(IntSet other);
    
    public abstract String toString();
}

