import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Queue {
        Node front, rear;
        int size;

        class Node {
            int data;
            Node next;
        }

        Queue() {
            front = rear = null;
            size = 0;
        }

        void enQueue(int val) {
            Node oldRear = rear;
            rear = new Node();
            rear.data = val;
            rear.next = null;

            if (size == 0) {
                front = rear;
            } else {
                oldRear.next = rear;
            }
            size++;
        }

        public int dequeue() {
            int data = front.data;
            front = front.next;
            if (size == 0) {
                rear = null;
            }
            size--;
            return data;
        }

        public void printQueue() {
            Node i = front;
            int count = 1;
            if (i == null) {
                System.out.println("Queue is empty ...");
            } else {
                System.out.println("");
                while (i != null) {
                    System.out.printf("Average of student %d: %d\n", count, i.data);
                    i = i.next;
                    count++;
                }
            }
        }

    }

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));;
    static Queue avgQueue = new Queue();;

    public static void main(String[] args) {
        do {
            try {
                menu();
                program();
                System.out.println("\n------------ Results ------------");
                avgQueue.printQueue();
                System.out.print("\nDo you want to find the average again? yes(y) or no(n): ");
                String uIn = bf.readLine();
                if (uIn.hashCode() != "y".hashCode())
                    break;

            } catch (Exception e) {

            }
        } while (true);

    }

    static void menu() {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("Students' Average Finder");
        System.out.println("Enter the student's marks 'Maths Chemistry Physics' in this format");
        System.out.println("Enter -1 to exit the program");
        System.out.println("-----------------------------------------------------------------\n");
    }

    static void program() {
        int sum = 0;

        do {
            try {
                System.out.print("Enter the marks: ");
                String in = bf.readLine();
                if (in.hashCode() == "-1".hashCode())
                    break;
                String[] marks = in.split(" ");
                for (int i = 0; i < marks.length; i++) {
                    Integer val = Integer.parseInt(marks[i]);
                    sum += val;
                }
                int avg = sum / 3;
                avgQueue.enQueue(avg);
            } catch (Exception e) {
                System.out.println("Invalid input provided!");
            }
        } while (true);
    }
}