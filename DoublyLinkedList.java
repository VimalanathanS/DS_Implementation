/*
 * This program implements a doubly linked list with the following operations:
 * - Insert a node at the beginning, end, or after a specific node.
 * - Delete a node from the beginning, end, or a specific node.
 * - Traverse the list in forward or backward directions.
 * - Search for an element in the list.
 * - Update an element in the list.
 * The program is menu-driven and continues until the user selects the "Exit" option.
 */
import java.util.*;
public class DoublyLinkedList
{

    Node head;
    static class Node
    {
        Node prev;
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            prev=next=null;
        }
    }
    public static void main(String args[])
    {
        DoublyLinkedList obj=new DoublyLinkedList();
        Scanner sc=new Scanner(System.in);
        int ch,a=0,n;
        char ip='i';
        System.out.println("Welcome to Doubly linked List");
        while(a==0)
        {
            System.out.println("1. Create a list");
            System.out.println("2. Insert at beginning");
            System.out.println("3. Insert at end");
            System.out.println("4. Insert after a node");
            System.out.println("5. Delete at beginning");
            System.out.println("6. Delete at end");
            System.out.println("7. Delete a specific node");
            System.out.println("8. Forward traversal");
            System.out.println("9. Backward traversal");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Exit");
            System.out.print("Enter your Choice:");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    if(obj.head==null)
                    {
                        n=Input(sc,ip);
                        Create(obj,n);
                    }
                    else
                        System.out.println("List already created...");                    
                    break;
                case 2:
                    if(obj.head==null)
                        System.out.println("The List is empty...");
                    else
                    {
                        n=Input(sc,'i');
                        AddAtFirst(obj,n);
                    }
                    break;
                case 3:
                    if(obj.head==null)
                       System.out.println("The List is empty...");
                    else
                    {
                        n=Input(sc,'i');
                        AddAtLast(obj,n);
                    }
                    break;
                case 4:
                    if(obj.head==null)
                        System.out.println("The List is empty...");                    
                    else
                        Add(obj,sc);
                    break;
                case 5:
                    if(obj.head==null)
                        System.out.println("The List is empty...");                    
                    else
                        DeleteAtFirst(obj);
                    break;
                case 6:
                    if(obj.head==null)
                       System.out.println("The List is empty...");                    
                    else
                        DeleteAtLast(obj);
                    break;
                case 7:
                    Delete(obj,sc);
                    break;
                case 8:
                    display(obj);
                    break;
                case 9:
                    backward(obj);
                    break;
                case 10:
                    if(obj.head==null)
                        System.out.println("The List is empty...");                                 
                    else
                    {    
                        n=Input(sc,'s');
                        search(obj,n);
                    }
                    break;
                case 11:
                    update(obj,sc);
                    break;
                case 12:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the option from 1 to 11");
            }

        }
    }
    static void update(DoublyLinkedList obj,Scanner sc)
    {
        if(obj.head!=null)
        {
            int p,ele,ct=0;
            Node cnode=obj.head;
            while(cnode!=null)
            {
                cnode=cnode.next;
                ct++;
            }
            System.out.println("Enter the position from 1 to "+ct+" :");
            p=sc.nextInt();
            ct=0;
            System.out.println("Enter the element to update :");
            ele=sc.nextInt();
            cnode=obj.head;
            while(cnode!=null)
            {
                ct++;
                if(ct==p)
                    cnode.data=ele;
                cnode=cnode.next;
            }
            System.out.println("Updated successfully...");
        }
        else
            System.out.println("The list is empty...");
    }
    static void search(DoublyLinkedList obj,int n)
    {
        int ct=0;
        Node cnode=obj.head;
        while(cnode!=null)
        {
            if(cnode.data==n)
                ct=1;
            cnode=cnode.next;
        }
        if(ct==0)   
            System.out.println(n+" is not present in the list");
        else
            System.out.println(n+" is present in the list");
    }
    static void Create(DoublyLinkedList obj,int d)
    {
        Node newNode= new Node(d);
        obj.head=newNode;
    }
    static int Input(Scanner sc,char ch)
    {
        int n=0;
        if(ch=='i')
        {
            System.out.print("Enter the Element :");
            n=sc.nextInt();
        }
        else if(ch=='s')
        {
            System.out.print("Enter the Element to search :");
            n=sc.nextInt();    
        }
        return n;
    }
    static void AddAtFirst(DoublyLinkedList obj,int data)
    {
        if(obj.head!=null)
        {   
            Node newNode=new Node(data);
            newNode.next=obj.head;
            obj.head.prev=newNode;
            obj.head=newNode;
            System.out.println(data+" is added successfully");
            display(obj);
        }
        else
            System.out.println("The List is empty...");
    }
    static void AddAtLast(DoublyLinkedList obj,int d)
    {
        Node newNode=new Node(d);
        Node cnode=obj.head;
        while(cnode.next!=null)
        {
            cnode=cnode.next;
        }
        cnode.next=newNode;
        newNode.prev=cnode;
        System.out.println(d+" is added successfully to the list..");
        display(obj);
    }
    static void Add(DoublyLinkedList obj,Scanner sc)
    {
        int ct=0;
        Node cnode=obj.head;
        while(cnode!=null)
        {   
            ct++;
            cnode=cnode.next;
        }
        System.out.println("Enter the position from 1 to "+ct);
        int pos=sc.nextInt();
        int n=Input(sc,'i');
        ct=0;
        Node newNode=new Node(n);
        cnode=obj.head;
        while(cnode!=null)
        {
            ct++;
            if(ct==pos)
            {
                newNode.next=cnode.next;
                newNode.prev=cnode;
                cnode.next.prev=newNode;
                cnode.next=newNode;
                cnode=cnode.next;
            }
            cnode=cnode.next;
        }
        System.out.println(n+" is inserted successfully");
    }
    static void DeleteAtFirst(DoublyLinkedList obj)
    {
        Node cnode=obj.head;
        cnode=cnode.next;
        System.out.println(obj.head.data+" is deleted successfully..");
        obj.head=cnode;
        display(obj);
    }
    static void DeleteAtLast(DoublyLinkedList obj)
    {
        Node cnode=obj.head;
        while(cnode.next!=null)
            cnode=cnode.next;
        cnode.prev.next=null;
        display(obj);
    }
    static void Delete(DoublyLinkedList obj,Scanner sc)
    {
        int ct=0;
        Node cnode=obj.head;
        while(cnode!=null)
        {
            cnode=cnode.next;   
            ct++;
        }   
        System.out.println("Enter the position from 1 to "+ct);
        int p=sc.nextInt(),l=ct;
        cnode=obj.head;
        ct=0;
        while(cnode!=null)
        {
            ct++;
            if(ct==p && p!=1)
            {
                cnode.prev.next=cnode.next;
                cnode.next.prev=cnode.prev;
            }
            else if(ct==p && p==1)
                DeleteAtFirst(obj);
            else if(ct==p && p==l)
                DeleteAtLast(obj);
            cnode=cnode.next;
        }
        display(obj);
    }
    static void display(DoublyLinkedList obj)
    {
        if(obj.head==null)
            System.out.println("The List is empty...");                    
        else
        {
            Node cnode=obj.head;
            System.out.println("The List Elements are : ");                    
            while(cnode!=null)
            {
                System.out.print(cnode.data+" ");
                cnode=cnode.next;
            }
            System.out.println();
        }
    }
    static void backward(DoublyLinkedList obj)
    {
        if(obj.head==null)
            System.out.println("The List is empty...");                    
        else
        {  
            Node cnode=obj.head;
            while(cnode.next!=null)
                cnode=cnode.next;
            while(cnode!=null)
            {
                System.out.print(cnode.data+" ");
                cnode=cnode.prev;
            }
            System.out.println();
        }
    }
}