package TestPackage;

import java.util.Scanner;

import myutil.*;

public class MyTestProgram {

	public static Node<Integer> node1 = new Node<>();
	public static MyStack<Integer> stack1 = new MyStack<>();
	public static MyQueue<Character> que1 = new MyQueue<>();
	public static MyList<TestClass> list1 = new MyList<>();
	public static TestClass testClass1 = new TestClass(1);
	public static TestClass testClass2 = new TestClass(2);
	public static TestClass testClass3 = new TestClass(3);
	public static TestClass testClass4 = new TestClass(4);
	public static TestClass testClass5 = new TestClass(5);

	public static void nodeTest(Node<Integer> node) {
		System.out.println("Added integer: 3 to node.\n");
		node.setData(3);

		System.out.println("This was stored in the node: " + node.getData());
		
		System.out.println("Now we create a new node and assign the value 5\n");
		node.setNext(new Node<Integer>(5));
		
		System.out.println("Now we print the value of the second node: " + node.getNext().getData());
		
		System.out.println("Now we add another node with value 4\n");
		node.getNext().setNext(new Node<Integer>(4));
		
		System.out.println("Now we print the value of the third node: " + node.getNext().getNext().getData());
	}

	public static void stackTest(MyStack<Integer> stack) {
		System.out.println("Stack is empty: " + stack.isEmpty());
		System.out.println("\n");
		System.out.println("start pushing integers to stack..");

		for (int i = 1; i < 5; i++) {
			System.out.println("Pushed: " + i);
		}

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println("end push");

		System.out.println("Stack is empty: " + stack.isEmpty());
		System.out.println("\n");

		System.out.println("Stack size: " + stack.size());
		System.out.println("\n");

		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		
		
		try {
			System.out.println(stack.peek()); // triggers StackEmptyException
		} catch (RuntimeException StackEmptyException) {
			System.out.println("Tried to pop an object that does not exist. Throws error.");
			System.out.println("Caught StackEmptyException");
		}
		
		System.out.println("\n");
		System.out.println("Stack size: " + stack.size());
	}

	public static void queueTest(MyQueue<Character> que) {
		System.out.println("Queue is empty: " + que.isEmpty() + "\n");

		System.out.println("Enqueue characters: L, 3, %");
		que1.enqueue('L');
		que1.enqueue('3');
		que1.enqueue('%');
		
		System.out.println("Queue is empty: " + que.isEmpty() + "\n");

		System.out.println("Dequeue: " + que.dequeue());
		System.out.println("Dequeue: " + que.dequeue());
		System.out.println("size: " + que.size());
		System.out.println("Dequeue: " + que.dequeue());
		System.out.println("size: " + que.size());
		
		
		try {
			System.out.println(que.dequeue()); //triggers QueueEmptyException
		} catch (RuntimeException QueueEmptyException) {
			System.out.println("Tried to dequeue an object that does not exist. Throws error.");
			System.out.println("Caught QueueEmptyException");
		}
	}

	public static void listTest(MyList<TestClass> list) {
		System.out.println("List is empty: " + list.isEmpty());
		System.out.println("adds elements: testClass1-5");

		list.add(testClass1);
		list.add(testClass2);
		list.add(testClass3);
		list.add(testClass4);
		list.add(testClass5);

		System.out.println("List is empty: " + list.isEmpty() + "\n");

		System.out.println("Getting element from index 3 and using method of testclass (printMe())\n");
		list.getElementAt(3).printMe();
		System.out.println("");
		System.out.println("Getting element from index 2 and using method of testclass (printMe())\n");
		list.getElementAt(2).printMe();
		System.out.println("");
		System.out.println("Getting element from index 4 and using method of testclass (printMe())\n");
		list.getElementAt(4).printMe();
		
		
		try {
			list.getElementAt(5).printMe(); //triggers ListOutofBoundsException
		} catch (RuntimeException ListOutOfBoundsException) {
			System.out.println("Tried to get an object that does not exist. Throws error.");
			System.out.println("Caught ListOutOfBoundsException");
		}
		
		System.out.println("");
		System.out.println("Size: " + list.size());
	}

	public static void main(String[] args) {
		/*
		 * NodeTest. Tests the following methods: add, setData, getData,
		 * setNext, getNext, length, last.
		 */
		
		nodeTest(node1);
		System.out.println("\n---------------------------------------------------\n");

		/*
		 * StackTest. Tests the following methods: push, peek, pop, isEmpty,
		 * size.
		 */
		stackTest(stack1);
		System.out.println("\n---------------------------------------------------");
		/*
		 * Tests the following methods: enqueue, dequeue, isEmpty, size.
		 */
		queueTest(que1);
		System.out.println("\n---------------------------------------------------");

		/*
		 * Tests the following methods: enqueue, dequeue, isEmpty, size.
		 */
		listTest(list1);
		
	}
}