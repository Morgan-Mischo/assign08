package assign08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	
	//root to work with
	public BinaryNode<Type> root = null; 
	
	//left child
	public BinaryNode<Type> left; 
	
	//right child
	public BinaryNode<Type> right;
	
	private int size = 0;

	@Override
	public boolean add(Type item) {
		
		BinaryNode<Type> newNode = new BinaryNode<Type>(item);
		
		if (root == null)
		{
			root = newNode; 
			size++;
			return true; 
		}
		
		else 
		{
			BinaryNode<Type> center = root;
			BinaryNode<Type> parent;
			
			while(true)
			{
				
				parent = center;
//				
//				BinaryNode<Type> parentLeft = parent.left();
//				BinaryNode<Type> parentRight = parent.right();
				
				if(item.compareTo(center.element()) < 0)
				{
					center = center.left;
					
					if(center == null)
					{
						parent.left = newNode;
						size++;
						return true;
					}
				}
				
				else if(item.compareTo(center.element()) > 0)
				{
					center = center.right;
					
					if(center == null)
					{
						parent.right = newNode;
						size++;
						return true;
					}
				}
				
				else
					return false;
			}
		}
	}

	@Override
	public boolean addAll(Collection<? extends Type> items) {
		
		List<Type> myList = new ArrayList<Type>();
		myList.addAll(items);
		
		boolean branch = false;
		boolean changed = false;
		
		for(int i = 0; i < myList.size(); i++)
		{
			branch = add(myList.get(i));
			if (branch)
				changed = true;
		}
		return changed;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	@Override
	public boolean contains(Type item) {
		BinaryNode<Type> center = root;
		
		while(center != null)
		{
			if(item.compareTo(center.element()) < 0)
			{
				center = center.left();
			}
			
			else if(item.compareTo(center.element()) > 0)
			{
				center = center.right();
			}
			
			else
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		
		List<Type> myList = new ArrayList<Type>();
		myList.addAll(items);

		for(int i = 0; i < myList.size(); i++)
		{
			if(!contains(myList.get(i)))
				return false;
		}
		return true;
	}

	@Override
	public Type first() throws NoSuchElementException {
		
		if(isEmpty())
			throw new NoSuchElementException();
		
		BinaryNode<Type> center = root;
		
		while(center.left() != null)
		{
			center = center.left();
		}
		
		return center.element();
	}

	@Override
	public boolean isEmpty() {
		return root.equals(null);
	}

	@Override
	public Type last() throws NoSuchElementException {
		
		if(isEmpty())
			throw new NoSuchElementException();
		
		BinaryNode<Type> center = root;
		
		while(center.right() != null)
		{
			center = center.right();
		}
		
		return center.element();
	}

	@Override
	public boolean remove(Type item) {
		if(contains(item))
		{
			//To remove, must find position of item. It's parent now becomes children's parent 
			return true;
		}
		else 
			return false;
	}

	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<Type> toArrayList() {
		ArrayList<Type> storage = new ArrayList<Type>();
		if(!isEmpty())
		{
			inOrderSearch(root, storage);
		}
		for(int i = 0; i < storage.size(); i++)
		{
		System.out.println(storage.get(i));
		}
		return storage;
	}

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
