

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TriviaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestForSubmit
{
    Question question1, question2, question3;
    Trivia t;
    /**
     * Default constructor for test class TriviaTest
     */
    public TestForSubmit()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
     question3 = new TFQuestion("Green?","false");
     question2 = new MCQuestion("How fast?","B", "17", "55", "99","165");
     question1 = new Question("How many?", "5");
     t = new Trivia();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void CheckGetQuestion()
    {
        //Check Question
        assertEquals("How many?", question1.getQuestion());
        
        //Check MCQuestion
        String testStr = question2.getQuestion().toLowerCase();
        testStr = testStr.replaceAll(" ", "").replaceAll("\t","").replaceAll("\n","");
        assertTrue(testStr.contains("howfast?"));
        assertTrue(testStr.contains("enterchoice"));
        assertTrue(testStr.contains("a.17"));
        assertTrue(testStr.contains("b.55"));
        assertTrue(testStr.contains("c.99"));
        assertTrue(testStr.contains("d.165"));
        
        //Check TF Question
        testStr = question3.getQuestion().toLowerCase();
        testStr = testStr.replaceAll(" ", "").replaceAll("\t","").replaceAll("\n","");
        assertTrue(testStr.contains("trueorfalse"));
        assertTrue(testStr.contains("green?"));
    }
    
    @Test
    public void CheckGetAnswer()
    {
        assertEquals("5", question1.getAnswer());   
        assertEquals("b", question2.getAnswer().toLowerCase());
        assertEquals("false", question3.getAnswer().toLowerCase());
    }
    
    @Test
    public void CheckSetQuestion()
    {
        //change the questions
        question1.setQuestion("who?");
        question2.setQuestion("why?");
        question3.setQuestion("where?");
        
        //check Question
        assertEquals("who?", question1.getQuestion());
        
        //check MCQuestion
        String testStr = question2.getQuestion().toLowerCase();
        testStr = testStr.replaceAll(" ", "").replaceAll("\t","").replaceAll("\n","");
        assertTrue(testStr.contains("why?"));
        assertTrue(testStr.contains("enterchoice"));
        assertTrue(testStr.contains("a.17"));
        assertTrue(testStr.contains("b.55"));
        assertTrue(testStr.contains("c.99"));
        assertTrue(testStr.contains("d.165"));
        
        //Check TFQuestion
        testStr = question3.getQuestion().toLowerCase();
        testStr = testStr.replaceAll(" ", "").replaceAll("\t","").replaceAll("\n","");
        assertTrue(testStr.contains("trueorfalse"));
        assertTrue(testStr.contains("where?"));
    }
    
    @Test
    public void CheckSetAnswer()
    {
        //Check Question
        question1.setAnswer("4");
        assertEquals("4", question1.getAnswer());
        
        //Check MCQuestion
        question2.setAnswer("A");
        assertEquals("A", question2.getAnswer());
        
        //Check TFQuestion
        question3.setAnswer("yellow");   
        assertEquals("false", question3.getAnswer().toLowerCase()); //Should NOT change to yellow
        question3.setAnswer("true");
        assertEquals("true", question3.getAnswer().toLowerCase());  //Should change to true
    }
    @Test
    public void CheckSetOptions()
    {
        // Check orignal values
        String testStr = question2.getQuestion().toLowerCase();
        testStr = testStr.replaceAll(" ", "").replaceAll("\t","").replaceAll("\n","");
        assertTrue(testStr.contains("howfast?"));
        assertTrue(testStr.contains("enterchoice"));
        assertTrue(testStr.contains("a.17"));
        assertTrue(testStr.contains("b.55"));
        assertTrue(testStr.contains("c.99"));
        assertTrue(testStr.contains("d.165"));
        
        //Change the options
        ((MCQuestion)question2).setOptions("1", "2", "3", "4");
        
        //check the new values
        testStr = question2.getQuestion().toLowerCase();
        testStr = testStr.replaceAll(" ", "").replaceAll("\t","").replaceAll("\n","");
        assertTrue(testStr.contains("howfast?"));
        assertTrue(testStr.contains("enterchoice"));
        assertTrue(testStr.contains("a.1"));
        assertTrue(testStr.contains("b.2"));
        assertTrue(testStr.contains("c.3"));
        assertTrue(testStr.contains("d.4"));
    }
    
    
}
