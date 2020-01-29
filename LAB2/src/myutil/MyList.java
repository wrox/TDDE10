package myutil;

public class MyList<E> extends AbstractList<E> implements MyListsInterface {

	private Node<E> lastNode = new Node<>();

	/**
	 * Adds new element to the node, sets next latest element.
	 * 
	 * @param element
	 */
	public void add(E element) {
		if (this.getNode() == null) {
			this.setNode(new Node<E>(element));
			this.alterSize(1);
			this.lastNode = this.getNode();
		} else {
			Node<E> tempNode = new Node<>(element);
			this.lastNode.setNext(tempNode);
			this.lastNode = this.lastNode.getNext();
			this.alterSize(1);
		}
	}

	/**
	 * Return element at specified index.
	 * 
	 * @param index
	 * @return
	 * @throws ListOutOfBoundsException
	 */
	// -------------------GetE non-recursive--------------------------------
	public E getElementAt(int index) throws ListOutOfBoundsException {
		if (!this.isEmpty() && (index < this.size())) {
			Node<E> tempNode = this.getNode();
			for (int i=0; i < index; i++) {									//while (i != index) {
				tempNode = tempNode.getNext();
			}
			return tempNode.getData();
		} else {
			throw new ListOutOfBoundsException();
		}

	}

	// -------------------GetE recursive--------------------------------

	/*
	 * private E getElementAtSub(int index, int i, Node<E> node) { if (i ==
	 * index) { /* Index values matched, return element at the same position
	 */
	// return node.getData();
	// } else {
	/* Return next element (i+1) in the list */
	// return getElementAtSub(index, i + 1, node.getNext());
	// }
	// }

	/**
	 * Return element at specified index.
	 * 
	 * @param index
	 * @return
	 * @throws ListOutOfBoundsException
	 */
	/*
	 * public E getElementAt(int index) throws ListOutOfBoundsException {
	 * if(!this.isEmpty() && (index<this.size())) { int i = 0; if (i == index) {
	 * return this.getNode().getData(); } else { return getElementAtSub(index, i
	 * + 1, this.getNode().getNext()); } } else { throw new
	 * ListOutOfBoundsException(); } }
	 */
}
