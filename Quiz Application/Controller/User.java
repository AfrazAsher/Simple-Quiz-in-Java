/*
        Project name : Quiz Application
		
        Name : Afraz Asher Asrar
		
        Roll no: 303-BSCS-2019 (Section E-1)

        Description: The main function of this class is to take data from the users and save it in a text file(DataBase). 
		There are two main methods of this class, first signup (in signup the user is giving his basic data to the app which is being saved in the database) 
		and second one is login (Which is loging in the users in the Ouiz by verification)  

        Used classes : This class is getting used between User(Class) and Main(Class).
 */
package Controller;
import java.io.*;
import java.util.Scanner;

public class User {
    private String FirstName;
    private String LastName;
    private String UserName;
    private String PassWord;
    private String Email;

    // Constructors 
    public User() 
	{
        FirstName = "";
        LastName = "";
        UserName = "";
        PassWord = "";
        Email = "";
    }

    public User(String FirstName, String LastName, String UserName, String PassWord, String Email) 
	{
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.Email = Email;
    }
    // Setter Methods
    public void setFirstName(String FirstName) 
	{
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) 
	{
        this.LastName = LastName;
    }

    public void setUserName(String UserName) 
	{
        this.UserName = UserName;
    }

    public void setPassWord(String PassWord) 
	{
        this.PassWord = PassWord;
    }

    public void setEmail(String Email) 
	{
        this.Email = Email;
    }
    // Getter Methods
    public String getFirstName() 
	{
        return FirstName;
    }

    public String getLastName() 
	{
        return LastName;
    }

    public String getUserName() 
	{
        return UserName;
    }

    public String getPassWord() 
	{
        return PassWord;
    }

    public String getEmail() 
	{
        return Email;
    }
    // This function verifies wether a given username exist on the file or not.
    public static boolean check_username(String u) 
	{   
        try 
		{
            String Line;
            String username;
            int index;
            File file = new File("database/Usernames.txt");

            if (!file.exists()) 
			{
                return false;
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            // Traversing the file
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) 
			{

                // reading line from the file.
                Line = raf.readLine();

                // finding the position of ';'
                index = Line.indexOf(';');
                username = Line.substring(0, index);
                if (u.equals(username)) 
				{
                    raf.close();
                    return true;
                }
            }
            raf.close();
        } catch (IOException e) 
		{
            return false;
        }
        return false;

    }
    // Stores the information of user in Data.txt
    public static void SignUp() 
	{   
        String FirstName;
        String LastName;
        String UserName = "";
        String PassWord;
        String ConfirmPassword;
        String Email;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter FirstName:");
        FirstName = in.nextLine();
        System.out.println("Enter LastName:");
        LastName = in.nextLine();
        System.out.println("Enter Username:");
        UserName = in.nextLine();
        while (check_username(UserName)) // checks wether the username is taken or not.
		{     
            System.out.println("Username Taken!\n" + "Enter Username again:");
            UserName = in.nextLine();
        }
        System.out.println("Enter Password:");
        PassWord = in.nextLine();
        System.out.println("Confirm Password:");
        ConfirmPassword = in.nextLine();
        boolean flag2 = false;
        if (!PassWord.equals(ConfirmPassword)) // checks if both passwords match or not.
		{   

            while (flag2 == false) 
			{

                System.out.println("Password does not match!");
                System.out.println("Enter Password again:");
                PassWord = in.next();
                System.out.println("Confirm Password:");
                ConfirmPassword = in.nextLine();
                if (PassWord.equals(ConfirmPassword)) 
				{
                    flag2 = true;
                }

            }
        }
        System.out.println("Enter Email:");
        Email = in.nextLine();

        try    // Writing Data on files.
		{                                  
            File data = new File("database/Data.txt");
            File Usernames = new File("database/Usernames.txt");
            Usernames.createNewFile();
            data.createNewFile();
            FileWriter write = new FileWriter("database/Data.txt", true);
            write.write(UserName + ";" + FirstName + ";" + LastName + ";" + Email + "\n");
            write.close();
            FileWriter write2 = new FileWriter("database/Usernames.txt", true);
            write2.write(UserName + ";" + PassWord + "\n");
            write2.close();

        } catch (IOException exl){
        }
        System.out.println("Sign up successfull.....");
        System.out.println("Press enter to continue...");
        
    }

    public static boolean login(User u) 
	{
        String UserName;
        String PassWord;
        String fn = "";
        String ln = "";
        String email = "";
        try 
		{

            String Line;
            String username;

            String pass;
            int index;
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Username:");
            UserName = in.next();
            System.out.println("Enter Password:");
            PassWord = in.next();
            File file = new File("database/Usernames.txt");
            File file2 = new File("database/Data.txt");

            if (!file.exists() || !file2.exists()) 
			{

                return false;
            }

            // Opening file in reading and write mode.

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            // Traversing the file
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) 
			{

                // reading line from the file.
                Line = raf.readLine();

                // finding the position of ';'
                index = Line.indexOf(';');

                // separating username and password.
                username = Line.substring(0, index);
                pass = Line.substring(index + 1);
                if (UserName.equals(username) && PassWord.equals(pass)) // check if Username and Password are correct.

				{   
                    RandomAccessFile raf2 = new RandomAccessFile(file2, "rw");
                    while (raf2.getFilePointer() < raf2.length()) // Reading Data from Data.txt to find the user.
					{       

                        raf.seek(0);
                        // reading line from the file.
                        Line = raf2.readLine();

                        // finding the position of ';'
                        index = Line.indexOf(';');
                        String line2 = Line.substring(index + 1);
                        index = line2.indexOf(';');
                        fn = line2.substring(0, index);

                        String line3 = line2.substring(index + 1);
                        index = line3.indexOf(';');
                        ln = line3.substring(0, index);

                        email = line3.substring(index + 1);

                    }
                    raf2.close();
                    raf.close();
                    u.setFirstName(fn);
                    u.setLastName(ln);
                    u.setUserName(UserName);
                    u.setPassWord(PassWord);
                    u.setEmail(email);
                    return true;
                } else
                    System.out.println("Username and password did not match");

            }

            raf.close();

        }

        catch (IOException ioe) 
		{

            System.out.println(ioe);
        } catch (NumberFormatException nef) 
		{

            System.out.println(nef);
        }
        return false;

    }
}
