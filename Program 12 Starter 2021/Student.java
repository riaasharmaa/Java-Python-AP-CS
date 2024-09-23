
/**
 * This program uses an abstract class. This is no longer
 * required by the College Board, but is a helpful concept. 
 * When a class is abstract, you cannot create objects of
 * that type - only its children. In addition, an abstract
 * class may have abstract methods. These serve two purposes:
 * 1) ensure that all children have a matching method. A 
 *   child will not compile unless it has a method that
 *   overrides the abstract methods in the parent.
 * 2) aids in compiling with polymorphism by ensuring
 *   a desired method exists in the parent class
 *   (downcasting is then not required when this method
 *   is used)
 */
/*# DO NOT CHANGE THE CLASS HEADER OR THE ABSTRACT METHOD
 * BELOW.
 */
public abstract class Student

{
    private String name;
    private int id;
    private String school;
    private double gpa;
    /*#  DO NOT CHANGE THIS!!!
     * abstract method to provide children a common interface
     * for updating student status.
     */
    public Student(String n, int i, String sn, double g)
    {
        name=n;
        id=i;
        school=sn;
        gpa=g;
    }
    public String getSchoolName() 
    {
        return school;
    }
    public double getGPA() 
    {
        return gpa;
    }
    public abstract boolean updateStatus(int num);
    public String toString() 
    {
      return "Name: "+ name+"\tID: "+id+"\tGPA: "+gpa;  
    }
}
