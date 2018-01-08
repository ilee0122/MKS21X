public class Book{
    private String author;
    private String title;
    private String ISBN;

    public null Book(){
	
    }

    //Constructor
    public Book(String auth, String titl, String bookNum){
	author = auth;
	title = titl;
	ISBN = bookNum;
    }

    //Getters
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }

    //Setters
    public void setAuthor(String auth){
	author = auth;
    }
    public void setTitle(String titl){
	title = titl;
    }
    public void setISBN(String bookNum){
	ISBN = bookNum;
    }
    
    public String toString(){
	return title + " , " + author +  " , " + ISBN;
    }

}
