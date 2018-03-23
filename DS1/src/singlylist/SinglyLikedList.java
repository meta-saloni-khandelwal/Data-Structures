package singlylist;

import java.util.Scanner;

/**
 * Class name-SinglyLinkedList
 * 
 * @version 1.0
 * @author Saloni Khandelwal
 */

/*
 * Class name-Node
 * This class creates node for the list.
 */
class Node {
	int data;						//Stores the value of node
	Node next;						//Points to the next node in the list
	public Node(int element) {
		data = element;
		next = null;
	}
}
public class SinglyLikedList {
	Node head = null;								//Points to the first node in the Linked List.
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
			Node q = head;
			while ( q.next != null ) {
				q = q.next;
			}
			q.next = node;
		}
		display();
	}
	
	/**
	 * Below function inserts the particular element at specific location.
	 * @param element
	 * @param location
	 */
	public void insertAtLocation (int element, int location) {
		int loc = 1;
		Node node = new Node(element);
		if ( location == 0) {
			node.next = head;
			head = node;
		}
		else {
		Node q, prev = null;
		q = head;
		while ( q.next != null ) {
			if ( loc == location){
				break;
			}
			else{
			prev = q;
			q = q.next;
			}
			loc++;
		}
			node.next = prev.next;
			prev.next = node;
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
		Node q, current = null;
		q = head;
		current = q.next;
		while ( q != null ) {
			if ( current.data == element) {
				q.next = current.next;
			}
			q = q.next;
			current = current.next;
		}
		}
		display();
	}
	
	/**
	 * Below function removes the element on the basis of its location specified.
	 * @param location
	 */
	public void removeElementAtLocation (int location) {
		if ( head == null) {
			System.out.println("List is empty");
		}
		else if (location == 0) {
			head = head.next;
		}
		else{
		Node q, current = null;
		q = head;
		current = q.next;
		int loc = 1;
		while ( q != null) {
			if( loc == location) {
				q.next = current.next;
			}
			q = q.next;
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
			Node q = head;
			while ( loc != location) {
				q = q.next;
				loc++;
			}
			System.out.println(q.data);
		}
	}
	/**
	 * Below function reverse the Linked list.
	 */
	public void reverseList() {
		Node p = null, q = null,  current = head;
		while( current != null) {
			q = current.next;
			current.next = p;
			p = current;
			current = q;
		}
		head = p;
		display();
	}
	
	public void sortList(){
		int temp;
		Node q, p = null;
		q = head;
		while ( q != null ) {
			p = q.next;
			while ( p != null ) {
				if ( p.data > p.next.data ) {
					temp = p.data;
					p.data = p.next.data;
					p.next.data = temp;
				}
			p = p.next;
			}
			q = q.next;
		}
		display();
	}
	
	/**
	 * Below function displays elements in the list.
	 */
	public void display() {
		Node q = head;
		while( q != null) {
			System.out.println(q.data);
			q = q.next;
		}
	}
	public static void main(String args[]) {
		SinglyLikedList singlyLikedListInstance = new SinglyLikedList();
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
					singlyLikedListInstance.insertion(element);
					break;
			case 2: System.out.println("Enter element");
					element = scan.nextInt();
					System.out.println("Enter location");
					location = scan.nextInt();
					singlyLikedListInstance.insertAtLocation(element, location);
					break;
			case 3:System.out.println("Enter element");
				   element = scan.nextInt();
				   singlyLikedListInstance.removeElement(element);
				   break;
			case 4:System.out.println("Enter location");
				   location = scan.nextInt();
				   singlyLikedListInstance.removeElementAtLocation(location);
				   break;
			case 5:singlyLikedListInstance.reverseList();
				   break;
			case 6:System.out.println("Enter location");
			       location = scan.nextInt();
				   singlyLikedListInstance.retrieveElement(location);
				   break;
			default:
				System.out.println("Please enter a valid option");   	   
			}
		}while(true);
}
}
