package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

        System.out.println("Printing deadlines");
        printDeadlines(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));
//        printData(tasksData);
//        printDataWithStreams(tasksData);
//        printDeadlinesUsingStreams(tasksData);

    }


    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesUsingStreams(ArrayList<Task> tasks) {

        int count = (int) tasks.stream()
                .filter((t) -> t instanceof Deadline)// passing each element to function ...terminal operator
                .count(); //aggregate function

        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        System.out.println("Printing data by looping");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDeadlinesUsingStreams(ArrayList<Task> tasks){
        System.out.println("Printing deadlines using stream");
        tasks.stream()
                .filter((t) -> t instanceof Deadline) // filtering using lambda
                .forEach(System.out::println);
    }

    public static void printDataWithStreams(ArrayList<Task> tasks) {
        System.out.println("Printing data using streams");
        tasks.stream() // convert data to stream
                .forEach(System.out::println); // passing each element to function ...terminal operator
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
//        ArrayList<Task> deadlines = new ArrayList<>();
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
//                deadlines.add(t);
                System.out.println(t);
            }
        }
    }
}
