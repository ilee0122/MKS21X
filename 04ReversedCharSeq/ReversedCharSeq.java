public class ReversedCharSequence{
    private String str;

    public ReversedCharSequence(String string) {
	String temp = "";
	for (int i = string.length() - 1; i >= 0; i--){
	    temp += string.charAt(i);
	}

        str = temp;
    }

    public char charAt(int index){
	return str.charAt(index);
    }

    public int length(){
	return str.length();
    }

    public String toString(){
	//already a string
	return str;
    }

    public ReversedCharSequence subSequence(int start, int end){
	String temp = "";
	for (int i = end - 1; i >= start; i--){
	    temp += str.charAt(i);	    
	}

	
	ReversedCharSequence sub = new  ReversedCharSequence(temp);
	return sub;

    }
}
