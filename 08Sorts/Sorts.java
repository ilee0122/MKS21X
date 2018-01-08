import java.util.Arrays;
public class Sorts{

    public static boolean isSorted(int[]ary){
	for(int i = 0; i < ary.length-1; i++){
	    if (ary[i] > ary[i+1]){
		return false;
	    }
	}
	return true;
    }

    
    public static void bogoSort(int[]ary){
	while(!isSorted(ary)){
	    for (int i = 0; i < ary.length; i++){
		int temp = ary[i];
		int newSpot = (int)(Math.random()*ary.length);
		ary[i] = ary[newSpot];
		ary[newSpot] = temp;		    
	    }
	}
    }

    public static void selectionSort(int[] data){
      
	for (int i = 0; i < data.length; i++){
	    int next = data[i];
	    int index = i;
	    for (int j = i; j < data.length; j++){
		if (data[j] < next){
		    next = data[j];
		    index = j;
		}	      
	    }
	    data[index] = data[i];
	    data[i] = next;	  
	}
    }

    public static void insertionSort(int[] data){
	for (int i = 1; i < data.length; i++){
	    int temp = data[i]; 
	    int index = i; 
	    for (int j = i-1; j >= 0 && data[j]>temp; j--){
		data[j+1] = data[j]; 
		index = j;
	    }
	    data[index] = temp;
	}
    }

    public static void bubbleSort(int[] data){
	for (int i = 0; i < data.length; i++){
	    boolean swapped = false;
	    int max;
	    for (int j = 1; j < data.length - i; j++){
		if ( data[j-1] > data[j]){
		    max = data[j-1];
		    data[j-1] = data[j];
		    data[j] = max;
		    swapped = true;
		}

	    }
	    if (!swapped){
		i = data.length;
	    }
	}
    }
}
