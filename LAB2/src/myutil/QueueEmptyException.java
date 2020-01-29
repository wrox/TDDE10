package myutil;

public class QueueEmptyException extends RuntimeException {
	public QueueEmptyException() {
		super("Return value is null.");
	}
}
