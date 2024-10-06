/*
This program implements a binary search algorithm in Java to search for an element in a sorted array.
It first prompts the user to input the size of the array and the array elements.
After collecting the elements, the user is asked to input a key (element to search for).
The program then performs a binary search by calling the `Search` method.
The search is done by comparing the middle element of the array with the key:
- If the middle element matches the key, it prints the index.
- If the middle element is smaller, it narrows the search to the right half.
- If the middle element is larger, it searches the left half.
If the element is found, the index is printed; otherwise, a message is displayed indicating the element is not present.
*/
import java.util.*;
public class BinarySearch
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the Array Size :");
        int i,n=obj.nextInt(),r=n-1,l=0;
        int ar[]=new int[n];
        System.out.println("Enter the Array Elements :");
        for(i=0;i<n;i++)
        {
            System.out.println("Enter the element "+(i+1));
            ar[i]=obj.nextInt();
        }
        System.out.println("Enter the element to search :");
        n=obj.nextInt();
        Search(ar,l,r,n);
    }
    static void Search(int ar[],int l,int r,int key)
    {
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(ar[mid]==key)
            {
                System.out.println("Element is present in the index "+(mid+1));
                return;
            }
            else if(ar[mid]<key)
                l=mid+1;
            else
                r=mid-1;
        }
        System.out.println("Element not present in the list...");
    }
}