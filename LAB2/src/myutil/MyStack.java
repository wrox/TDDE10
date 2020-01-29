package myutil;

import myutil.Node;

public class MyStack<E> extends AbstractList<E> implements MyListsInterface {

	/**
	 * Adds new element into our stack, after other elements.
	 * 
	 * @param element
	 */
	public void push(E element) {
		if (this.getNode() == null) {
			this.setNode(new Node<E>(element));
			this.alterSize(1);
		} else {
			Node<E> tempNode = new Node<>(element);
			tempNode.setNext(this.getNode());
			this.setNode(tempNode);
			this.alterSize(1);
		}
	}

	/**
	 * Returns the latest addition to the stack.
	 * 
	 * @return E
	 * @throws StackEmptyException
	 */
	public E peek() throws StackEmptyException {
		if (!this.isEmpty()) {
			return this.getNode().getData();
		} else
			throw new StackEmptyException();
	}

	/**
	 * Returns and removes the latest addition to the stack.
	 * 
	 * @return E
	 * @throws StackEmptyException
	 */
	public E pop() throws StackEmptyException {
		if (!this.isEmpty()) {
			E tempData = this.getNode().getData();
			this.setNode(this.getNode().getNext());
			this.alterSize(-1);
			return tempData;
		} else {
			throw new StackEmptyException();
		}
	}
}
