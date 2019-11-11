package stack;

public class StackArray {

	
	private int size;
	private int[] arr;
	private int top=-1;
	public StackArray(int size)
	{
		this.size=size;
		this.arr=new int[size];
	}
	
	public void push(int item)
	{
		if(isFull())
		{
			throw new StackOverflowError("Stack IS Full");
		}
		
		arr[++top]=item;
	}
	public int pop()
	{
		
		if(isEmpty())
		{
			throw new StackOverflowError("Stack Is Empty");
		}
		return arr[top--];
	}
	public boolean isFull()
	{
		if(top==size-1)
		{
			return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		if(top==-1)
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		StackArray stack=new StackArray(5);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
	
	}
	
	
}
