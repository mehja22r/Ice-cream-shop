
public class StackLL<T> implements Stack<T> {
	
	LinkedList<T> stack;
	//T head;
	
	public StackLL () {
		stack = new LinkedList<T>();
	}

	@Override
	public boolean isEmpty() {
		//if head is null there are no nodes in the list
		 if (stack.getFirst() == null) {
			 return true;
		 }
		 //return false if there are items
		 return false;
		}
	
	/**see the value at the top of the stack**/

	@Override
	public T peek() {
		return stack.getFirst();
	}

	/**bring out the head**/
	@Override
	public T pop() {
		T data = stack.getFirst();
		stack.deleteFirst();
		return data;
	}

	/**insert a new head**/
	@Override
	public void push(T data) {
		stack.insertFirst(data);
		//System.out.println(head);
	}
	
	public String toString() {
		return stack.toString();
	}

	
}
