
/**
 * Write a description of class MCQuestion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//MCQuestion is-a Question
public class MCQuestion extends Question
{
    //This type of question requires 4 answer options in addition
    // to the standard question and answer variables.
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    /** constructor */
    public MCQuestion(String que, String ans, String a, String b, String c, String d)
    {
        super(que, ans);
        optionA = a;
        optionB = b;
        optionC = c;
        optionD = d;
    }

    /**
     * Name: setOptions
     * @param String a: answer option A
     * @param String b: answer option B
     * @param String c: answer option C
     * @param String d: answer option D
     * @ return: none
     * Operation: update the answer options for this question
     */
    public void setOptions(String A, String B, String C, String D)
    {
        optionA = A;
        optionB = B;
        optionC = C;
        optionD = D;
    }

    /**
     * Name: getQuestion
     * @param: none
     * @return: String representing the question plus
     * the answer options appended to the end as shown here:
     *    Question Text
     *    A. choice A
     *    B. choice B
     *    C. choice C
     *    D. choice D
     *    Enter Choice: 
     */
    public String getQuestion()
    {
        return super.getQuestion() + "\nA. " + optionA + "\nB. " + optionB 
        + "\nC. " + optionC + "\nD. " + optionD + "\nEnter Choice: ";
    }
}


