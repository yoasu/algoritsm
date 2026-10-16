package lab2;
import java.util.List;
public class StudentSorting implements Sorting<Student> {
    @Override
    public void sort(List<Student> students){
        insertSort(students, true);
        insertSort(students, false);

    }
    private void insertSort(List<Student> students, boolean age){
        for(int i = 1; i < students.size(); i++){
            Student s = students.get(i);
            int j;
            for(j = i - 1; j >= 0 && collate(students.get(j), s, age) > 0; j--){
                students.set(j+1, students.get(j));
            }
            students.set(j+1, s);
        }
    }
    private int collate(Student first, Student second, boolean age){
        if(age){
            return Integer.compare(first.getAge(), second.getAge());
        }
        return first.getName().compareTo(second.getName());
    }
}
