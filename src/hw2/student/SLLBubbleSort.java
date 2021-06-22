package hw2.student;

import java.util.Random;

public class SLLBubbleSort implements BubbleSortInterface {
  	
	
  public <T extends Comparable<? super T>> void BubbleSort(SLL<T> list) {
    
	 //Check if list is empty then return nothing.
    if (list.isEmpty()) {
    	return;
    }
    	
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
        
        previous = previous.next;
        
        if (current.next == null)
        {
          list.tail = current;
        }
       
        current = current.next;
        
        
     }
      
    }
    								}	
    
    
    		
  				return;		}
  
  
  

  public static void main( String[] args ) {
	    Random rand = new Random();
	 
	      SLL<Integer> arrayList = new SLL<>();
	      for (int i = 0; i < 5; i++ ) { 
	    	  	arrayList.addToTail( rand.nextInt(100) );
	      }
	      
	    //Unsorted
	    System.out.println("Unsorted:");
	    arrayList.printAll();
	    
	    //Bubble Sort
	    //SLLBubbleSort.BubbleSort(arrayList);
	    
	    //Sorted
	    System.out.println();
	    System.out.println("Sorted:");
	    arrayList.printAll();
	            
	    }    
  

  
  
  }
  
