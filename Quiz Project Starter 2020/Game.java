
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    public static void main (String[] args)
    {
        //create a new Trivia object
        Trivia qs = new Trivia();
        // Create 3 Question objects. You should use polymorphism to create
        // one Question, one MCQuestion and one TFQuestion.
        Question q1 = new Question("Whats 9 + 10?", "21");
        Question q2 = new MCQuestion("What class do I have first period?", "Computer Science", 
        "Math", "English", "Physics", "Computer Science");
        Question q3 = new TFQuestion("I have a younger brother", "true");
        // add your questions to the list (in the Trivia object)
        qs.addQuestion(q1);
        qs.addQuestion(q2);
        qs.addQuestion(q3);
        // play the game
        qs.play();
        //use downcasting to call the setOptions method for your MCQuestion
        ((MCQuestion)q2).setOptions("Computer Science", "Band", 
        "Digital Electronics", "Spanish");
        //use downcasting to call the setAnswer method for your TFQuestion
        // set the answer to something OTHER THAN "true" or "false". Print
        // out the answer to the TFQuestion and make sure it did NOT
        // change
        ((TFQuestion)q3).setAnswer("Affirmative");
        // again, use downcasing to call the setAnswer method of the TFQuestion
        // This time change the answer to the opposite value as originally used
        // above.  
        ((TFQuestion)q3).setAnswer("false");
        //play the game again and confirm both the TFQuestion and MCQuestion
        //objects updated correctly.
        qs.play();
        
        
    }
}
