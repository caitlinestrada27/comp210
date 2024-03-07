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
		if (_element.compareTo(element) < 0) {
			// insert element on right if element > root
			if (_right.isEmpty()) {
				NonEmptyBST<T> bst = new NonEmptyBST<>(element);
				_right = bst;
			} else {
				_right.insert(element);
			}
		} else if (_element.compareTo(element) > 0) {
			// insert element on left if element > root
			if (_left.isEmpty()) {
				NonEmptyBST<T> bst = new NonEmptyBST<>(element);
				_left = bst;
			} else {
				_left.insert(element);
			}
		}
		return this;
	}
	
	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if (_element.compareTo(element) < 0) { // right
			_right = _right.remove(element);
			return this;
		}
		if (_element.compareTo(element) > 0) { // left
			_left = _left.remove(element);
			return this;
		}
		// at element that we need, = 0
		if (!_left.isEmpty() && !_right.isEmpty()) { // 1. 2 kids
			_element = _right.findMin();
			_right = _right.remove(_element);
			return this;
		} else if (!_left.isEmpty() && _right.isEmpty()) { // 2. 1 left
			return _left;
		} else if (_left.isEmpty() && !_right.isEmpty()) { // 3. 1 right
			return _right;
		} else { // 4. no kids
			return new EmptyBST<>();
		}
	}
	
	// TODO: remove all in range (inclusive)
	@Override
	public BST<T> remove_range(T start, T end) {
		NonEmptyBST<T> output = this;
		if (!_left.isEmpty()) {
			_left = _left.remove_range(start, end);
		}
		if (!_right.isEmpty()) {
			_right = _right.remove_range(start, end);
		}

		if (start.compareTo(_element) <= 0 && end.compareTo(_element) >= 0) {
			return remove(_element);
		}

		return this;
    }

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(_element + " ");
		_left.printPreOrderTraversal();
		_right.printPreOrderTraversal();
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		_left.printPostOrderTraversal();
		_right.printPostOrderTraversal();
		System.out.print(_element + " ");
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
