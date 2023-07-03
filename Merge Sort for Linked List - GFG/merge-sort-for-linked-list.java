//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null){
            return head;
        }
        
        Node slow = head;
        Node fast = head;
        Node temp = null;
        
        while(fast!=null && fast.next!=null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
       Node head1 =  mergeSort(head);
       Node head2 =  mergeSort(slow);
        
       return mergeList(head1,head2);
    }
    
    static Node mergeList(Node l1, Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.data>l2.data){
            Node tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        Node res = l1;
        
        while(l1!=null && l2!=null){
            Node temp = null;
            while(l1!=null && l1.data<=l2.data){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
          
          // swap l1 and l2
            Node tmp = l1;
            l1 = l2;
            l2 = tmp;
            
        }
        return res;
    }
}


