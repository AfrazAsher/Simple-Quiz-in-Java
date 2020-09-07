/*
        Project name : Quiz Application
		
        Name : Afraz Asher Asrar
		
        Roll no: 303-BSCS-2019 (Section E-1)

        Description: The main function is this class is to save the score in the database and also to show it in the end of the quiz.
		
        Used classes : I have used User(class) and Quiz(class) in this class.

 */
package Controller;
import java.io.*;
import java.time.LocalDateTime;

public class Score 
{
  public int score;
  public User u;
  public LocalDateTime Time;

  public Score(User u2) 
  {

    this.u = u2;
    this.score = 0;
    Time = LocalDateTime.now();
  }

  public void score_inc() 
  {
    score++;
  }

  public void display() 
  {
    System.out.println("First Name: " + u.getFirstName() + "\n" + "Last Name: " + u.getLastName() + "\n" + "Score: " + score + "\n");
    System.out.println("Press enter to continue...");
    try 
	{
      System.in.read();
    } catch (Exception e) 
	{
      e.printStackTrace();
    }
  }

  public void save() 
  {
    try 
	{
      File save = new File("database/Score.txt");
      save.createNewFile();
      FileWriter write = new FileWriter("database/Score.txt", true);
      write.write(u.getUserName() + ";" + score + ";" + Time + "\n");
      write.close();
    } catch (IOException exl) {
    }
  }

  public static void Scorelist() 
  {
    try 
	{

      String username;
      String sc;
      String time;
      int index;

      // Using file pointer creating the file.
      File file = new File("database/Score.txt");

      if (!file.exists()) 
	  {

        // Create a new file if not exists.
        file.createNewFile();
        return;
      }
      System.out.println("Username       Score       Time\n");

      // Opening file in reading and write mode.

      RandomAccessFile raf = new RandomAccessFile(file, "rw");

      // Traversing the file
      // getFilePointer() give the current offset
      // value from start of the file.
      while (raf.getFilePointer() < raf.length()) 
	  {

        // reading line from the file.
        String line = raf.readLine();

        // finding the position of ';'
        index = line.indexOf(';');

        // separating name and number.
        username = line.substring(0, index);
        String line2 = line.substring(index + 1);
        index = line2.indexOf(';');
        sc = line2.substring(0, index);
        time = line2.substring(index + 1);

        // Print the contact data
        System.out.println(username + "    " + sc + "    " + time + "\n");

      }
      raf.close();
    } catch (IOException ioe) {

      System.out.println(ioe);
    } catch (NumberFormatException nef) {

      System.out.println(nef);
    }
    System.out.println("Press enter to continue...");
    try 
	{
      System.in.read();
    } catch (Exception e) 
	{
      e.printStackTrace();
    }
  }

}