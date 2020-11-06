/**
 * A class that creates an empty set. 
 *
 * @author (Lauren)
 * @version (01/11/20)
 */
public class EmptySet extends IntSet
   {
    public static IntSet empty = new EmptySet();
    //initialise an empty set 
    private EmptySet()
    {
     
    }
    /**
     * @return an empty set
     */
    public static IntSet emptySet(){
       return empty;
    }
    
    /**
     * @param x, an integer to be added to the empty set 
     * @return a singleton set of x
     */
    public IntSet add(int x){
      return Singleton.singleton(x);
    }
    
        /**
     * @param x, an integer to be added to the empty set 
     * @return false as the set is empty
     */
    public boolean contains(int x) {
      return false;  
      //always returns false
    }   
    
        /**
     * @param other, an IntSet to be combined with the set
     * @return a singleton set or tree set  of other
     */
    public IntSet union(IntSet other) {
      return other;  
      //returns a tree or singleton set
    }
    
    /**
     * @return a string of {} to signify an empty set
     */
    public String toString() {
      return "{}";  
      //shows an empty set
    }
    
}