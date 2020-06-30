import java.util.Scanner;
import java.io.File;
import java.nio.file.Files;

public class Database {

   final static String PASSWORD = "password";
   final static String DATABASE = "\\\\YOUSSEF\\Server";
   
   
   public static void main(String[] args){
   
      Scanner scan = new Scanner(System.in);
      System.out.println("This is your database.\n");

      checkPassword(scan);
      
      while(true) {
         wish();
         String s = scan.next();
         System.out.println();
         if(s.equals("1")) {
            open(scan);
         } else if(s.equals("2")) {
            store(scan);
         } else if(s.equals("0")) {
            System.out.println();
            break;
         } else {
            System.out.println("Wrong input. Repeat:");
         }
      }
      
      System.out.println("Thank you for using this database!");
   }
   
   public static void checkPassword(Scanner scan) {
      while(true) {
         System.out.print("What is your password? ");
         String s = scan.nextLine();
         if(s.equals(PASSWORD)) {
            break;
         } else {
            System.out.println("Wrong password. Repeat:");
         }
      }
      System.out.println();
   }
   
   public static void wish() {
      System.out.println("Options:");
      System.out.println("1. Retrieve file");
      System.out.println("2. Store file");
      System.out.println("0. Leave");
      System.out.print("What do you wish to do? ");
   }
   
   
   public static void open(Scanner scan) {
      System.out.print("\nWhat is the extension of the file (eg: txt) ? ");
      String ext = scan.next();
      System.out.print("\nWhat is the name of the file? ");
      String name = scan.next();
      String path = DATABASE + "\\" + name + "." + ext;
      try {
         File f = new File(path);
         System.out.println(path);
         System.out.println("Where do you want to output the file? ");
         System.out.println("Put the whole new address as shown below.");
         System.out.println("example: C:\\Users\\Youssef\\Desktop\\");
         System.out.print("New path: ");
         String newPath = scan.next() + name + "." + ext;
         File newFile = new File(newPath);
         Files.copy(f.toPath(), newFile.toPath());
         System.out.println("Done!");
      } catch (Exception e) {
         System.out.println("Error");
      }
      System.out.println(); 
   }
   
   public static void store(Scanner scan) {
      System.out.println("\nWhere is your file located? ");
      System.out.println("Put the whole file address as shown below.");
      System.out.println("example: C:\\Users\\Youssef\\Desktop\\FileName.extension");
      System.out.print("File path: ");
      String path = scan.next();
      try {
         File f = new File(path);
         String fileName = "";
         for(int i = path.length() - 1; i >= 0; i--) {
            if (path.charAt(i) == '\\') {
               fileName = path.substring(i);
               i = -1;
            }
         }
         System.out.println(fileName);
         File newFile = new File(DATABASE + fileName);
         System.out.println(DATABASE + fileName);
         Files.copy(f.toPath(), newFile.toPath());
         System.out.println("Done!");
     } catch(Exception e) {
         System.out.println("Error.");
     }
     System.out.println();    
   }
}