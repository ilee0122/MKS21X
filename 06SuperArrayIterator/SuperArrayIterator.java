//SuperArrayIterator

import java.util.*;

public class SuperArray implements Iterable<String>{
    private int size;
    private String[] data;

    //Added Features
    private class SuperArrayIterator implements Iterator<String> {
	private int next;
	SuperArray data;
	
	public SuperArrayIterator(SuperArray d){
	    int next = 0;
	    data = d;
	}
	
	public String next(){
	    if (hasNext()){
		next++;
	    }
	    else{
		System.exit(0);
	    }
	    return data.get(next-1);
	}

	public boolean hasNext(){
	    return next < data.size();
	}
    }
    
    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
    //
    
    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int cap) {
	data = new String[cap];
	size = 0;
    }
    
    public void clear(){
	data = new String[10];
	size = 0;
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    public boolean add(String element){
	//resize(); //check to see if space is available
	//data[size] = element;
	//size++;
	//return true;

	//Updated
	add(size(), element);
	return true;
    }

    public String toString(){
	int index = 0;
	String returnString = "[";
	for(; index + 1 < size; index++){
	    returnString += data[index] + ",";
	}
	returnString += " " + data[index] + "]";
	return returnString;
    }

    public String get(int index){
	if(index < 0 || index >= size()){
	    //System.out.println("Error: Index out of bounds");
	    //return "";

	    //Throw exception
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public String set(int index, String element){
	if(index < 0 || index >= size){
	    //System.out.println("Error: Index out of bounds");
	    //return "";

	    throw new IndexOutOfBoundsException();
	}
	String oldString = data[index];
	data[index] = element;
	return oldString;
    }

    private void resize(){
	if(data.length + 1 == size){
	    String[] newData = new String [size * 2];
	    for(int index = 0; index < size; index++){
		newData[index] = data[index];
	    }
	    data = newData;
	}
    }

    public boolean contains(String element){
	for(int index = 0; index < size; index++){
	    if(data[index].equals(element)){
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String element){
	for (int index = 0; index < size; index++){
	    if(data[index] == element){
		return index;
	    }
	}
	return - 1;
    }

    public int lastIndexOf(String element){   //same as indexOf, just backwards
	for(int index = size; index >= 0; index--){
	    if(data[index] == element){
		return index;
	    }
	}
	return - 1;
    }

    public void add(int index, String element){
	resize();
	if(index < 0 || index > size()){
	    // System.out.println("Error: Index out of bounds");
	    throw new IndexOutOfBoundsException();
	}
	else{   
	    for(int count = size(); count > index; count--){
		data[count + 1] = data[count];
	    }
	    data[index] = element;
	    size++;
	}
    }

    public String remove(int index){
	if(index < 0 || index >= size){
	    System.out.println("Error: Index out of bounds");
	    return "";
	}
	String ans = data[index];
	for(int count = index; count < size; count++){
	    data[count] = data[count + 1];
	}
	size--;
	return ans;
    }

    public boolean remove(String element){
	int count;
	for(count = 0; data[count] != element; count++){
	    if(count == size){
		return false;
	    }
	}
	for(int newCount = count; count < size; count++){
	    data[count] = data[count + 1];
	}
	size--;
	return true;
    }
}
