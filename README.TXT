For this project, I produced a bespoke implementation for sets of integers, with 3 kinds of concrete sets:
Empty set: gives us the set {}
Singleton set: sets containing only one number, giving us the set {x}
Tree Sets: sets containing at least 2 numbers, all tree sets are a tree of 2 branches which are both int sets - with even numbers on the left branch and odd numbers on the right branch. As we traverse the tree, the numbers are divided by 2.
An IntSet interface provides the methods add(int x), contains(int x), union(IntSet other), and toString() to each set class.


