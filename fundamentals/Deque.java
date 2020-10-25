import java.util.NoSuchElementException;
import java.util.Scanner;

public class Deque<Item> {

	private class DoubleNode {
		Item item;
		DoubleNode previous;
		DoubleNode next;
	}

	private DoubleNode first = null;
	private DoubleNode last = null;
	private int N = 0;

	public boolean isEmpty() { return N == 0; } // 是否为空
	public int size() { return N; } // 大小

	public void pushLeft(Item item) {
		DoubleNode newFirst = new DoubleNode();
		newFirst.item = item;
		newFirst.next = this.first;

		if (this.first == null) {
			this.last = newFirst;
		} else {
			this.first.previous = newFirst;
		}

		this.first = newFirst;

		N ++;
	}


	public void pushRight(Item item) {
		DoubleNode newLast = new DoubleNode();
		newLast.item = item;
		newLast.previous = this.last;

		if (this.last == null) {
			this.first = newLast;
		} else {
			this.last.next = newLast;
		}

		this.last = newLast;

		N ++;
	}

	public Item popLeft() {
		if (this.isEmpty()) throw new NoSuchElementException();

		Item item = this.first.item; // 要弹出的值

		this.first = this.first.next;

		if (this.first == null) {
			this.last = null;
		} else {
			this.first.previous = null;
		}


		N --;

		return item;
	}

	public Item popRight() {
		if (this.isEmpty()) throw new NoSuchElementException();

		Item item = this.last.item;

		this.last = this.last.previous;
		
		if (this.last == null) {
			this.first = null;
		} else {
			this.last.next = null;
		}



		N --;

		return item;
	}

	public void printAll() {
		DoubleNode node = this.first;
		
		System.out.printf("{");

		while (node != null) {
			Item item = node.item;
			System.out.printf(item + ", ");

			node = node.next;
		}

		System.out.println("}");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Deque<Integer> deque = new Deque<>();

		int n = scanner.nextInt();
		for (int i = 0; i < n; i ++) {
			String cmd = scanner.next();

			if (cmd.equals("pop_left")) {
				System.out.println(deque.popLeft());
			}

			if (cmd.equals("pop_right")) {
				System.out.println(deque.popRight());
			}

			if (cmd.equals("push_left")) {
				int x = scanner.nextInt();
				deque.pushLeft(x);
			}

			if (cmd.equals("push_right")) {
				int x = scanner.nextInt();
				deque.pushRight(x);
			}

			if (cmd.equals("all")) {
				deque.printAll();
			}
		}
	}


}