

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TweetTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TweetTest
{
    /**
     * Default constructor for test class TweetTest
     */
    public TweetTest()
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
    public void getBody140char()
    {
        Tweet tweet1 = new Tweet("@UnnamedCSTeacherTwo Star Wars is WAY better than Star Trek @UnnamedCSTeacherThree @UnnamedCSTeacherFour #PLC #SEL #noideawhatimtalkingabout", "UnnamedCSTeacherOne");
        assertEquals("@UnnamedCSTeacherTwo Star Wars is WAY better than Star Trek @UnnamedCSTeacherThree @UnnamedCSTeacherFour #PLC #SEL #noideawhatimtalkingabout", tweet1.getBody());
    }
    @Test
    public void getHandle140char()
    {
        Tweet tweet1 = new Tweet("@UnnamedCSTeacherTwo Star Wars is WAY better than Star Trek @UnnamedCSTeacherThree @UnnamedCSTeacherFour #PLC #SEL #noideawhatimtalkingabout", "UnnamedCSTeacherOne");
        assertEquals("@UnnamedCSTeacherOne", tweet1.getHandle());
    }
    @Test
    public void getRecipients140char()
    {
        Tweet tweet1 = new Tweet("@UnnamedCSTeacherTwo Star Wars is WAY better than Star Trek @UnnamedCSTeacherThree @UnnamedCSTeacherFour #PLC #SEL #noideawhatimtalkingabout", "UnnamedCSTeacherOne");
        assertEquals("@UnnamedCSTeacherTwo\n@UnnamedCSTeacherThree\n@UnnamedCSTeacherFour\n", tweet1.getAllRecipients());
    }
    @Test
    public void getHashTags140char()
    {
        Tweet tweet1 = new Tweet("@UnnamedCSTeacherTwo Star Wars is WAY better than Star Trek @UnnamedCSTeacherThree @UnnamedCSTeacherFour #PLC #SEL #noideawhatimtalkingabout", "UnnamedCSTeacherOne");
        assertEquals("#PLC\n#SEL\n#noideawhatimtalkingabout\n", tweet1.getAllHashtags());
    }
    @Test
    public void toString140char()
    {
        Tweet tweet1 = new Tweet("@UnnamedCSTeacherTwo Star Wars is WAY better than Star Trek @UnnamedCSTeacherThree @UnnamedCSTeacherFour #PLC #SEL #noideawhatimtalkingabout", "UnnamedCSTeacherOne");
        assertEquals("@UnnamedCSTeacherOne: @UnnamedCSTeacherTwo Star Wars is WAY better than Star Trek @UnnamedCSTeacherThree @UnnamedCSTeacherFour #PLC #SEL #noideawhatimtalkingabout", tweet1.toString());
    }
    @Test
    public void getRecipientsNone()
    {
        Tweet tweet1 = new Tweet("Superman does it again", "TheRealLoisLane");
        assertEquals("", tweet1.getAllRecipients());
    }
    @Test
    public void getHashTagsNone()
    {
        Tweet tweet1 = new Tweet("Superman does it again", "TheRealLoisLane");
        assertEquals("", tweet1.getAllHashtags());
    }
    @Test
    public void getHashTagsFirstandLast()
    {
        Tweet tweet1 = new Tweet("#CS4All @GovernerRauner Computer science in every classroom! #SHSCS", "MrSvetlik");
        assertEquals("#CS4All\n#SHSCS\n", tweet1.getAllHashtags());
    }
    @Test
    public void getrecipientSingleMiddle()
    {
        Tweet tweet1 = new Tweet("#CS4All @GovernerRauner Computer science in every classroom! #SHSCS", "MrSvetlik");
        assertEquals("@GovernerRauner\n", tweet1.getAllRecipients());
    }
    @Test
    public void getRecipientsFirstandLast()
    {
        Tweet tweet1 = new Tweet("@MartyMcFly Save the Clock Tower #Back2Future @DocBrown ", "JenniferParker");
        assertEquals("@MartyMcFly\n@DocBrown\n", tweet1.getAllRecipients());
    }
    @Test
    public void getHashtagSingleMiddle()
    {
        Tweet tweet1 = new Tweet("@MartyMcFly Save the Clock Tower #Back2Future @DocBrown ", "JenniferParker");
        assertEquals("#Back2Future\n", tweet1.getAllHashtags());
    }
    @Test
    public void getRecipientsEmptyBody()
    {
        Tweet tweet1 = new Tweet("", "InvisoGuy");
        assertEquals("", tweet1.getAllRecipients());
    }
    @Test
    public void getHashtagsEmptyBody()
    {
        Tweet tweet1 = new Tweet("", "InvisoGuy");
        assertEquals("", tweet1.getAllHashtags());
    }
    @Test
    public void getHandleNone()
    {
        Tweet tweet1 = new Tweet("Who sent this message", "");
        assertEquals("@", tweet1.getHandle());        
    }
    @Test
    public void getBodyTooLong()
    {
        Tweet tweet1 = new Tweet("#Preamble @Washington @Adams We the people in order to form a more perfect union establish justice and ensure domestic tranquility #ThomasJefferson", "ContinentalCongress");
        assertEquals("#Preamble @Washington @Adams We the people in order to form a more perfect union establish justice and ensure domestic tranquility #ThomasJe", tweet1.getBody());
    }
    @Test
    public void getHastagsTooLong()
    {
        Tweet tweet1 = new Tweet("#Preamble @Washington @Adams We the people in order to form a more perfect union establish justice and ensure domestic tranquility #ThomasJefferson", "ContinentalCongress");
        assertEquals("#Preamble\n#ThomasJe\n", tweet1.getAllHashtags());
    }
    @Test
    public void getRecipientsTooLong()
    {
        Tweet tweet1 = new Tweet("#Preamble @Washington @Adams We the people in order to form a more perfect union establish justice and ensure domestic tranquility @ThomasJefferson", "ContinentalCongress");
        assertEquals("@Washington\n@Adams\n@ThomasJe\n", tweet1.getAllRecipients());
    }
}

