package myutil;

import myutil.Node;

public class MyQueue<E> extends AbstractList<E> implements MyListsInterface {

	private Node<E> lastNode = new Node<>();

	/**
	 * Adds next element at the end of the queue, next to the last element.
	 * 
	 * @param element
	 */
	public void enqueue(E element) {
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
	 * Returns and removes the oldest addition to the queue.
	 * 
	 * @return E
	 * @throws QueueEmptyException
	 */
	public E dequeue() throws QueueEmptyException {
		if (!this.isEmpty()) {
			E tempData = this.getNode().getData();
			this.setNode(this.getNode().getNext());
			this.alterSize(-1);
			return tempData;
		} else {
			throw new QueueEmptyException();
		}
	}
}
