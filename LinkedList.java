/*
 * This program implements a singly linked list with basic operations:
 * - Create, display, and reverse the list.
 * - Insert and delete nodes at the beginning, end, or a specific position.
 * - Search for an element in the list.
 * The program is menu-driven and runs in a loop until the user chooses to exit.
 */
import java.util.*;
class LinkedList
{
    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            next=null;
        }
    }
    public static void main(String args[])
    {
        LinkedList obj= new LinkedList();
        Scanner sc=new Scanner(System.in);
        int a=0,ch,n;
        char c='i';
        while(a==0)
        {
            System.out.println("01. Create");
            System.out.println("02. Display");
            System.out.println("03. Insert at First");
            System.out.println("04. Insert at Last");
            System.out.println("05. Insert at particular position");
            System.out.println("06. Delete at First");
            System.out.println("07. Delete at Last");
            System.out.println("08. Delete at particular position");
            System.out.println("09. Search");
            System.out.println("10. Reverse");
            System.out.println("11. Exit");
            System.out.print("Enter Your choice :");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    n=Input(sc,c);
                    create(obj,n);
                    break;
                case 2:
                    Display(obj);
                    break;
                case 3:
                    n=Input(sc,c);
                    AddAtFirst(obj,n);
                    break;
                case 4:
                    n=Input(sc,c);
                    AddAtLast(obj,n);
                    break;
                case 5:
                    Add(obj,sc);
                    break;
                case 6:
                    DeleteAtFirst(obj,sc);
                    break;
                case 7:
                    DeleteAtLast(obj,sc);
                    break;
                case 8:
                    Delete(obj,sc);
                    break;
                case 9:
                    Search(obj,sc);     
                    break;
                case 10:
                    Reverse(obj);
                    break;
                case 11:
                    System.out.println("Exiting.....");
                    System.exit(0);
                    break;
                default:    
                    System.out.println("Enter the Choice from 1 to 8");
            }
        }
    }
    public static void create(LinkedList obj,int n)
    {
        Node newNode = new Node(n);
        if(obj.head==null)
        {
            obj.head=newNode;
            System.out.println("List Created with first node : "+n);
        }   
        else
        {
            System.out.println("List already created");           
        }
    }
    public static void AddAtFirst(LinkedList obj,int n)
    {

        if(obj.head==null)
        {
            System.out.println("List is empty please create a list");
            create(obj, n);
        }
        else
        {   
            Node newNode=new Node(n);
            newNode.next=obj.head;
            obj.head=newNode;
            System.out.println("Node inserted at first with data: "+n);
        }  
    }
    public static void AddAtLast(LinkedList obj,int n)
    {
        if(obj.head==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            Node newNode = new Node(n);
            Node temp=obj.head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newNode;
            System.out.println("Node inserted at last with data: "+n);
        }
    }
    public static void Add(LinkedList obj,Scanner sc)
    {
        if(obj.head==null)
            System.out.println("The List is empty");
        else
        {
            int ct=0;
            Node cnode=obj.head;
            while(cnode!=null)
            {   
                ct++;
                cnode=cnode.next;
            }
            System.out.println("Enter position from 1 to "+ct);
            int p=sc.nextInt();
            int ele=Input(sc,'i');
            cnode=obj.head;
            Node newNode =new Node(ele);
            ct=0;
            while(cnode!=null)
            {   
                ct++;
                if(ct==p)
                {
                    newNode.next=cnode.next;
                    cnode.next=newNode;
                }
                cnode=cnode.next;
            }            
            System.out.println(ele+" is added successfully in the position "+p);
            Display(obj);
        }
    }
    public static void DeleteAtFirst(LinkedList obj,Scanner sc)
    {
        if(obj.head==null)
            System.out.println("The List is empty");
        else
        {
            Node temp=obj.head;
            System.out.println("Successfully deleted : "+temp.data);
            temp=temp.next;
            obj.head=temp;
            Display(obj);
        }
    }
    public static void DeleteAtLast(LinkedList obj,Scanner sc)
    {
        if(obj.head==null)
            System.out.println("The List is empty");
        else
        {
            Node cnode=obj.head;
            Node preNode=null;
            while(cnode.next!=null)
            {
                preNode=cnode;
                cnode=cnode.next;
            }
            preNode.next=null;
            Display(obj);
        }

    }
    public static void Delete(LinkedList obj,Scanner sc)
    {
        if(obj.head==null)
            System.out.println("The List is empty");
        else
        {
            int ct=0;
            Node cnode=obj.head;
            while(cnode!=null)
            {   
                ct++;
                cnode=cnode.next;
            }
            System.out.println("Enter position from 1 to "+ct);
            ct=1;
            int p=sc.nextInt();
            cnode=obj.head;
            Node preNode=cnode;
            while(cnode!=null)
            {
                if(ct==p)
                {
                    preNode.next=cnode.next;
                }
                preNode=cnode;
                cnode=cnode.next;
                ct++;
            }
            Display(obj);
        }
    }
    public static void Display(LinkedList obj)
    {
        if(obj.head==null)
            System.out.println("The List is empty...");
        else
        {
            Node cnode=obj.head;
            System.out.print("The Node Elements are : ");
            while(cnode!=null)
            {
                System.out.print(cnode.data+" ");
                cnode=cnode.next;
            }
            System.out.println();
        }
    }
    public static void Search(LinkedList obj,Scanner sc)
    {
        if(obj.head==null)
        {
            System.out.println("The List is empty");
        }
        else
        {
            char c='s';
            int n=Input(sc,c);
            Node temp=obj.head;
            int ct=0;
            while(temp!=null)
            {
                if(temp.data==n)
                    ct=1;
                temp=temp.next;        
            }
            if(ct==1)
                System.out.println(n+" is present in the list");    
            else
                System.out.println(n+" is not present in the list");    
        }                
    }
    public static int Input(Scanner sc,char ch)
    {
        int i=0;
        if(ch=='i')
        {
            System.out.println("Enter the element to Add");
            i=sc.nextInt();
        }
        else if(ch=='s')
        {
            System.out.println("Enter the element to search :");
            i=sc.nextInt();
        }
        return i;
    }
    static void Reverse(LinkedList obj)
    {
        if(obj.head==null)
            System.out.println("The list is empty...");
        else
        {    
            Node next=null;
            Node prev=null;
            Node cnode=obj.head;
            while(cnode!=null)
            {
                next=cnode.next;
                cnode.next=prev;
                prev=cnode;
                cnode=next;
            }
            obj.head=prev;
            System.out.println("Reversed Successfully...");
            Display(obj);
        }    
    }
}   