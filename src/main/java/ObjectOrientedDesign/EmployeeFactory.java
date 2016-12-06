package ObjectOrientedDesign;

/**
 * Factory Design Pattern
 * Created by qale0001 on 06/12/2016.
 */
public class EmployeeFactory {
    public static Employee getNewFactory(Level level) {
        switch (level) {
            case FRESHER: return new EmployeeBuilderImpl(Level.FRESHER).build();
            case LEAD: return new EmployeeBuilderImpl(Level.LEAD).build();
            case MANAGER: return new EmployeeBuilderImpl(Level.MANAGER).build();
            default: return null;
        }
    }

    public static Employee getNewFactory(Level level, boolean free) {
        switch (level) {
            case FRESHER: return new EmployeeBuilderImpl(Level.FRESHER).setFree(free).build();
            case LEAD: return new EmployeeBuilderImpl(Level.LEAD).setFree(free).build();
            case MANAGER: return new EmployeeBuilderImpl(Level.MANAGER).setFree(free).build();
            default: return null;
        }
    }
}
