abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String auth, String titl, String bookNum, String callNum){
	super();
	callNumber = callNum;
    }

    //Getter
    public String getCallNumber(){
	return callNumber;
    }

    //Setter
    public void setCallNumber(String callNum){
	callNumber = callNum;
    }

    abstract void checkout(String patron, String due){}

    abstract void returned(){}

    abstract String circulationStatus(){}

    public int compareTo(LibraryBook other){
	return callNumber.compareTo(other.getCallNumber());
    }

    public String toString(){
	return 
