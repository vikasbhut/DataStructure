package hashing;


 class DataItem
{
	
	private int data;
	public DataItem(int data)
	{
		this.data=data;
	}
	public int getkey()
	{
		return data;
	}
}
 



public class HashTable {

	
	DataItem[] hashArray;
	int arraySize;
	DataItem bufItem;
	
	
	public HashTable(int size)
	{
		arraySize=size;
		hashArray=new DataItem[arraySize];
		bufItem=new DataItem(-1);
	}
	public int hashFunction(int key)
	{
		return key%arraySize;
	}
	
	public void insert(DataItem item)
	{
		int key=item.getkey();
		int hashVal=hashFunction(key);
		while(hashArray[hashVal]!=null&&hashArray[hashVal].getkey()!=-1)
		{
			hashVal=(hashVal+1)%arraySize;
		}
		hashArray[hashVal]=item;
	}
	public DataItem delete(int key)
	{
		int hashVal=hashFunction(key);
		
		while(hashArray[hashVal]!=null)
		{
			if(hashArray[hashVal].getkey()==key)
			{
				DataItem item=hashArray[hashVal];
				hashArray[hashVal]=bufItem;
				return item;
			}
			hashVal=(hashVal+1)%arraySize;
		}
		return null;
	}
	
	public DataItem find(int key)
	{
		int hashVal=hashFunction(key);
		int h=1;
		while(hashArray[hashVal]!=null)
		{
			if(hashArray[hashVal].getkey()==key)
			{
				return hashArray[hashVal];
				
			}
			hashVal=(hashVal+1)%arraySize;
		}
		return null;
	}
	private void displayTable() {
		
	    System.out.print("Table: ");

		for (int j = 0; j < arraySize; j++) {
		      if (hashArray[j] != null)
		        System.out.print(hashArray[j].getkey() + " ");
		      else
		        System.out.print("#");
		    }
		    System.out.println("");		
	}
	public static void main(String[] args) {
		
		//50, 700, 76, 85, 92, 73 and 101
		
		HashTable hashTable=new HashTable(7);
		hashTable.insert(new DataItem(50));
		hashTable.insert(new DataItem(700));
		hashTable.insert(new DataItem(76));
		hashTable.insert(new DataItem(85));
		hashTable.insert(new DataItem(92));
		hashTable.insert(new DataItem(73));
		hashTable.insert(new DataItem(101));
		
		hashTable.delete(92);
		hashTable.displayTable();
		
	}
}
