import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Trivia here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Trivia
{
    // This class contains an ArrayList of Question objects
    // and an integer for tracking the number of correct
    // answers given.
    private ArrayList <Question> question = new ArrayList <Question>();
    // Create the constructor for this class.
    public Trivia()
    {
        
    }
    /**
     * Name: addQuestion
     * @param: q - a Question object
     * @return: none
     * Operation: adds the provided question object to 
     * the end of the ArrayList questions.
     */
    public void addQuestion(Question q)
    {
        question.add(q);
    }
    /** 
     * Name: getAnswer
     * @param q: a Question object
     * @return : String representing the user supplied answer.
     * Operation: Prints out the question text from the 
     * given input Question object, takes input from the
     * user (use a Scanner and the .next() method), and 
     * returns the user entered value.
     */
    public String getAnswer(Question q)
    {
        System.out.println(q.getQuestion());
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        return answer;
    }
    /**
     * Name: checkAnswer
     * @param q: a Question object
     * @param a: String - the user's answer to the question
     * @return: boolean - True if the user's answer is 
     *          correct, False otherwise.
     * Operation: compares the user's answer to the answer
     * from the Question object. Returns True if they match
     */
    public boolean checkAnswer(Question q, String a)
    {
        if (a.equals(q.getAnswer()))
        {
            return true;
        }
        return false;
    }
    /**
     * Name: Play
     * @param: none
     * @return: none
     * Operation: For each Question, calls getAnswer to 
     * print the question and get user response, then
     * calls checkAnswer to validate user input.
     * Score is updated for correct answers and
     * a correct/incorrect message is printed after each
     * question. Once all questions have been asked, the
     * player's final score is printed.
     */
    public void play()
    {
        int count = 0;
        for (Question q : question)
        {
            if (checkAnswer(q,getAnswer(q)))
            {
                count++;
                System.out.println("You are correct");
            }
            else
            {
                System.out.println("You are incorrect");
            }
        }
        System.out.println(count);
    }
}
