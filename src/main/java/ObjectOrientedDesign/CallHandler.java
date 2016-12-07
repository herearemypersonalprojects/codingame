package ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by qale0001 on 06/12/2016.
 */

enum Level {
    FRESHER(0), LEAD(1), MANAGER(2);
    int level;
    Level(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
}


abstract class Employee {
    boolean free;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}

class Fresher extends Employee {
    @Override
    public String toString() {
        return "Fresher";
    }

}

class Lead extends Employee {
    @Override
    public String toString() {
        return "Lead";
    }

}

class Manager extends Employee {
    @Override
    public String toString() {
        return "Manager";
    }
}

// Singleton Design Pattern
public class CallHandler {
    private static final CallHandler INSTANCE = new CallHandler();

    private CallHandler() {}

    public static CallHandler getInstance() {
        return INSTANCE;
    }

    public Employee getCallHandler(List<Employee>[] lstEmployees) {
        for (Level level : Level.values()) {
            List<Employee> lstLevels = lstEmployees[level.getLevel()];
            Optional<Employee> employee = lstLevels.stream().filter(e -> e.isFree()).findFirst();
            if (employee.isPresent()) {
                return employee.get();
            }
        }
        return null;
    }

    private static List<Employee> initLstFresher() {
        List<Employee> lst = new ArrayList<>();
        lst.add(EmployeeFactory.getNewFactory(Level.FRESHER, false));
        lst.add(EmployeeFactory.getNewFactory(Level.FRESHER, false));
        return lst;
    }

    private static List<Employee> initLstLead() {
        List<Employee> lst = new ArrayList<>();
        lst.add(EmployeeFactory.getNewFactory(Level.LEAD, false));
        lst.add(EmployeeFactory.getNewFactory(Level.LEAD, false));
        return lst;
    }

    private static List<Employee> initLstManager() {
        List<Employee> lst = new ArrayList<>();
        lst.add(EmployeeFactory.getNewFactory(Level.MANAGER, false));
        lst.add(EmployeeFactory.getNewFactory(Level.MANAGER, true));
        return lst;
    }

    public static void main(String[] args) {
        List<Employee>[] lst = new ArrayList[Level.values().length];
        lst[Level.FRESHER.getLevel()] = initLstFresher();
        lst[Level.LEAD.getLevel()] = initLstLead();
        lst[Level.MANAGER.getLevel()] = initLstManager();

        System.out.println(CallHandler.getInstance().getCallHandler(lst));
    }
}
/*
Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM).
There can be multiple employees, but only one TL or PM.
An incoming telephone call must be allocated to a fresher who is free.
If a fresher can’t handle the call, he or she must escalate the call to technical lead.
If the TL is not free or not able to handle it, then the call should be escalated to PM.
Design the classes and data structures for this problem. Implement a method getCallHandler().

 */