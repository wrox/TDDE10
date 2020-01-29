package myutil;

import myutil.Node;

public abstract class AbstractList<E> {

	private Node<E> node = null;
	private int size;
	
	public void alterSize(int i) {
		this.size += i;
	}
		
	/**
	 * Sets node
	 * 
	 * @param node
	 */
	public void setNode(Node<E> node) {
		this.node = node;
	}

	/**
	 * Returns node
	 * 
	 * @return Node<E>
	 */
	public Node<E> getNode() {
		return this.node;
	}

	/**
	 * Returns true if node is empty.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.node == null;
	}

	/**
	 * Returns total count of nodes as an integer.
	 * 
	 * @return integer
	 */
	public int size() {
		return this.size;
	
	
	
//	public int size() {
//		if (this.isEmpty()) {
//			return 0;
//		} else {
//			return this.node.length();
//		}

	}

}
