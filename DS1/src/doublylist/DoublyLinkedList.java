package doublylist;

import java.util.Scanner;

/**
 * Class name-DoublyLinkedList
 * 
 * @version 1.0
 * @author Saloni Khandelwal
 */

/*
 * Class name-Node
 * This class creates node for the list.
 */
class Node {
	Node previous;						//Points to the previous node in the list
	int data;						//Stores the value of node
	Node next;						//Points to the next node in the list
	public Node(int element) {
		previous = null;
		data = element;
		next = null;
	}
}
public class DoublyLinkedList {
	Node head = null;							//Points to the first node in the Linked List.
	/**
	 * Below function inserts node in the Linked list.
	 * @param element
	 */
	public void insertion(int element) {
		Node node = new Node(element);
		if( head == null ) {
			head = node;
		}
		else {
			Node checker = head;
			while ( checker.next != null ) {
				checker = checker.next;
			}
			checker.next = node;
			node.previous = checker;
		}
		display();
	}
	
	/**
	 * Below function inserts the particular element at specific location.
	 * @param element
	 * @param location
	 */
	public void insertAtLocation(int element, int location) {
		Node node = new Node(element);
		if ( location == 0) {
			node.next = head;
			head = node; 
		}
		else {
		Node checker, p = null;
		checker = head;
		int loc = 1;
		while ( checker != null ) {
			if ( loc == location){
				break;
			}
			else{
			p = checker;
			checker = checker.next;
			}
			loc++;
		}
			node.next = p.next;
			p.next = node;
		}	
		display();
	}
	
	/**
	 * Below function removes the particular element from the Linked list.
	 * @param element
	 */
	public void removeElement (int element) {
		if ( head == null) {
			System.out.println("List is empty");
		}
		else if ( head.data == element) {
			head = head.next;
		}
		else {
			Node checker, current = null;
			checker = head;
			current = checker.next;
			while ( checker != null ) {
				if ( current.data == element) {
					checker.next = current.next;
				}
				checker = checker.next;
				current = current.next;
			}
		}
		display();
	}
	
	/**
	 * Below function removes the element on the basis of its location specified.
	 * @param location
	 */
	public void removeAtLocation (int location) {
		if ( head == null) {
			System.out.println("List is empty");
		}
		else if (location == 0) {
			head = head.next;
		}
		else{
			Node checker, current = null;
			checker = head;
			current = checker.next;
			int loc = 1;
			while ( checker != null) {
				if( loc == location) {
					checker.next = current.next;
				}
				checker = checker.next;
				current = current.next;
				loc++;
			}
		}
		display();
	}
	
	/**
	 * Below function retrieves element on basis of location.
	 */
	public void retrieveElement(int location) {
		if ( location == 0 ){
			System.out.println(head.data);
		}
		else {
			int loc = 1;
			Node checker = head;
			while ( loc != location) {
				checker = checker.next;
				loc++;
			}
			System.out.println(checker.data);
		}
	}
	/**
	 * Below function reverse the Linked list.
	 */
	public void reverseList() {
		Node p = null, checker = null,  current = head;
		while( current != null) {
			checker = current.next;
			current.next = p;
			p = current;
			current = checker;
		}
		head = p;
		display();
	}
	
	/**
	 * Below function displays elements in the list.
	 */
	public void display() {
		Node checker = head;
		while( checker != null) {
			System.out.println(checker.data);
			checker = checker.next;
		}
	}	
	
	public static void main(String args[]) {
		DoublyLinkedList doublyLikedListInstance = new DoublyLinkedList();
		Scanner scan = new Scanner(System.in);
		int element, location;
		do{
			int choice;
			System.out.println("***Menu***");
			System.out.println("1. Insert element ");
			System.out.println("2. Inserting element at particular location");
			System.out.println("3. Remove element");
			System.out.println("4. Removing element at particular location");
			System.out.println("5. Reverse list");
			System.out.println("6. Retrieve element on basis of location");
			choice = scan.nextInt();
			switch(choice) {
				case 1: System.out.println("Enter element");
						element = scan.nextInt();
						doublyLikedListInstance.insertion(element);
						break;
				case 2: System.out.println("Enter element");
						element = scan.nextInt();
						System.out.println("Enter location");
						location = scan.nextInt();
						doublyLikedListInstance.insertAtLocation(element, location);
						break;
				case 3:System.out.println("Enter element");
					   element = scan.nextInt();
					   doublyLikedListInstance.removeElement(element);
					   break;
				case 4:System.out.println("Enter location");
					   location = scan.nextInt();
					   doublyLikedListInstance.removeAtLocation(location);
					   break;
				case 5: doublyLikedListInstance.reverseList();
					   break;
				case 6:System.out.println("Enter location");
			           location = scan.nextInt();
				       doublyLikedListInstance.retrieveElement(location);
				       break;	   
				default:
					    System.out.println("Please enter a valid option");   	   
			}
		}while(true);	
	}
}