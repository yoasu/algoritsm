package lab2;

public class Student implements Comparable<Student>{
    private final String name;
    private final int age;
    public Student(String name, int age){
        this.age = age;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }
}
