
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FreelanceTaskTracker {
    private List<TaskTracker> tasks = new ArrayList<>();

    private static class TaskTracker{
        private String taskName;
        private String clientName;
        private LocalDate deadline;
        private String taskDescription;
        private String taskPriority;
        private String taskStatus;
        private String taskCategory;
        private boolean completed;

        // Constructor

        public TaskTracker(String taskName, String clientName, LocalDate deadline,  String taskDescription, String taskPriority, String taskStatus, String taskCategory) {
            this.taskName = taskName;
            this.clientName = clientName;
            this.deadline = deadline;
            this.taskDescription = taskDescription;
            this.taskPriority = taskPriority;
            this.taskStatus = taskStatus;
            this.taskCategory = taskCategory;
            this.completed = false;

        }

        // Getter & Setter
        public String getTaskName(){return taskName;}
        public void setTaskName(String taskName){this.taskName = taskName;}

        public String getClientName(){return clientName;}
        public void setClientName(String clientName){this.clientName = clientName;}

        public LocalDate getDeadline(){return deadline;}
        public void setDeadline(LocalDate deadline){this.deadline = deadline;}

        public String getTaskDescription(){return taskDescription;}
        public void setTaskDescription(String taskDescription){this.taskDescription = taskDescription;}

        public String getTaskPriority(){return taskPriority;}
        public void setTaskPriority(String taskPriority){this.taskPriority = taskPriority;}

        public String getTaskStatus(){return taskStatus;}
        public void setTaskStatus(String taskStatus){this.taskStatus = taskStatus;}

        public String getTaskCategory(){return taskCategory;}
        public void setTaskCategory(String taskCategory){this.taskCategory = taskCategory;}

        public boolean isCompleted(){return completed;}
        public void setCompleted(boolean completed){this.completed = completed;}

        public String toString(){
            return "\n\uD83D\uDCCCTask Name: " + taskName + "\n\uD83D\uDCCCClient Name: "+ clientName + "\n\uD83D\uDCCCDeadline: " + deadline +  "\n\uD83D\uDCCCDescription: " + taskDescription + "\n\uD83D\uDCCCTask Priority: "+ taskPriority +"\n\uD83D\uDCCCTask Status: "+ taskStatus + "\n\uD83D\uDCCCTask Category: "+ taskCategory + " \n\uD83D\uDCCC(" + (completed ? "completed" : "not completed") + ")";
        }
    }

    // Add a task

    public void addTask(String taskName, String clientName, LocalDate deadline,  String taskDescription, String taskPriority, String taskStatus, String taskCategory){
        TaskTracker task = new TaskTracker(taskName, clientName, deadline, taskDescription, taskPriority, taskStatus, taskCategory);
        tasks.add(task);
    }

    // Edit a task

    public void editTask(int taskNo, String taskName, String clientName, LocalDate deadline,  String taskDescription, String taskPriority, String taskStatus, String taskCategory){
        TaskTracker task = tasks.get(taskNo);
        task.setTaskName(taskName);
        task.setClientName(clientName);
        task.setDeadline(deadline);
        task.setTaskDescription(taskDescription);
        task.setTaskPriority(taskPriority);
        task.setTaskStatus(taskStatus);
        task.setTaskCategory(taskCategory);
    }

    public List<TaskTracker>getTasks(){return tasks;}

    // View all tasks

    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("\u26A0\uFE0FNo tasks found. Please try again!");
            System.out.println("-------------------------------------------------------------------------");
            return;
        }
        for(int i=0; i<tasks.size(); i++){
            System.out.println("Task Number- "+(i+1));
            System.out.println(tasks.get(i));
            System.out.println();
        }
    }

    // Delete a task

    public void deleteTask(int taskNo){tasks.remove(taskNo);}

    // Mark a task as completed

    public void markTaskAsCompleted(int taskNo){
        TaskTracker task = tasks.get(taskNo);
        task.setCompleted(true);
    }

    public static void main(String[] args){
        FreelanceTaskTracker freelanceTaskTracker = new FreelanceTaskTracker();
        Scanner scanner = new Scanner(System.in);

        while(true){

            // Display the option list

            System.out.println("\n \uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDE80\uD83D\uDEA9Welcome to the Freelance Task Tracker!\uD83C\uDFAF\uD83D\uDE0E\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39 \n");

            System.out.println("\u0031\uFE0F\u20E3 Add a Task");
            System.out.println("\u0032\uFE0F\u20E3 Edit a Task");
            System.out.println("\u0033\uFE0F\u20E3 View all Tasks");
            System.out.println("\u0034\uFE0F\u20E3 Delete a Task");
            System.out.println("\u0035\uFE0F\u20E3 Mark a Task as completed");
            System.out.println("\u0036\uFE0F\u20E3 Tax Calculator ");
            System.out.println("\u0037\uFE0F\u20E3 Exit");

            try{
                System.out.println("\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39");
                System.out.println("\uD83D\uDC49Choose an option(1-7): ");

                int option = scanner.nextInt();
                scanner.nextLine();

                // check weather valid input

                if(option <1 || option > 7){

                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("\u274CInvalid option. Please enter a number between 1 to 6");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                    continue;
                }

                switch (option) {

                    case 1:
                        // create a task

                        String taskName = "";
                        while(taskName.isEmpty()) {
                            System.out.println("\u2B55Enter the task name: ");
                            taskName = scanner.nextLine().trim();
                            if(taskName.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Task name can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String clientName = "";
                        while(clientName.isEmpty()) {
                            System.out.println("\n\u2B55Enter the client Name: ");
                            clientName= scanner.nextLine().trim();
                            if(clientName.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Client name can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        LocalDate deadline = null;
                        while(deadline == null){
                            System.out.println("\n\u2B55Enter the task deadline (YYYY-MM-DD): ");
                            String deadlineString = scanner.nextLine();

                            try{
                                deadline = LocalDate.parse(deadlineString);
                            } catch (DateTimeParseException e){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid date format. Please try again.");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String taskDescription = "";
                        while(taskDescription.isEmpty()) {
                            System.out.println("\n\u2B55Enter your task's description: ");
                            taskDescription= scanner.nextLine().trim();
                            if(taskDescription.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Task's Description can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String taskPriority = "";
                        while(taskPriority.isEmpty()) {
                            System.out.println("\n\u2B55Enter your task' priority(e.g., High, Medium, Low): ");
                            taskPriority= scanner.nextLine().trim();
                            if(taskPriority.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError:Task's priority can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String taskStatus = "";
                        while(taskStatus.isEmpty()) {
                            System.out.println("\n\u2B55Enter your task's status(e.g., Not Started, In Progress, Completed, On Hold): ");
                            taskStatus= scanner.nextLine().trim();
                            if(taskStatus.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Task's status can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }

                        }

                        String taskCategory = "";
                        while(taskCategory.isEmpty()) {
                            System.out.println("\n\u2B55Enter your task's category(e.g., Writing, Design, Development): ");
                            taskCategory= scanner.nextLine().trim();
                            if(taskCategory.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Task's category can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        freelanceTaskTracker.addTask(taskName, clientName, deadline, taskDescription, taskPriority, taskStatus, taskCategory);

                        System.out.println("\n**********************************************************************");
                        System.out.println("\u2705Task added successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 2:

                        // Edit a task

                        System.out.println("\n\uD83D\uDD22Enter the task number to edit: ");
                        int editTaskNo = scanner.nextInt();
                        scanner.nextLine();

                        if (editTaskNo <= 0 || editTaskNo > freelanceTaskTracker.getTasks().size()) {

                            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("\u274CInvalid task number. Please try again!");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                            break;
                        }

                        String newTask = "";
                        while(newTask.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new task name: ");
                            newTask = scanner.nextLine().trim();
                            if(newTask.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New task can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String newClient = "";
                        while(newClient.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new client name: ");
                            newClient= scanner.nextLine().trim();
                            if(newClient.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New client name can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        LocalDate newDeadline = null;
                        while (newDeadline == null){
                            System.out.println("\n\u2B55Enter the new task deadline(YYYY-MM-DD): ");
                            String newDeadlineString = scanner.nextLine();

                            try{
                                newDeadline = LocalDate.parse(newDeadlineString);
                            }catch (DateTimeParseException e) {

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid date format. please try again!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            }
                        }

                        String newDescription= "";
                        while(newDescription.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new description: ");
                            newDescription= scanner.nextLine().trim();
                            if(newDescription.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New description can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String newPriority= "";
                        while(newPriority.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new priority(e.g., High, Medium, Low): ");
                            newPriority= scanner.nextLine().trim();
                            if(newPriority.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New Priority can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String newStatus= "";
                        while(newStatus.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new status(e.g., Not Started, In Progress, Completed, On Hold): ");
                            newStatus= scanner.nextLine().trim();
                            if(newStatus.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New status can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String newCategory= "";
                        while(newCategory.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new category(e.g., Writing, Design, Development): ");
                            newCategory= scanner.nextLine().trim();
                            if(newCategory.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New category can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        freelanceTaskTracker.editTask(editTaskNo - 1, newTask, newClient, newDeadline, newDescription, newPriority, newStatus, newCategory );

                        System.out.println("\n**********************************************************************");
                        System.out.println("\u2705Task edited successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 3:

                        // View all tasks

                        freelanceTaskTracker.viewTask();
                        break;

                    case 4:

                        // Delete a task

                        System.out.println("\n\uD83D\uDD22Enter the task Number to delete: ");
                        int deleteTaskNo = scanner.nextInt();
                        scanner.nextLine();

                        if (deleteTaskNo <= 0 || deleteTaskNo > freelanceTaskTracker.getTasks().size()) {

                            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("\u26A0\uFE0FTask not found. Please try again!");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                            break;
                        }

                        freelanceTaskTracker.deleteTask(deleteTaskNo - 1);

                        System.out.println("\n**********************************************************************");
                        System.out.println("\u2705Task deleted successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 5:

                        // Mark task as completed

                        System.out.print("\n\uD83D\uDD22Enter the task number to mark as completed: ");
                        int completeTaskNo = scanner.nextInt();
                        scanner.nextLine();

                        if (completeTaskNo <= 0 || completeTaskNo > freelanceTaskTracker.getTasks().size()) {

                            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("\u274CInvalid task number. Please try again!");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                            break;
                        }

                        freelanceTaskTracker.deleteTask(completeTaskNo - 1);

                        System.out.println("\n**********************************************************************");
                        System.out.println("\u2705Task marked as completed successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 6:

                        // Earning Calculator

                        double income = 0;

                        while(true){
                            System.out.println("\n\u2B55Enter the total income: ");
                            String num = scanner.nextLine().trim();

                            if(num.isEmpty()){
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CTotal income can not be empty!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                continue;
                            }

                            income = Double.parseDouble(num);
                            if(income <= 0){

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CTotal income can not be negative!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                            }else{

                                break;
                            }

                        }

                        double taxPecentage = 0;

                        while(true){
                            System.out.println("\n\u2B55Enter the estimated tax percentage%(e.g. 10 or 12.5): ");
                            String num = scanner.nextLine().trim();

                            if(num.isEmpty()){

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CTax percentage can not be empty!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                continue;
                            }
                            taxPecentage = Double.parseDouble(num);
                            if(taxPecentage <= 0){

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CTax percentage can not be negative!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                            }else{

                                break;
                            }
                        }

                        double tax = income*taxPecentage/100 ;
                        double afterTax = income-tax;

                        System.out.println("\n**********************************************************************");
                        System.out.printf("\uD83D\uDCB5Total Income after tax: Rs. %.2f%n",afterTax);
                        System.out.println("**********************************************************************");

                        break;


                    case 7:

                        System.out.println("\n============================================================================================");
                        System.out.println("\uD83D\uDE00Thank you for using Freelance task tracker. Catch you tomorrow—keep hustling!");
                        System.out.println("============================================================================================");

                        break;
                }
                System.out.println();


            }catch(InputMismatchException e){

                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("\u274CInvalid input! Please enter numbers only.");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                scanner.nextLine();
            }catch(Exception e){

                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("\u274CInvalid input! Please enter numbers only.");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            }
        }
    }
}

