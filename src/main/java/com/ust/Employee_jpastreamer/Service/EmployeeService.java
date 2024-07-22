package com.ust.Employee_jpastreamer.Service;



import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.Repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private Employeerepo employeeRepository;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public EmployeeService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }


    public Map<String, List<Employee>> groupbyEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }
    public Map<String, List<Employee>> groupbyEmployeeByEducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }

    public List<Employee> groupbyEmployeeByPaymentTier() {
        return employeeRepository.findAll() ;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

    public List<Employee> findAgeRange(int min, int max) {

        return jpaStreamer.stream(Employee.class)
                .filter(e->e.getAge()>min && e.getAge()<max).toList();
    }

    public Long getGenderCount(String gender) {
        return jpaStreamer.stream(Employee.class)
               .filter(e->e.getGender().equalsIgnoreCase(gender)).count();
    }

    public List<Employee> getEmployeeinYear(Integer year) {
        return jpaStreamer.stream(Employee.class)
               .filter(e->e.getJoiningYear().equals(year)).toList();
    }



    public Map<String, Long> countGenderInYear(int year) {

        return jpaStreamer.stream(Employee.class)
                .filter(e->e.getJoiningYear().equals(year))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

    }

    public List<Employee> filterEmployees(Integer id, String education, Integer joiningYear, String city, Integer paymentTier, Integer age, String gender, String everBenched, Integer experienceInCurrentDomain, Integer leaveOrNot) {

        return jpaStreamer.stream(Employee.class)
                .filter(employee ->
                (id == null || employee.getId() == id) &&
                        (education == null || employee.getEducation().equalsIgnoreCase(education)) &&
                        (joiningYear == null || employee.getJoiningYear() == joiningYear) &&
                        (city == null || employee.getCity().equalsIgnoreCase(city)) &&
                        (paymentTier == null || employee.getPaymentTier() == paymentTier) &&
                        (age == null || employee.getAge() == age) &&
                        (gender == null || employee.getGender().equalsIgnoreCase(gender)) &&
                        (everBenched == null || employee.getEverBenched().equalsIgnoreCase(everBenched)) &&
                        (experienceInCurrentDomain == null || employee.getExperienceInCurrentDomain() == experienceInCurrentDomain) &&
                        (leaveOrNot == null || employee.getLeaveOrNot() == leaveOrNot))
                .collect(Collectors.toList());
    }
}