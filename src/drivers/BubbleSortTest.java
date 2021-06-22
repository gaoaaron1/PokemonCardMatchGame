package drivers;

import java.util.Random;

import hw2.student.SLL;
import hw2.student.SLLNode;




public class BubbleSortTest {
  	
	
  public static <T extends Comparable<? super T>>
  
    void BubbleSort(SLL<T> list) {
    
	 //Check if list is empty then return nothing.
    if (list.isEmpty()) {
    	return;
    }
    else
    	
    {
    SLLNode<T> myNull = new SLLNode<>(null, list.head); 
    
    //Now we begin with the list size
    int listSize = list.getLength();	    // length size
    
    //System.out.println("            List Size is: " + listSize);
    
    for(int p = listSize-1; p > 0; p--) { 				      
    	
      SLLNode<T> current = list.head;		//current element 	
      SLLNode<T> previous = myNull;			//previous element     
 
      for (int q = 0; q < p; q++) 		// SORT ARRAY
      {	   	  
        if (current.info.compareTo(current.next.info) > 0) 
        {
         
          //System.out.println("Turn: " + q +"\n");
     
          SLLNode<T> tmp = current.next.next;
          previous.next = current.next;
          current.next.next = current;
          current.next = tmp;
          current = previous.next;
          
        }
        
        if (previous == myNull)
        {
          list.head = current;
        }
        
        if (current.next == null)
        {
          list.tail = current;
        }
        
        
        previous = previous.next;
        current = current.next;
        
        
     }
      return;
    }
    								}	
    
    		return;
  						}
  
  
/*  
  public static void main( String[] args ) {
	    Random rand = new Random();
	 
	      SLL<Integer> intList = new SLL<>();
	      for (int i = 0; i < 5; i++ ) { 
	    	  	intList.addToTail( rand.nextInt(100) );
	      }
	      
	    //Unsorted
	    System.out.println("Unsorted:");
	    intList.printAll();
	    
	    //Bubble Sort
	    SLLBubbleSort.BubbleSort(intList);
	    
	    //Sorted
	    System.out.println();
	    System.out.println("Sorted:");
	    intList.printAll();
	            
	    }    
  
  */