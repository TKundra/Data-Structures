package Greedy;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

// priority queue with comparator
class Student {
    public String name;
    public double cgpa;
    public Student(String name, double cgpa){
        this.name = name;
        this.cgpa = cgpa;
    }
    public String getName(){ return name; }
}
class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        // descending order
        if (s1.cgpa < s2.cgpa)
            return 1;
        else if (s1.cgpa > s2.cgpa)
            return -1;
        return 0;
    }
}
class Example {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(5, new StudentComparator());
        pq.add(new Student("john", 3.2));
        pq.add(new Student("sky", 4.0));
        pq.add(new Student("ruby", 3.6));
        while (!pq.isEmpty())
            System.out.println(pq.poll().getName());
    }
}

public class PriorityQueueDataStructure {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(6);
        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(3);
        for (Integer i : priorityQueue)
            System.out.print(i + " ");
        System.out.println();
        // top element
        System.out.println(priorityQueue.peek());
        // top element and remove it
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);
        // top now, after removing
        System.out.println(priorityQueue.peek());
    }
}
