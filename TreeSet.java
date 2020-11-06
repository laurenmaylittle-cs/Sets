/**
 * Write a description of class SingletonSet here.
 *
 * @author (Lauren Little)
 * @version (03/11/20)
 /**
 * A class that creates a tree set. 
 *
 * @author (Lauren)
 * @version (01/11/20)
 */
public class TreeSet extends IntSet
   {
      public IntSet leftBranch;
      //left branch of the tree
      public IntSet rightBranch;
      //left branch of the tree
      public static int countLB =1;
      //count for how many left branches have been traversed
      public static int countRB =1;
      //count for how many right branches have been traversed
      public static boolean isTree=false;
      //to see if the branch is a tree
      public static boolean isOdd =false;
      //if the singleton comes from a right or left branch
      
      /**
      * Constructor
      * @param left, is the left branch
      * @param right, is the right branch
      **/ 
      public TreeSet(IntSet left, IntSet right)
      {
         this.leftBranch = left;
         this.rightBranch = right;
      }
      
      /**
      * Smart constructor
      * @param left, is the left branch
      * @param right, is the right branch
      * @return a new treeset with the left and right branch
      **/ 
      public static IntSet tree(IntSet left, IntSet right) {     
         return new TreeSet(left,right);   
      }
      
      /**
      * Method to add an integer to a treeSet
      * @param x, is the integer to be added to the tree
      * @return the new tree, with x in it
      **/ 
      public IntSet add(int x){
          if (isEven(x)){
           leftBranch = leftBranch.add(x/2);
           return this;
         }
         else {
           rightBranch = rightBranch.add(x/2);
           return this;
         }    
      }
     
      /**
      * Method to see if a number is even
      * @param x, is the integer to be checked
      * @return true if its even, false if its odd
      **/ 
      public static boolean isEven(int x){
         return (x % 2 == 0);
      }
    
      /**
      * Method to see if a treeSet contains an integer
      * @param x, is the integer to be checked
      * @return true if the tree contains x, false if x its not in the tree.
      **/ 
      public boolean contains(int x) {
         if (isEven(x)){
            return leftBranch.contains(x/2);
            }
            else {
           return rightBranch.contains(x/2);
         }  
      }
   
      /**
      * Method to combine two integers to make a treeSet
      * @param x, is the integer to be added to the tree
      * @param y, is the integer to be added to the tree
      * @return the new tree, with x and y in it
      **/ 
      public static IntSet combine(int x, int y){
         IntSet result = null;
         int xdiv2 = x/2;
         int ydiv2 = y/2;
         IntSet left1 = EmptySet.emptySet();
         IntSet right1 = EmptySet.emptySet();
        
         //Left branch only - 2 items
         if(isEven(x) && isEven(y)){              
             left1 = combine(xdiv2, ydiv2);
             right1 = EmptySet.emptySet(); 
             result = new TreeSet(left1, right1);            
         }
       
         //One in each branch
         if(!isEven(x) && isEven(y)){
             left1 = Singleton.singleton(ydiv2);
             right1 = Singleton.singleton(xdiv2);  
             result = new TreeSet(left1, right1);            
         }
       
         //One in each branch
         if(isEven(x) && !isEven(y)){
             left1 = Singleton.singleton(xdiv2);
             right1 = Singleton.singleton(ydiv2); 
             result = new TreeSet(left1, right1);
         }
       
         //Right branch only - 2 items
         if(!isEven(x) && !isEven(y)){
             left1 = EmptySet.emptySet(); 
             right1 = combine(xdiv2, ydiv2);
             result = new TreeSet(left1, right1);
         }  
        
         return result;
      }    
      
      /**
      * Method to use union to combine 2 sets
      * @param other, the intSet to be combined with the treeSet
      * @return the new tree
      **/ 
      public IntSet union(IntSet other) {
         IntSet result = null;
         IntSet left = this.leftBranch;
         IntSet right = this.rightBranch;
          if (other instanceof EmptySet){
              result= new TreeSet(leftBranch, rightBranch);
         }
         if (other instanceof Singleton){
            result= this.add(other.value);
         }  
         if (other instanceof TreeSet){
           TreeSet newTree = (TreeSet) other;
           IntSet val1 = newTree.leftBranch;
           IntSet val2 = newTree.rightBranch;
           result =tree(left.union(val1), right.union(val2));
         }
          return result;   
      }

       /**
        * Method to turn the set into a string format
        * @return the string value of the tree
       **/ 
      public String toString() {
         String originalTree = "";
         if (leftBranch instanceof TreeSet){
             countLB+=1;
             isTree=true;
             //left branch is a tree
             isOdd=false;
             //comes from left so even
             originalTree += leftBranch.toString();
             //calls toString on the left and right branches of left branch
             isTree=false; 
         }
         else if (leftBranch instanceof Singleton){
             int valLB =Integer.valueOf(leftBranch.toString().replace("{","").replace("}",""));
             valLB *=Math.pow(2,countLB);
             if(isTree){
                if(isOdd){
                    valLB*=Math.pow(2,countLB);
                    valLB+=1;
                }
             }
             countLB=1;
              //counts how many branches have been traversed on the left time 
             originalTree += String.valueOf(valLB) +",";
         }
         
         if (rightBranch instanceof TreeSet){
             countRB+=1;
             isTree=true;
             isOdd=true;
             originalTree += rightBranch.toString();
             //originalTree =originalTree.substring(0,originalTree.length()-1);
             isTree=false;
         }
         else if (rightBranch instanceof Singleton){
             int valRB =Integer.valueOf(rightBranch.toString().replace("{","").replace("}",""));
             valRB *=Math.pow(2,countRB);
             valRB +=1;
             if(isTree){
                 if(isOdd){
                    valRB+=2;
                }
                else{
                    valRB*=Math.pow(2,countRB);;
                } 
             }
             countRB=1;
             isTree=false;
             originalTree +=String.valueOf(valRB)+",";
         }
         if (originalTree.endsWith(",")) {
              originalTree = originalTree.substring(0, originalTree.length() - 1);
             
         }
         if (!originalTree.contains("{")){
            return "{"+originalTree+"}";
         }
             return originalTree;
        }
    }
   
      

