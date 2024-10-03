import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class List implements Serializable{
    private static final long serialVersionUID = 1L;
    
    ArrayList<Task> tasks;

    // Load List of Tasks
    @SuppressWarnings("unchecked")
    public List(){
        // Check for saved tasks and load
        File file = new File("tasks.ser");
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            tasks = (ArrayList<Task>) in.readObject();
            } catch (Exception e) {
            e.printStackTrace();
            }
        } else {
            tasks = new ArrayList<Task>();
        }
    }

    // Save List of Tasks
    public void saveList(){
        try {
            // Save tasks
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("tasks.ser")
            );
            out.writeObject(tasks);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(int index){
        tasks.remove(index);
    }

    public Task getTask(int index){
        return tasks.get(index);
    }

    public int size(){
        return tasks.size();
    }

    public String toString(){
        String output = "";
        for (int i = 0; i < tasks.size(); i++) {
            String status = tasks.get(i).isDone ? " [Done]" : "";
            output += i+1 + ". " + tasks.get(i).taskName + status + "\n";
        }
        return output;
    }
}
