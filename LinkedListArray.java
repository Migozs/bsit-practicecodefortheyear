package PracticeDSA;

import java.util.Scanner;
import java.util.Arrays;

// Node for a SINGLE Linked List
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Single Linked List Class
class SingleLinkedList {
    Node head;

    // Insert node at the end
    void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Convert list to array for easy sorting/extra operations
    int[] toArray(int size) {
        int[] arr = new int[size];
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.data;
            temp = temp.next;
        }
        return arr;
    }

    // Count even and odd numbers
    void countEvenOdd() {
        int even = 0, odd = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data % 2 == 0) even++;
            else odd++;
            temp = temp.next;
        }
        System.out.println("Even Numbers: " + even);
        System.out.println("Odd Numbers: " + odd);
    }

    // Find maximum and minimum
    void findMaxMin() {
        if (head == null) return;
        int max = head.data, min = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data > max) max = temp.data;
            if (temp.data < min) min = temp.data;
            temp = temp.next;
        }
        System.out.println("Maximum Number: " + max);
        System.out.println("Minimum Number: " + min);
    }

    // List prime numbers
    void listPrimes() {
        System.out.print("Prime Numbers: ");
        boolean found = false;
        Node temp = head;
        while (temp != null) {
            if (isPrime(temp.data)) {
                System.out.print(temp.data + " ");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.print("None");
        System.out.println();
    }

    // Helper for prime check
    boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Detect duplicates (using nested traversal)
    void findDuplicates() {
        System.out.println("Duplicate Numbers and Their Frequencies:");
        Node outer = head;
        boolean hasDuplicate = false;
        while (outer != null) {
            int count = 0;
            Node inner = head;
            while (inner != null) {
                if (inner.data == outer.data) count++;
                inner = inner.next;
            }
            if (count > 1 && !alreadyPrinted(outer)) {
                System.out.println(outer.data + " occurs " + count + " times");
                hasDuplicate = true;
            }
            outer = outer.next;
        }
        if (!hasDuplicate) System.out.println("No duplicates found.");
    }

    // Check if this duplicate was already printed
    boolean alreadyPrinted(Node current) {
        Node temp = head;
        while (temp != current) {
            if (temp.data == current.data) return true;
            temp = temp.next;
        }
        return false;
    }
}

public class LinkedListArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleLinkedList list = new SingleLinkedList();

        System.out.print("How many numbers to analyze? ");
        int size = sc.nextInt();

        // Insert numbers into the single linked list
        System.out.println("=== INPUT NUMBERS ===");
        for (int i = 1; i <= size; i++) {
            System.out.print("Enter number " + i + ": ");
            list.insert(sc.nextInt());
        }

        System.out.println("\n=== SINGLE LINKED LIST ANALYSIS ===");
        list.countEvenOdd();
        list.findMaxMin();
        list.listPrimes();
        list.findDuplicates();

        // Use Array for sorting (but data still comes from the Linked List)
        int[] arr = list.toArray(size);
        Arrays.sort(arr);
        System.out.print("Ascending Order: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
        System.out.print("Descending Order: ");
        for (int i = arr.length - 1; i >= 0; i--) System.out.print(arr[i] + " ");
        System.out.println();

        sc.close();
    }
}
