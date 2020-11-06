/**
 * A class that creates a singleton set. 
 *
 * @author (Lauren)
 * @version (01/11/20)
 */
public class Singleton extends IntSet
   {
   private static IntSet[] memorise = new IntSet[8]; 
   //initialise an IntSet array to store 0-7
   /**
    * Constructor
    * @param n is the integer in the singleton set
    */
   public Singleton(int n)
   {
       this.value = n;
       if (n<8 && memorise[n] == null) {
             memorise[n] = this;
       }
   }
   /**
    * Smart constructor
    * @param n is the integer to be in the singleton set
    * @return a singleton set with the value n
    */
   public static IntSet singleton(int n){
       
       if(n<8){
          if (memorise[n] == null){
              memorise[n] = new Singleton(n);
          }
           return memorise[n];
       }
       return new Singleton(n);
   }   
   /**
    * Method to add an integer to a singleton set 
    * @param x 
    * @return a tree set with the value n
    */
   public IntSet add(int x){
       if (singleton(value).contains(x)){
           return singleton(value);
       }
       return TreeSet.combine(value, x);
   }
    /**
    * Method to see if an integer is in the singleton set 
    * @param x, the value to check 
    * @return true if x is in the set, otherwise false 
    */
   public boolean contains(int x) {
       if (x==value){
           return true;
       }
       return false;  
   }   
      /**
    * Method to use union to combine 2 sets
    * @param other is the set to do union on
    * @return a tree set of singleton and other or a singleton if other was an empty set
    */
   public IntSet union(IntSet other){
       // other string is empty - return Singleton
       if (other instanceof EmptySet){
          return new Singleton(value);
       }
       // other string is Singleton (same value handled in "add" method)
       else if (other instanceof Singleton){
               return this.add(other.value);
       }
       //other string is a TreeSet  
       return other.add(value);
   }
    /**
    * method to return the singleton in set format  
    * @return a string {x} where x is an integer 
    */
   public String toString() {
       return "{"+ value + "}";  
   }
}