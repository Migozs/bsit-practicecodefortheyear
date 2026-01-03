package JavaLinkedList;

import java.util.Scanner;

class Node {
    int data; // data
    Node next; // address to the next node
}

class Linkedlist {
    Node head;

    // insert value at end
    void insertData(int data) {
        Node node = new Node(); // instantiation of class Node
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    // display list
    void display() {
        Node node = head;
        if (node == null) {
            System.out.println("List is empty.");
            return;
        }
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    // insert at start
    void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    // insert at index
    void insertAtIndex(int index, int data) {
        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (index == 0) {
            insertAtStart(data);
        } else {
            Node n = head;
            for (int x = 0; x < index - 1; x++) {
                if (n == null) {
                    System.out.println("Index out of bounds.");
                    return;
                }
                n = n.next;
            }
            if (n == null) {
                System.out.println("Index out of bounds.");
                return;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    // count elements
    int count() {
        int ctr = 0;
        Node node = head;
        while (node != null) {
            ctr++;
            node = node.next;
        }
        return ctr;
    }

    // delete by index
    void delete(int index) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node n = head;
        for (int x = 0; x < index - 1; x++) {
            if (n.next == null) {
                System.out.println("Index out of bounds.");
                return;
            }
            n = n.next;
        }

        if (n.next == null) {
            System.out.println("Index out of bounds.");
            return;
        }

        n.next = n.next.next;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("[1] - Insert at end");
            System.out.println("[2] - Insert at start");
            System.out.println("[3] - Display");
            System.out.println("[4] - Count");
            System.out.println("[5] - Insert at index");
            System.out.println("[6] - Delete at index");
            System.out.println("[0] - Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                ll.insertData(data);
            } else if (choice == 2) {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                ll.insertAtStart(data);
            } else if (choice == 3) {
                ll.display();
            } else if (choice == 4) {
                System.out.println("Count: " + ll.count());
            } else if (choice == 5) {
                System.out.print("Enter index: ");
                int index = sc.nextInt();
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                ll.insertAtIndex(index, data);
            } else if (choice == 6) {
                System.out.print("Enter index: ");
                int index = sc.nextInt();
                ll.delete(index);
            }
        } while (choice != 0);

        sc.close();
    }
}
