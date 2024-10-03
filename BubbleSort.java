/*    
*This Java program implements the Bubble Sort algorithm.
* It prompts the user to enter the array size and elements.
* Bubble Sort repeatedly compares adjacent elements and swaps them if needed, 
* ensuring the largest unsorted element moves to its correct position after each pass.
* The process repeats until the array is sorted in ascending order.
* Example:
* Input: size = 5, elements = 64 34 25 12 22
* Output: Sorted array: 12 22 25 34 64
* The program closes the Scanner after sorting.
*/
import java.util.*;
public class BubbleSort 
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int n,i,j;
        System.out.println("Enter the array size :");
        n=obj.nextInt();
        System.out.println("Enter the array elements.");
        int ar[]=new int[n];
        for(i=0;i<n;i++)
            ar[i]=obj.nextInt();
        System.out.print("Before Sorting : ");
        for(i=0;i<n;i++)
            System.out.print(ar[i]+" ");
        System.out.println();
        sort(ar,n);        
    }
    static void sort(int ar[],int n)
    {
        int temp;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1-i;j++)
            {
                if(ar[j]>ar[j+1])
                {
                    temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                }
            }
        }
        System.out.print("After Sorting : ");
        for(int i=0;i<n;i++)
            System.out.print(ar[i]+" ");
    }
}   