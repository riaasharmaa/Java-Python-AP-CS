
/**
 * Write a description of class ActivityRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ActivityRunner
{
    public static void main (String[] args)
    {
        Activity a1 = new Activity("Homework", "Friday", 1700, 60);
        System.out.println(a1.getName());
        System.out.println(a1.getDay());
        System.out.println(a1.getStartTime());
        System.out.println(a1.getDuration());
        Activity a2 = new Activity();
        System.out.println(a2.toString());
        boolean activityOverlap = a1.overlap(a2);
        String s1 = Boolean.toString(activityOverlap);
        System.out.println(s1);
        a2.setName("Football Game");
        a2.setDay("Friday");
        a2.setStartTime(1800);
        a2.setDuration(180);
        System.out.println(a2.toString());
        System.out.println(a2.getEndTime());
        boolean activityOverlap2 = a1.overlap(a2);
        String s2 = Boolean.toString(activityOverlap);
        System.out.println(s2);
        a2.setStartTime(1730);
        boolean activityOverlap3 = a1.overlap(a2);
        String s3 = Boolean.toString(activityOverlap);
        System.out.println(s3);
}
}