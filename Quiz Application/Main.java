/*
        Project name : Quiz Application
		
        Name : Afraz Asher Asrar
		
        Roll no: 303-BSCS-2019 (Section E-1)

        Description: This is the main class, which runs the quiz app and can control all of the other classes.

        Used classes : I have used User(class), Quiz(class) and Score(class) in this class.
 */
import Controller.*;
import java.util.Scanner;

public class Main 
{

        public static void MainMenu() 
		{
                System.out.println("//////////////////////////////////////////");
				System.out.println("\n1.sign up" + "\n");
                System.out.println("2.Login in" + "\n");
                System.out.println("3. View Scores" + "\n");
                System.out.println("4.Exit" + "\n");
				System.out.println("///////Welcome to Afraz's Program/////////");
        }

        public static void main(String[] args) 
		{
                final String q1 = "A____ is drawn as an open oval?\n"
                                + "(a)Half Note \n(b)Quarter Note \n(c)Half Note \n(d)Whole Note";
                final String q2 = "A____ means to rest for an entire measure?\n"
                                + "(a)Whole Note \n(b)Whole Rest \n(c)Half Note \n(d)Half Rest";
                final String q3 = "Four___ equal the duration of one whole note?\n"
                                + "(a)Quarter Notes \n(b)Half Notes \n(c)Eighth Notes \n(d)Whole Notes";
                final String q4 = "A____ is equal to half of a whole rest and sits on the 3rd line?\n"
                                + "(a)Whole Rest \n(b)Half Rest \n(c)Quarter Rest \n(d)Eighth Rest";
                final String q5 = "What 7 letters of the alphabet are used in music?\n"
                                + "(a)A,B,C,D,E,F,G \n(b)E,G,B,D,F \n(c)F,A,C,E \n(d)L,M,N,O,P,Q,X";
                final String q6 = "Two____ equal the duration of one whole note?\n"
                                + "(a)Half Notes \n(b)Quarter Notes \n(c)Whole Notes \n(d)Whole Rest";
                final String q7 = "What clef is also known as the F Clef?\n" + "(a)Treble Clef \n(b)Bass Clef ";
                final String q8 = "How many beats does a half note take?\n" + "(a)Three \n(b)One \n(c)Four \n(d)Two";
                final String q9 = "When you look at a time siqnature, the top number shows how many__ are in a measure?\n"
                                + "(a)Rest \n(b)Notes \n(c)Beats \n(d)Flats";
                String q10 = "What note is a fifth interval up from C?" + "(a)D \n(b)E flat \n(c)G \n(d)F";
                Question[] questions = { new Question(q1, "d"), new Question(q2, "b"), new Question(q3, "a"),
                                new Question(q4, "b"), new Question(q5, "a"), new Question(q6, "a"),
                                new Question(q7, "b"), new Question(q8, "d"), new Question(q9, "c"),
                                new Question(q10, "c") };
                int x = 0;

                while (x != 4) 
				{
                        Main.MainMenu();

                        Scanner sc = new Scanner(System.in);
                        x = sc.nextInt();
                        switch (x) {
                                case 1:
                                        User.SignUp();
                                        break;
                                case 2:
                                        User u = new User();
                                        if (User.login(u)) 
										{
                                                System.out.println("Login successfull.....");
                                                Quiz newquiz = new Quiz(questions, u);
                                                newquiz.takeTest();

                                        } else
                                                System.out.println("User no found!");

                                        break;
                                case 3:
                                        Score.Scorelist();
                                        break;
                                case 4:
                                        sc.close();
                                        break;
                                default:
                                        break;
                        }

                }
                System.exit(0);
        }

}
