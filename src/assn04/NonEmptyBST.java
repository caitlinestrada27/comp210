package assn04;
import assn03.Node;

import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element){
		// compare
		if (_element.compareTo(element) == 0) {
			// create node & insert if empty
			_element = element;
		} else if (_element.compareTo(element) == 1) {
			// insert right if element > root
			_right = insert(element);
		} else if (_element.compareTo(element) == -1) {
			// insert left if element < root
			_left = insert(element);
		} else {
			// end recursive function
			return null;
		}
	}
	
	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		return null;
	}
	
	// TODO: remove all in range (inclusive)
	@Override
	public BST<T> remove_range(T start, T end) {
		return null;
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
	}

	// The findMin method returns the minimum value in the tree.
	@Override
	public T findMin() {
		if(_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
	}

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
