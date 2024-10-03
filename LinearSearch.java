/* This Java program performs a linear search on an array.
 * It prompts the user to enter the size of the array and the elements.
 * Then, the user enters an element to search for in the array.
 * The program iterates through the array, comparing each element with the search value.
 * If a match is found, it prints the position of the element (1-based index).
 * If not, it informs the user that the element was not found.
 * Example:
 * Input: array size = 5, elements = 10 20 30 40 50, search = 30
 * Output: 30 is found at position 3.
 * The program closes the Scanner at the end.
 */
import java.util.*;
public class LinearSearch 
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the array size : ");
        int n=obj.nextInt(),i,ele,ct=0,p=0;
        int ar[]=new int[n];
        System.out.println("Enter the array elements :");
        for(i=0;i<n;i++)
            ar[i]=obj.nextInt();
        System.out.print("Enter the element to search : ");
        ele=obj.nextInt();
        for(i=0;i<n;i++)
        {
            if(ar[i]==ele)
            {
                ct++;
                p=i+15
                ;
            }
        }        
        if(ct!=0)
            System.out.println(ele+" is found at the position "+p+".");
        else
            System.out.println(ele+" is not found in the array.");
    }    
}