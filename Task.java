import java.io.Serializable;

public class Task implements Serializable{
    private static final long serialVersionUID = 1L;

    DueDate dueDate;
    String taskName;
    String taskDescription;
    boolean isDone;

    // Constructor with DueDate
    public Task(DueDate dueDate, String taskName, String taskDescription) {
        this.dueDate = dueDate;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    // Constructor without DueDate
    public Task(String taskName, String taskDescription) {
        this.dueDate = null;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    public void toggleStatus(){
        this.isDone = !this.isDone;
    }

    public boolean getStatus(){
        return this.isDone;
    }

    public void setDueDate(DueDate dueDate){
        this.dueDate = dueDate;
    }

    public DueDate getDueDate(){
        return this.dueDate;
    }

    public void setName(String name){
        this.taskName = name;
    }

    public String getName(){
        return this.taskName;
    }

    public void setDescription(String description){
        this.taskDescription = description;
    }

    public String getDescription(){
        return this.taskDescription;
    }

    public String toString(){
        return this.taskName + "\n"
             + this.taskDescription + "\n"
             + (this.dueDate != null ? "Due: " + this.dueDate.toString() : "") + "\n"
             + "Status: " + (this.isDone ? " [Complete]" : "[Incomplete]");
    }
}
