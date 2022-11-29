package com.company.hashTable;

import java.util.Iterator;
import java.util.LinkedList;

public class Hashtable {
	private class Record{
		private Object key;
		private Object value;

		public Record() {
			this.key = null;
			this.value = null;
		}

		public Record(Object inKey, Object inData) {
			this.key = inKey;
			this.value = inData;
		}
		/* Equality can be based on key alone because there can't be
		 * 2 records with the same key in the table */
		public boolean equals(Object obj) {
			if (obj instanceof Record) {
				Record node = (Record)obj;
				return this.key.equals(node.key);
			}
			else {
				return false;
			}
		}
		public String toString() {
			return "Key: ["+this.key+"] Value: ["+this.value+"]";
		}
	}
	//
	private int numElem;
	private LinkedList<Record> [] table;
	
	//constructor
	public Hashtable(int realSize) {
		this.table = new LinkedList[realSize];
		this.numElem = 0;
	}
	
	private int hash(Object key) {

		/* Start with a base, just so that it's not 0 for empty strings */
		int result = 42; //start at hard coded base

		String inputString = key.toString().toLowerCase();
		//System.out.println("hash string is:" + inputString + "\n");

		char [] characters = inputString.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			char currentChar = characters[i];
			int j = (int)currentChar;
			//System.out.println("j = " + j );
			result += j;
		}
		return (result % this.table.length);
	}

	public void put(Object key, Object data) {
		boolean update = false;
		if (data == null || key == null) {
			System.err.println("ERROR: Either the key or the data are null");
			return;
		}
		// Find out where in our array should the new item goes 
		int pos = this.hash(key);
		// If nothing exists in the position, create a new linked list there 
		if (this.table[pos] == null) {
			this.table[pos] = new LinkedList<Record>();
		}
		LinkedList<Record> theList = this.table[pos];
		// If trying to add duplicate keys, that means 
		// we like to update the value associated with that existing key.
		// We first delete the existing mapping, then insert a new record that key.
		if( theList.contains(new Record(key, data)) ) {
			theList.remove(new Record(key, data));
			update = true;
		}
		// Add to the linked list in the appropriate position
		theList.add(new Record(key, data));
		if( ! update) {
			this.numElem ++;
		}
	}
	
	public void put(Object [] keys, Object [] inputData) {
		for (int i = 0; i < inputData.length; i++) {
			this.put(keys[i], inputData[i]);
		}
	}
	
	//return type is different from the standard Map interface.
	public void remove(Object key) {
		int pos = this.hash(key);

		if (this.table[pos] != null) {
			Record node = new Record();
			node.key = key; //in order to use the equals() method in HashtableNode
			LinkedList<Record> theList =  this.table[pos];
			//
			boolean removed = theList.remove(node);
			if( theList.size() == 0 )
				this.table[pos] = null;
			if( removed )
				this.numElem --;
		}
	}

	public void remove(Object [] keys) {
		for (int i = 0; i < keys.length; i++) {
			this.remove(keys[i]);
		}
	}

	public Object get(Object key) {
		if (!this.contains(key)) { //Return null if table element is null at the index where the key would be stored
			return null;
		}
		int pos = this.hash(key); //get index of the linkedlist where the record may be stored
		LinkedList<Record> theList = (LinkedList<Record>) this.table[pos];
		Iterator<Record> iterator = theList.iterator();

		while (iterator.hasNext()) { //Linearly search theList for a record with a matching key
			Record record = iterator.next();
			if (record.key.equals(key)) { //if the current node in the linked list has the matching key
				return record.value;
			}
		}

		return null; //Returns null if table[pos] has a linked list, but that linked list doesn't contain the record
	}

	public String toString() {
		String buffer = "";

		buffer += "{\n";
		for (int i = 0; i < this.table.length; i++) {
			if (this.table[i] != null) {
				buffer  = buffer +  "\t" + this.table[i] + "\n" ;
			}
		}
		buffer += "}";
		return buffer;
	}

	public int size() {
		return this.numElem;
	}

	public boolean contains(Object key) {
		boolean result = false;
		int hash = this.hash(key);

		if (this.table[hash] != null) {
			Record node = new Record();
			node.key = key;
			if (this.table[hash].indexOf(node) > -1) {
				result = true;
			}
		}
		return result;
	}
	
	public static void main(String argv[]){
		Hashtable myhash = new Hashtable(20);
	/*	
		//test of strings
		System.out.println("Inital hash table is: \n" + myhash);
		myhash.put("smith", 30);
		myhash.put("john", 10);
		System.out.println("After two adds, hashtalbe is: \n" + myhash);
		myhash.put("green", 10);
		myhash.put("green", 60); //this will be added successfully, updating existing record.
		System.out.println("After four adds, hashtalbe is: \n" + myhash);
		
		myhash.remove("green");
		System.out.println("After remove green, hashtalbe is: \n" + myhash);
*/		
		
		System.out.println("Initial hash table is: \n" + myhash);
		myhash.put(11.5f, "smith");
		myhash.put(100.9f, "john");
		System.out.println("After two adds, hashtable is: \n" + myhash);
		myhash.put(3.4, "green");
		myhash.put(3.4, "white"); //this successfully updated the existing record with key = 3.4
		System.out.println("After total four adds(one update), hashtable is: \n" + myhash);
		System.out.println("Size of the table is " + myhash.size());
		
		myhash.remove(3.4);
		System.out.println("After remove 3.4, hashtable is: \n" + myhash);
		System.out.println("Size of the table is " + myhash.size());
	}

}
