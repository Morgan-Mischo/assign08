package assign08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	
	//root to work with
	public BinaryNode<Type> root = null; 
	
	//left child
	public BinaryNode<Type> left; 
	
	//right child
	public BinaryNode<Type> right; 
	
	

	@Override
	public boolean add(Type item) {
		
		BinaryNode<Type> newNode = new BinaryNode<Type>(item);
		
		if (root == null)
		{
			root = newNode; 
			return true; 
		}
		
		else 
		{
			BinaryNode<Type> center = root;
			
			BinaryNode<Type> parent;
			
			while(true)
			{
				
				parent = center;
				BinaryNode<Type> parentLeft = parent.left();
				BinaryNode<Type> parentRight = parent.right();
				
				if(item.compareTo(center.element()) < 0)
				{
					center = center.left();
					
					if(center == null)
					{
						parentLeft = newNode;
						return true;
					}
				}
				
				else if(item.compareTo(center.element()) > 0)
				{
					center = center.right();
					
					if(center == null)
					{
						parentRight = newNode;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Type> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

}
