public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for (int i = 0; i < ary.length; i++){
	    add(ary[i]);
	}
    }

    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }

    public void add(int index, String element){
	add(element);
    }

    public boolean add(String value){
	int x = findIndexBinary(value);

	
	//if (x >= size()){  //add to the last spot
	//    super.add(value);
        //}
	
	//else {  //add to the appropriate index
	//    super.add(x, value);
	//}
	super.add(index, value);
	
	return true;
    }
    
    private int findIndex(String element){
	for (int x = 0; x < size(); x++){  //start from beginning and go through the array until you find the right index
	    if (get(x).compareTo(element) > 0 ){
		return x;
	    }
	}
	return size(); //when it is the biggest, it goes last
    }

    private int findIndexBinary(String element){
	int start = 0;
	int end = size();
	
	while (start != end){ 
	    if (get((start + end)/2).compareTo(element) > 0){  //if bigger, search left
		end = (start + end) / 2;
	    }
	    else {
		start = (start + end) / 2 + 1;  //if smaller, search right
	    }
	}
	
	return start; //when start = end, return start
    }

    public int indexOfBinary(String element){
       	int start = 0;
	int end = size();
	
	while (start != end){
	    if (get((start + end)/2).compareTo(element) > 0){ //same as findIndexBinary(String)
		end = (start + end) / 2;
	    }
	    
	    else if (get((start + end)/2).equals(element)){ //check if value is equal
		if (start == 0 || !(get((start + end) / 2 - 1).equals(element))){ //checks if it is indeed the first instance
		    return (start + end) / 2;
		}
		end = (start + end) / 2;
		start = (start + end) / 2 - 1; 
	    }
	    
	    else {
		start = (start + end) / 2 + 1; //if it is less, search right
	    }
	}
	
	if (get(start) != element){ //returns -1 when it doesn't contain element
	    return -1;
	}
	
	return start;
    }

    public int lastIndexOfBinary(String element){
	int start = indexOfBinary(element); // better than starting at 0 --> narrows the search process
	int end = size();
	
	while (start != end){
	    if (get((start + end)/2).compareTo(element) > 0){ //same as indexOfBinary
		end = (start + end) / 2;
	    }
	    else if (get((start + end)/2).equals(element)){
		if (start == size() - 1 || !(get((start + end) / 2 + 1).equals(element))){ //checks if it is indeed the last instance
		    return (start + end) / 2;
		}
		end = (start + end) / 2;
		start = (start + end) / 2 - 1; 
	    }
	    else {
		start = (start + end) / 2 + 1; //same as indexOfBinary
	    }
	}
	
	if (get(start) != element){ //returns -1 when it doesn't contain element
	    return -1;
	}
	
	return start;
    }
}
