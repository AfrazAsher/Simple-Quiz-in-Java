/*
        Project name : Quiz Application
		
        Name : Afraz Asher Asrar
		
        Roll no: 303-BSCS-2019 (Section E-1)

        Description: This class acts as an interface class between Quiz(Class) and Main(Class).

        Used classes :  I have only used Quiz(class) in this class.
 */
package Controller;
public class Question 
{
    public String question;
    public String answer;

    public Question(String question, String answer) 
	{
        this.question = question;
        this.answer = answer;
    }

}