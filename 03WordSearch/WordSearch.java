import java.util.*;
import java.io.*; //* includes all, such as File, Scanner, and FileNotFoundException

public class WordSearch{
    private char[][]data;
    
    private Random randgen;
    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    
    private int seedNew;
    private char[][] solution;

    private String file;
    
    /**Initialize the grid to the size specified 
     *fill all of the positions with '_' (helps with printing the solution); fill in words, then random chars
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     *@param filename is the txtfiles to get words from 
     */
    public WordSearch(int rows, int cols, String filename){
	this(rows, cols, filename, new Random().nextInt());
    }


    public WordSearch(int rows, int cols, String filename, int seed){

	data = new char[rows][cols];
	file = fileName;
	randgen = new Random(seedNew);
	
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	
	seedNew = seed;
	solution = new char[rows][cols];
	
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = '_'; // initialize with empty "_" 
	    }
	}
	try{
	    Scanner in = new Scanner(new File(filename)); // 11/9/17
	    while(in.hasNext()){
		wordsToAdd.add(in.next());
	    }
	} catch (FileNotFoundException e){   //if file is not found, return an error
    	    System.out.println("File " + filename +  " is not found.");
	}
	addAllWords(filename);
	for (int x = 0; x <data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		solution[x][y] = data[x][y];
	    }
	}

    }

    public int getSeed(){
	return seedNew;
    }

    public String getSolution(){
	String ans = "";
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		ans += solution[x][y] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    /**Set all values to '_'*/
    private void clear(){
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = '_';   //reset
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String ans = "";
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		ans += data[x][y] + " ";
	    }
	    ans += "\n";
	}
	ans += "Find: " + (wordsAdded.toString()).substring(1,(wordsAdded.toString()).length() - 1);
	ans += "\nSeed: " + getSeed();
	return ans;
    }

    private boolean addWord(int row, int col, String word,  int xcor, int ycor){
	word = word.toUpperCase(); //all upper case
	if (xcor == 0 && ycor == 0){
	    return false;
	}
        try{
	    for (int x = 0; x < word.length(); x++){
		if (data[row - x * ycor][col + x * xcor] != '_' &&  data[row - x * ycor][col + x * xcor] != word.charAt(x)){
		    return false;
		}
	    }
	    for (int x = 0; x < word.length(); x++){
		data[row - x * ycor][col + x * xcor] = word.charAt(x);
	    }
	    
	    wordsAdded.add(word);
	    wordsToAdd.remove(word);
	    return true;
	} catch(ArrayIndexOutOfBoundsException a){
	    return false;
	
	}
    }

    public boolean randomize(){
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		if (data[x][y] == '_'){
		    int num = (int)(((Math.random() + 0.04) * 100) / 4 + 65);
		    data[x][y] = (char)(num);
		}
	    }
	}
	return true;
    }
   
        
    private boolean addAllWords(String filename){
	int len = wordsToAdd.size() * 900;
	for (int i = 0; i < len; i++){	
	    if (wordsToAdd.size() == 0){
		return true;
	    }
	    int x = randgen.nextInt(3) - 1,
		y = randgen.nextInt(3) - 1,
		num = randgen.nextInt(wordsToAdd.size()),
		row = randgen.nextInt(data.length),
		col = randgen.nextInt(data[0].length);
	    String wor = wordsToAdd.get(num);
	    addWord(row, col, wor, x, y);
	    wordsToAdd.remove(wor);
	}
	return true;
    }

    public static void main(String[] args){
	try {
	    int row = Integer.parseInt(args[0]),
		col = Integer.parseInt(args[1]);
	    if (row == 0 || col == 0 || !(args[2].substring(args[2].length() - 4).equals(".txt"))){
		throw new ArrayIndexOutOfBoundsException();
	    }
	    if (args.length > 3){
		int seed = Integer.parseInt(args[3]);
		WordSearch ws = new WordSearch(row, col, args[2], seed);
		if (args.length == 5 && args[4].equals("key")){
		    System.out.println(ws);
		}
		else{
		    ws.randomize();
		    System.out.println(ws);
		}
	    }
	    else{
		WordSearch ws = new WordSearch(row, col, args[2]);
		ws.randomize();
		System.out.println(ws);
	    }
	} catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("Wrong Format. Please format the WordSearch as follows: \n java WordSearch <row> <col> <filename> <seed> key");
	    System.out.println("<row>: the number of rows");
	    System.out.println("<col>: the number of columns");
    	    System.out.println("<filename>: the name of the file containing the words");
	    System.out.println("<seed>: the seed");
	    System.out.println("key: type key to receive the solution");
	}
    }

}
