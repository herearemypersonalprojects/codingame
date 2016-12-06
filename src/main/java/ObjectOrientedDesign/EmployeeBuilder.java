package ObjectOrientedDesign;

/**
 * Builder Design Pattern
 * Created by qale0001 on 06/12/2016.
 */
public interface EmployeeBuilder {
    EmployeeBuilder setFree(boolean free);
    Employee build();
}
