
/**
 * Write a description of class Activity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Activity
{
    // instance variables - replace the example below with your own
    private String name;
    private String day;
    private int startTime;
    private int duration;

    /**
     * Constructor for objects of class Activity
     */
    public Activity()
    {
        // initialise instance variables
      name = "unknown";
      day = "Monday";
      startTime = 1700;
      duration = 60;
      
    }
    public Activity(String n, String d, int s, int t)
    {
      name = n;
      day = d;
      startTime = s;
      duration = t;
    }
    public String getName()
    {
      return name;
    }
    public String getDay()
    {
      return day;
    }
    public int getStartTime()
    {
      return startTime;
    }
    public int getDuration()
    {
      return duration;
    }
    public String setName(String n)
    {
        name = n;
        return name;
    }
    public String setDay(String d)
    {
        day = d;
        return day;
    }
    public int setStartTime(int s)
    {
        startTime = s;
        return startTime;
    }
     public int setDuration(int t)
    {
        duration = t;
        return duration;
    }
    public String toString()
    {
        String calender = name + "\t" + day + "\t" + startTime + "\t" + duration;
        return calender;
    }
    public int getEndTime()
    {
        int startHours = startTime/100;
        int startMins = startTime%100;
        int durationHours = duration/60;
        int durationMins = duration%60;
        int totalMins = startMins + durationMins;
        int totalMinsHours = totalMins/60;
        int totalHours = startHours + durationHours + totalMinsHours;
        totalHours = totalHours * 100;
        int totalMinsLeft = totalMins%60;
        int endTime = totalHours + totalMinsLeft;
        return endTime;
    }
    public boolean overlap(Activity a)
    {
        int endTimeThis = this.getEndTime();
        int endTimeA = a.getEndTime();
        if (endTimeA > this.startTime && a.startTime < this.getEndTime() && (this.day.equals(a.day)))
        {
            return true;
        }
        else
        {
            return false;
        }
}
}
