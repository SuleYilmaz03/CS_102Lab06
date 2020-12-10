import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
public class Recursion
{
  public static void main(String [] args)
  {
     Scanner scan = new Scanner(System.in);
     String s = "";
     ArrayList<String> all = new ArrayList<String>();
     System.out.println(" Enter a word or sentence ");
     String length = scan.next();
     System.out.println("The lenght of sentence is " +  lenghtString(length));
     System.out.println(" Enter a word or sentence ");
     String vowel = scan.next();
     System.out.println(" The number of nonvowel letters in this sentence is " + nonVowel(vowel));
     System.out.println(" Enter a number to show binary numbers ");
     int binary = scan.nextInt();
     System.out.println(" The binary numbers for this number: " + binary(all,s,binary));
     System.out.println(" Enter the file name you want to find number of files in its directory");
     String file = scan.next();
     System.out.println( "Number of files = " + numberOfFiles(file));
   }
   public static int lenghtString(String s)
   {
    if(s.equals(""))
    return 0;
    else 
    return lenghtString(s.substring(1)) + 1;
   }
   public static int nonVowel(String s)
   { 
    if(s.length()== 1)
    {
     if(s.equals("a")|| s.equals("e")||s.equals("u") || s.equals("i")|| s.equals("o")||s.equals("A")|| s.equals("E")|| s.equals("U")||s.equals("O")||s.equals("I"))
       {
       return 0; 
       } 
     else 
    {
      return 1;
    }
    }
     else if (s.length()> 1)
     {
     if(s.substring(0,1).equals("a")|| s.substring(0,1).equals("e")||s.substring(0,1).equals("u") || s.substring(0,1).equals("i")|| s.substring(0,1).equals("o")||s.substring(0,1).equals("A")|| s.substring(0,1).equals("E")|| s.substring(0,1).equals("U")||s.substring(0,1).equals("O")||s.substring(0,1).equals("I"))
       {
       return nonVowel(s.substring(1));  
       }
      else
      {
        return nonVowel(s.substring(1))+1;
      } 
     }
    else{
      return 0;}
     }
   
  public static ArrayList<String> binary(ArrayList<String> list, String temp, int n) {
      
      //Basic Step
      if(n == 0) {
         list.add(temp);
      }
      //Genaral Step
      else {
         if(temp.isEmpty()) {
            binary(list, temp + "0", n - 1);
            binary(list, temp + "1", n - 1);
         }
         else if(temp.charAt(temp.length() - 1) == '0') {
            binary(list, temp + "0", n -1);
            binary(list, temp + "1", n -1);
         }
         else if(temp.charAt(temp.length() - 1) == '1') {
            binary(list, temp + "0", n -1);
         }
      }
      return list;
   }
   public static int numberOfFiles(String directory)
   {
     File file = new File(directory);
     File[] list = file.listFiles();
     int count = 0;
     for(int i = 0; i < list.length ; i++)
     {
       if(list[i].isDirectory())
       count += numberOfFiles( list[i].getPath() );
       if(list[i].isFile())
       count++;
     }
     return count;
   }

  
}