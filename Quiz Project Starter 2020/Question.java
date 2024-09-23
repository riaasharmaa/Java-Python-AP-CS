
/**
 * Write a description of class Question here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Question
{
    // This class requires 2 instance variables: one for the
    // question and one for the answer. Each is a String.
    private String question;
    private String answer;
    // Add a fully parameterized constructor here
    public Question (String q, String a)
    {
        question = q; 
        answer = a;
    }
    // Add a getQuestion accessor method here
    public String getQuestion()
    {
        return question;
    }
    // Add a getAnswer accessor method here
    public String getAnswer()
    {
        return answer;
    }
    // Add a setQuestion mutator method here
    public void setQuestion(String ques)
    {
        question = ques;
    }
    // Add a setAnswer mutator method here
    public void setAnswer(String ans)
    {
        answer = ans;
    }
}
