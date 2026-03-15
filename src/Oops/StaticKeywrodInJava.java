package Oops;
class School{
    private static School school;
    private School(){
        school = new School();
    }
    static School getInstance(){
        return school;
    }
}
class Student{
    public static int count = 0;
    static{
        // static block used to initialize static variables (to performing 1 time initialization)
        System.out.println("Student class loaded in memory");
    }
    int rollNo;
    String name;
    Student(int rollNo,String name){
        System.out.println("Student object created");
        this.rollNo = rollNo;
        this.name = name;
        count++;
    }
    static void printCount(){
        // non-static variables cannot be accessible from static methods
        System.out.println("Total count of Students is: "+(new Student(10,"dp").name));
        //System.out.println("Total count of Students: "+this.count); this keyword we can't use in static block / static method
        //Super keyword can't be used in static block.
    }
}
public class StaticKeywrodInJava {
    int something = 0;// non-static
    static int tingting = 2;// static variable

    public int sum(int a,int b){
        return a+b;
    }
    public static int sub(int a,int b){
        return a-b;
    }
    public static void main(String[] args) {
        Student s1 = new Student(1,"kausahl");
        Student s2 = new Student(2,"sham");
        Student s3 = new Student(3,"ram");
        Student s4 = new Student(4,"jaggu");
        Student s5 = new Student(5,"shaggu");
        Student.printCount();

        //non-static can be accessed in static block using object. (need to create obj)
        StaticKeywrodInJava st = new StaticKeywrodInJava();
        st.something = 100;
        System.out.println(st.something);


        tingting = 20;
        System.out.println("Tingting is  :"+tingting);
        //System.out.println(sum(10,20));// non-static in static direct access -> error (object required)
        System.out.println(sub(10,20));//stat in static
        /*
            static block - initiated first when class loaded in jvm
            constructor - static block executed before constructor
         */

        //Singleton pattern -
        //School school = new School(); - error
        School school = School.getInstance();// only single object is created and reused.

    }
}
