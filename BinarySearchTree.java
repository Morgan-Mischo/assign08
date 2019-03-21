package assign08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A class that creates a BinarySearchTree and performs different methods on it. Implements SortedSet
 * @author Morgan Mischo and Casey Rand
 */

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	
	//root to work with
	public BinaryNode<Type> root = null; 
	
	//left child
	public BinaryNode<Type> left; 
	
	//right child
	public BinaryNode<Type> right;
	
	//remove boolean
	public boolean remove; 
	
	//size of the tree
	private int size = 0;
	
	//parent
//	public BinaryNode<Type> parent; 
	

	/**
	 * Adding a singular Type onto the BinarySearch tree
	 */
	@Override
	public boolean add(Type item) {
		
		//The node containing type item
		BinaryNode<Type> newNode = new BinaryNode<Type>(item);
		
		//If we don't have a root, make the newNode the root
		if (root == null)
		{
			root = newNode; 
			size++;
			return true; 
		}
		
		else 
		{
			//If we do have a root, rename it and iterate underneath it. 
			BinaryNode<Type> center = root;
			
			while(true)
			{
				
				BinaryNode<Type> parent = center;
				
				//If our item is smaller than the element in our root, make it the left child
				if(item.compareTo(center.element()) < 0)
				{
					center = center.left;
					
					if(center == null)
					{
						newNode.parent = parent; 
						parent.left = newNode;
						size++;
						return true;
					}
				}
				
				//If our item is bigger than the element in our root, make it the right child
				else if(item.compareTo(center.element()) > 0)
				{
					center = center.right;
					
					if(center == null)
					{
						newNode.parent = parent; 
						parent.right = newNode;
						size++;
						return true;
					}
				}
				
				//If we can't add, return false
				else
				{
					return false;
				}
			}
		}
	}

	
	/**
	 * Method for adding a collection of type into our BinarySeachTree
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) {
		
		//Making our items into an ArrayList
		List<Type> myList = new ArrayList<Type>();
		myList.addAll(items);
		
		//Booleans to use within the method
		boolean branch = false;
		boolean changed = false;
		
		//For loop adding into our BinarySearch Tree
		for(int i = 0; i < myList.size(); i++)
		{
			branch = add(myList.get(i));
			if (branch)
				changed = true;
		}
		
		//If our for loop changed our BinarySearchTree, return true
		return changed;
	}

	/**
	 * Method for clearing the entire BinarySearchTree
	 */
	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Method for seeing if our BinarySearchTree has an item we are looking for
	 */
	@Override
	public boolean contains(Type item) {
		
		//New BinaryNode so we can look at our root without altering it
		BinaryNode<Type> center = root;
		
		//While loop to go through the BinarySearchTree
		while(center != null)
		{
			//If our item is smaller than our root, we assign it to the left
			if(item.compareTo(center.element()) < 0)
			{
				center = center.left();
			}
			
			//If our item is larger than our root, we assign it to the right
			else if(item.compareTo(center.element()) > 0)
			{
				center = center.right();
			}
			
			else
				//Return true if there is an element equal to the input item
			{
				return true;
			}
		}
		//Return false if there isn't an element equal to the input item
		return false;
	}

	/**
	 * Boolean that returns true if our BinarySearchTree contains the input collection of items
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		
		//New arrayList to hold our collection of items
		List<Type> myList = new ArrayList<Type>();
		myList.addAll(items);

		//For loop to check if each node has the corresponding item
		for(int i = 0; i < myList.size(); i++)
		{
			//If it doesn't contain the item, return false
			if(!contains(myList.get(i)))
			{
				return false;
			}
		}
		//Otherwise, return true
		return true;
	}
	
	/**
	 * Returns the smallest item in the set
	 */
	@Override
	public Type first() throws NoSuchElementException {
		
		//If our tree is empty, throw a NoSuchElementException
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		//Set a binary node equal to the root for easy access
		BinaryNode<Type> center = root;
		
		//While we have a left child, set it equal 
		while(center.left() != null)
		{
			center = center.left();
		}
		
		//Return our smallest element
		return center.element();
	}

	/**
	 * Boolean that returns true if our set is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0; 
	}

	/**
	 * Method that returns the largest element in the set
	 */
	@Override
	public Type last() throws NoSuchElementException {
		
		//If the set is empty, throw an exception
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		//Set a new node equal to our root for easy access
		BinaryNode<Type> center = root;
		
		//While we have a right child, set our new node equal to the right child
		while(center.right() != null)
		{
			center = center.right();
		}
		
		//Return the furthest right child (the largest element)
		return center.element();
	}
	
	/**
	 * Boolean that tells us whether or not we were able to remove something
	 */
	@Override
	public boolean remove(Type item) {
		
		//return our helper method
		return delete(root, item); 
	}
	
	/**
	 * Helper method for remove
	 */
	public boolean delete(BinaryNode<Type> root, Type item)
	{ 
		//Base case
		if (root == null)
		{
			return false;  
		}
		
		//Otherwise, recur down the tree
		if(item.compareTo((Type) root.element()) < 0)
		{ 
			delete(root.left(), item); 
		}
		else if (item.compareTo((Type) root.element()) > 0)
		{
			delete(root.right(), item); 
		}
		
		//if the key is the same as root's key then we delete this node
		
		else 
		{
			//node with one child or no children
			{
				if (root.left == null)
				{
					root = root.right; 
					return true; 
				}
				else if (root.right == null)
				{
					root = root.left; 
					return true; 
				}
				
				//If the node has two children, we have to get the smallest in the right subtree	
				BinaryNode<Type> rightSide = root.right();
				
				while(rightSide.left() != null)
				{
					rightSide = rightSide.left(); 
				}
				
				root.resetElement(rightSide.element()); 
				rightSide = rightSide.parent; 
				rightSide.setLeft();
				

				return true; 
				
			}
		}
		return false; 
	}

	/**
	 * Return true if we are able to remove everything in a collection
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		ArrayList<Type> storage = new ArrayList<Type>();
		storage.addAll(items); 
		
		boolean myBool = false; 
		for(int i = 0; i < storage.size(); i++)
		{
			if (remove(storage.get(i)) == true)
			{
				myBool = true; 
			}
		}
		return myBool; 
	}

	/**
	 * Returns the size of our set
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Converts the set to an ArrayList
	 */
	@Override
	public ArrayList<Type> toArrayList() {
		ArrayList<Type> storage = new ArrayList<Type>();
		if(!isEmpty())
		{
			inOrderSearch(root, storage);
		}
		return storage;
	}

	/**
	 * Method that performs an inOrderSearch starting at binaryNode Focus on an arrayList of storage
	 */
	private void inOrderSearch(BinaryNode<Type> focus, ArrayList<Type> storage) {

		if (focus == null)
			return;
		
		inOrderSearch(focus.left(), storage);
		
		storage.add(focus.element());
		
		inOrderSearch(focus.right(), storage);
		
	}
	
	
	/**
	 * Returns the BST represented as a String. Each line represents each level of the tree, two values
	 * in each line are children to a value in the above line. Null/No children is represented as "-"
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		int remainingNodes = size; //The amounts of Nodes in the tree that need to be added
		int level = 0; //The current level in Level-Order Traversal. Start at level 0 (root)
		int nodesInLevel = 0; //The current amount of nodes in the level while traversing
		int levelCapacity = 1; //Maximum amount of nodes per level. Value is 2^n, where n is the current level. Start at 2^0 = 1
		Queue<BinaryNode<Type>> q = new LinkedList<BinaryNode<Type>>();
		q.offer(root);
		
		//Build the string while there are still non-null Nodes to be added
		//in a Level-Order Traversal of the BST.
		while (remainingNodes != 0) {
			
			//If the current level reaches maximum capacity, update some variables, and start a new line representing a new level.
			if (nodesInLevel == levelCapacity) {
				result.append("\n"); 
				level++; 
				nodesInLevel = 0;
				levelCapacity = (int) Math.pow(2, level);
			}
			
			
			BinaryNode<Type> current = q.poll();
		
			//Represent null nodes as "-"
			if (current == null) {
				result.append("- ");
				//To keep structure order, add the null node's children to the queue, which is null.
				q.offer(null);
				q.offer(null);
			}
			else { //If the node is not null, add its data to the string, then add its children to the queue
				result.append(current.element().toString() + " ");
				q.offer(current.left);
				q.offer(current.right);
				remainingNodes--; //Since a non-null node was added to the string, there is one less remaining node.
			}
			
			//A node was added to the string, increase the counter that represents the amount of nodes in the current level
			nodesInLevel++;
			
		}
		
		//When all of the non-null nodes have been added to the string, fill the remaining slots of the current level with
		//null nodes.
		while (nodesInLevel < levelCapacity) {
			result.append("- ");
			nodesInLevel++;
		}
		
		return result.toString();
	}
}
