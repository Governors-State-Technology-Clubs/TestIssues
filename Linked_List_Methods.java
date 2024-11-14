/*
 * This program is a compilation of various methods of differing functionalities that are 
 * applied to link lists in java. 
 */

public class Linked_List_Methods {

    // ListNode class as a static nested class so we do not have to create a Linked_List_Methods object first
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) { //constructor for list node
            this.data = data;
            this.next = null;
        }

        public ListNode(int data, ListNode next) { //overloaded constructor for list node
            this.data = data;
            this.next = next;
        }
    }

    // LinkedIntList class as a static nested class
    static class LinkedIntList {
        private ListNode front;

        public void add(int value) {
            if (front == null) { 
                front = new ListNode(value);  //if the theres nothing in the list, add a node and assign it passed argument
            } else {
                ListNode current = front; // otherwise, create a pointer that points to front of list
                while (current.next != null) { //while its not empty, traverse
                    current = current.next;
                }
                current.next = new ListNode(value); //insert node  at end of list and store argument
            }
        }

        public int size() {
            int count = 0;
            ListNode current = front; //Traverses list and incrememnts counter
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        public int get(int index) { // Takes index as an argument
            ListNode current = front;
            for (int i = 0; i < index; i++) { // traverse up to selected index
                if (current == null) throw new IndexOutOfBoundsException();
                current = current.next; 
            }
            return current.data; //return whats at that index 
        }

        public int indexOf(int value) {
            int index = 0;
            ListNode current = front;
            while (current != null) {
                if (current.data == value) return index; // if the value is found at the first index, return it
                current = current.next; // otherwise, go to the next node check again, do this until you've found a matching value
                index++;
            }
            return -1;
        }

        public void add(int value, int index) { // take value and index as argumnet
            if (index == 0) { //if the index is the first index
                front = new ListNode(value, front); // create the first node and construct it with value
            } else {
                ListNode current = front; // Otherwise, point to the front, iterate till you reach desired index
                for (int i = 0; i < index - 1; i++) {
                    if (current == null) throw new IndexOutOfBoundsException();
                    current = current.next;
                }
                current.next = new ListNode(value, current.next); //insert new node and put value, set pointer to next node
            }
        }

        public void remove_at_index(int index) { // take int as argumnet
            if (index == 0) { 
                front = front.next; // if they want to remove first index, just shift it one
            } else {
                ListNode current = front;
                for (int i = 0; i < index - 1; i++) { // Otherwise, iterate to desired index
                    if (current == null) throw new IndexOutOfBoundsException();
                    current = current.next;
                }
                if (current.next != null) current.next = current.next.next; // Once you've gotten to desired index, use the pointer to skip a node
            }
        }

        public void set(int value, int index) { //take a value and an index to place it in
            ListNode current = front;
            for (int i = 0; i < index; i++) { //iterate until you get to desired index
                if (current == null) throw new IndexOutOfBoundsException();
                current = current.next;
            }
            current.data = value; // change the data as desired
        }

        public int min() {
            if (front == null) throw new IllegalStateException("List is empty"); 
            int minValue = front.data; // min value is first data
            ListNode current = front.next; //current is 2nd node now
            while (current != null) { //while its not empty
                if (current.data < minValue) minValue = current.data; //if the data in this node is less than previous node, update minValue
                current = current.next;
            }
            return minValue;
        }

        public void swap(int index1, int index2) { // Take two indexs
            if (index1 == index2) return; // don't swap the same index
            ListNode node1 = front, node2 = front; // both temp nodes point to front node
            for (int i = 0; i < index1; i++) node1 = node1.next; //traverse to next node until you reach desired index
            for (int i = 0; i < index2; i++) node2 = node2.next;
            int temp = node1.data;
            node1.data = node2.data; //use general swap method on .data for each node
            node2.data = temp;
        }

        public int lastIndexOf(int value) {
            int index = -1, currentIndex = 0; 
            ListNode current = front;
            while (current != null) {
                if (current.data == value) index = currentIndex; // if you find the matching value at a node, update index which holds last index with target value in it
                current = current.next; 
                currentIndex++; // basically is a counter which helps keep track of which index we are at.
            }
            return index; // return last index value was found
        }

        public void removeAll(int value) {
            while (front != null && front.data == value) { // if the first node has the target value, chop it off
                front = front.next;
            }
            ListNode current = front;
            while (current != null && current.next != null) {
                if (current.next.data == value) { // if the next nodes data has a match
                    current.next = current.next.next; // use the pointer to skip it and cut it out of the link
                } else {
                    current = current.next; // otherwise, just go to the next one
                }
            }
        }

        public void print() {
            ListNode current = front;
            while (current != null) {
                System.out.print(current.data + " "); // traverse the list and print data
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedIntList l1 = new LinkedIntList(); // driver code 

        System.out.println("Adding elements: 1, 9, 5, 7");
        l1.add(1);
        l1.add(9);
        l1.add(5);
        l1.add(7);
        System.out.print("Current list: ");
        l1.print();

        System.out.println("\nCalling size():");
        System.out.println("Size of the list: " + l1.size());

        System.out.println("\nCalling get(2):");
        System.out.println("Element at index 2: " + l1.get(2));

        System.out.println("\nCalling indexOf(9):");
        System.out.println("First occurrence of 9: " + l1.indexOf(9));

        System.out.println("\nCalling add(3, 2):");
        l1.add(3, 2);
        System.out.print("List after adding 3 at index 2: ");
        l1.print();

        System.out.println("\nCalling remove_at_index(1):");
        l1.remove_at_index(1);
        System.out.print("List after removing element at index 1: ");
        l1.print();

        System.out.println("\nCalling set(10, 0):");
        l1.set(10, 0);
        System.out.print("List after setting index 0 to 10: ");
        l1.print();

        System.out.println("\nCalling min():");
        System.out.println("Minimum value in the list: " + l1.min());

        System.out.println("\nCalling swap(0, 2):");
        l1.swap(0, 2);
        System.out.print("List after swapping index 0 and index 2: ");
        l1.print();

        System.out.println("\nCalling lastIndexOf(3):");
        System.out.println("Last occurrence of 3: " + l1.lastIndexOf(3));

        System.out.println("\nAdding elements: 7, 3, 7");
        l1.add(7);
        l1.add(3);
        l1.add(7);
        System.out.print("Current list: ");
        l1.print();

        System.out.println("\nCalling removeAll(7):");
        l1.removeAll(7);
        System.out.print("List after removing all occurrences of 7: ");
        l1.print();
    }
}
