/*
        Project name : Quiz Application
		
        Name : Afraz Asher Asrar
		
        Roll no: 303-BSCS-2019 (Section E-1)

        Description: The main function of this class is to see, if the user is entering the correct answer and 
		also couct the score and then send it to Score(Class).

        Used classes : I have used User(class), Question(class) and Score(class) in this class.
 */
package Controller;
import java.util.Scanner;

public class Quiz 
{
    protected Score s;
    protected Question[] questions;

    public Quiz(Question[] questions, User u) 
	{
        this.questions = questions;
        s = new Score(u);

    }

    public void takeTest() 
	{
        Scanner keyboardInput = new Scanner(System.in);
        for (int i = 0; i < questions.length;) 
		{
            System.out.println(questions[i].question);
            String answer = keyboardInput.nextLine();
            if (!answer.equals("a"))// a
                if (!answer.equals("b"))
                    if (!answer.equals("c"))
                        if (!answer.equals("d")) 
						{
                            System.out.println("Inavlid input!");
                            continue;
                        }

            if (answer.equals(questions[i].answer)) 
			{
                s.score_inc();
            }
            i++;
        }
        s.save();
        s.display();
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