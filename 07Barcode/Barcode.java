public class Barcode implements Comparable<Barcode>{
    private static String[] dictionary = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    private String zip;

    //Try&Catch + Throwing exceptions
    public Barcode(String zip){
	//Not right length
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
        try {
	    int s;
	    s = Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	this.zip = zip;
    }

    public String getZip(){
	return zip;
    }

    public String getCode(){
	String code = "";
	for (int i = 0; i < zip.length(); i++){
	    code += dictionary[Integer.parseInt(zip.substring(i, i+1))];
	}
	code += numberToBar("" + checksum(zip));
	
	return "|" +  code + "|";

    }

    public String toString(){
	return getCode() + " (" + getZip() + ")" ;
    }

	
    public int compareTo(Barcode other){
	return this.getZip().compareTo(other.getZip());
    }

    public Boolean equals(Barcode other){
	return compareTo(other) == 0;
    }

    public static int checksum(String zip){
	int sum = 0;
	for (int i = 0; i < zip.length(); i++){
	    sum += Integer.parseInt(zip.substring(i, i+1));
	}
	return sum % 10 ;
    }

    public static String toCode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
        try {
	    int s;
	    s = Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	String code = "";
	for (int i = 0; i < zip.length(); i++){
	    code += numberToBar(zip.substring(i, i+1));
	}
	code += numToBar("" + checksum(zip));
	return "|" +  code  + "|";
    }

    public static String toZip(String code){
	if (code.length() != 32) {
	    throw new IllegalArgumentException();
	}

	if (code.charAt(0)!= '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException();
	}
	    
	String zip = "";
	String num = "";
	for (int i = 1; i < code.length()-5; i= i+5){
	    num = barToNumber(code.substring(i, i+5));
	    if (num.equals("-1")){
		throw new IllegalArgumentException();
	    }
	    zip += num;
	}

	if (checksum(zip.substring(0,5)) != Integer.parseInt(zip.substring(5))){
	    throw new IllegalArgumentException();
	}
	
	
	return zip.substring(0,5);
    }

    public static String numberToBar(String num){
	return dictionary[Integer.parseInt(num)];
    }

    //Arrays.asList() returns a List reference of inner class object defined within arrays
    public static String barToNumber(String bar){
	return "" + java.util.Arrays.asList(dictionary).indexOf(bar);

    }
}
