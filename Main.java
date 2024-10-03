public class Main {
    public static void main(String[] args) {
        List list = new List();

        // Main Event Loop
        while (true){
            int choice = -2;
            clearScreen();
            showTasks(list);

            System.out.println("Task Number: Toggle Complete     0: Menu     -1: Exit");
            String input = System.console().readLine();
            if (input.equals("")) {
            } else {
                choice = Integer.parseInt(input);
            }

            if (choice == 0) {
                boolean exitMenu = false;
                while (!exitMenu) {
                    clearScreen();
                    showTasks(list);
                    System.out.println("1: View Task     2: Add Task     3: Edit Task     4: Delete Task     -1: Back");
                    input = System.console().readLine();
                    if (input.equals("")) {
                        choice = -1;
                    } else {
                        choice = Integer.parseInt(input);
                    }

                    switch (choice){
                        case 1:
                            clearScreen();
                            showTasks(list);
                            System.out.println("Enter the task number to view: ");
                            input = System.console().readLine();
                            if (input.equals("")) {
                                System.out.println("Invalid Input");
                                break;
                            } else {
                                choice = Integer.parseInt(input) - 1;
                            }
                            clearScreen();
                            showTasks(list);
                            System.out.println(list.getTask(choice).toString());
                            System.console().readLine();
                            break;
                        case 2:
                            addTask(list);
                            break;
                        case 3:
                            //editTask(list); // IMPLEMENT LATER
                            clearScreen();
                            showTasks(list);
                            System.out.println("Feature coming soon.");
                            System.console().readLine();
                            break;
                        case 4:
                            clearScreen();
                            showTasks(list);
                            System.out.println("Enter the task number to delete: ");
                            input = System.console().readLine();
                            if (input.equals("")) {
                                System.out.println("Invalid Input");
                                break;
                            } else {
                                choice = Integer.parseInt(input);
                            }
                            list.removeTask(choice - 1);
                            clearScreen();
                            showTasks(list);
                            System.out.println("Task " + choice + " removed.");
                            System.console().readLine();
                            break;
                        case -1:
                            exitMenu = true;
                            break;
                        default:
                            System.out.println("Invalid Input");
                            System.console().readLine();
                            break;
                    }
                }
            } else if (choice == -1) {
                exitProgram(list);
            } else if (choice > 0 && choice <= list.size()) {
                list.getTask(choice - 1).toggleStatus();
                if (list.getTask(choice - 1).getStatus()) {
                    clearScreen();
                    showTasks(list);
                    System.out.println("Task " + choice + " marked as complete.");
                } else {
                    clearScreen();
                    showTasks(list);
                    System.out.println("Task " + choice + " marked as incomplete.");
                };

                System.console().readLine();
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static void addTask(List list){
        clearScreen();
        System.out.println("Enter Task Name: ");
        String taskName = System.console().readLine();
        clearScreen();

        System.out.println("Enter Task Description: ");
        String taskDescription = System.console().readLine();
        clearScreen();

        Task task = new Task(taskName, taskDescription);
        System.out.println("Would you like to add a due date? (y/N)");
        String addDueDate = System.console().readLine();

        if (addDueDate.equals("y")){
            clearScreen();
            int day = 0;
            int month = 0;
            int year = 0;
            int hour = 0;
            int minute = 0;

            System.out.println("Enter Day: ");
            String input = System.console().readLine();
            if (input.equals("")) {
                System.out.println("Invalid Input");
            } else {
                day = Integer.parseInt(input);
            }
            clearScreen();

            System.out.println("Enter Month: ");
            input = System.console().readLine();
            if (input.equals("")) {
                System.out.println("Invalid Input");
            } else {
                month = Integer.parseInt(input);
            }
            clearScreen();

            System.out.println("Enter Year: ");
            input = System.console().readLine();
            if (input.equals("")) {
                System.out.println("Invalid Input");
            } else {
                year = Integer.parseInt(input);
            }
            clearScreen();

            System.out.println("Would you like to add a time? (y/N)");
            String addTime = System.console().readLine();
            clearScreen();

            if (addTime.equals("y")){
                System.out.println("Enter Hour: ");
                input = System.console().readLine();
                if (input.equals("")) {
                    System.out.println("Invalid Input");
                } else {
                    hour = Integer.parseInt(input);
                }
                clearScreen();

                System.out.println("Enter Minute: ");
                input = System.console().readLine();
                if (input.equals("")) {
                    System.out.println("Invalid Input");
                } else {
                    minute = Integer.parseInt(input);
                }
                clearScreen();

                task.setDueDate(new DueDate(day, month, year, hour, minute));
            } else {
                task.setDueDate(new DueDate(day, month, year));
            }
        }
        list.addTask(task);
    }

    public static void showTasks(List list) {
        System.out.println("Tasks:");
        System.out.println(list.toString());
    }

    public static void exitProgram(List list) {
        list.saveList();
        System.exit(0);
    }

    public static void clearScreen() {
        System.out.print("\033\143");
    }
}