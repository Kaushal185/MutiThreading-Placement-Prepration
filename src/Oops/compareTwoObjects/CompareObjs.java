package Oops.compareTwoObjects;

import java.util.Objects;

class Student {

    int id;
    String name;

    Student() {
        this.id = 0;
        this.name = "";
    }

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        // Same reference
        if (this == obj) {
            return true;
        }

        // null or different class
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student student = (Student) obj;

        return this.id == student.id
                && Objects.equals(this.name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class CompareObjs {

     static void main(String[] args) {

        Student s1 = new Student(1, "John");
        Student s2 = new Student(1, "John");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}