package myutil;

public class Node<E> {

	private E data;
	private Node<E> next;

	
	public Node () {
		this.next=null;
	}
	
	public Node(E object) {
		this.data = object;
		this.next = null;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Returns data objects that has been saved.
	 * 
	 * @return E
	 */
	public E getData() {
		return this.data;
	}

	public void setNext(Node<E> nextNode) {
		this.next = nextNode;
	}

	/**
	 * Returns the next node in the list.
	 * 
	 * @return Node
	 */
	public Node<E> getNext() {
		return this.next;
	}

	/**
	 * Returns the length of all nodes in the list.
	 * 
	 * @return integer
	 */
	/*
	public int length() {
		if (this.next == null) {
			return 1;
		} else {
			return 1 + this.next.length();
		}
	}
	*/
	/**
	 * Return the last node in the list.
	 * 
	 * @return Node
	 */
	/*
	public Node<E> last() {
		if (this.next != null) {
			return this.next.last();
		} else {
			return this;
		}
	} */
}