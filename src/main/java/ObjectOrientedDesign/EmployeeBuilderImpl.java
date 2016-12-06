package ObjectOrientedDesign;

/**
 * Created by qale0001 on 06/12/2016.
 */
public class EmployeeBuilderImpl implements EmployeeBuilder {
    private Employee employee;
    public EmployeeBuilderImpl(Level level) {
        switch (level) {
            case FRESHER: employee =new Fresher(); break;
            case LEAD: employee =new Lead(); break;
            case MANAGER: employee =new Manager(); break;
        }
    }

    @Override
    public EmployeeBuilder setFree(boolean free) {
        employee.setFree(free);
        return this;
    }

    @Override
    public Employee build() {
        return employee;
    }

}
