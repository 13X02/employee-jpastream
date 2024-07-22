package com.ust.Employee_jpastreamer.controller;

import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupbyEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }
//    find jpastreamer to find age ranges


    @GetMapping("/findAgeRange/{min}/{max}")
    public List<Employee> findAgeRange(@PathVariable("min") int min, @PathVariable("max") int max){
        return employeeService.findAgeRange(min,max);
    }
    //    count of gender
    @GetMapping("/countGender/{gender}")
    public Long getGenderCount(@PathVariable("gender") String gender){
        return employeeService.getGenderCount(gender);
    }
//    list of emp in given yr
    @GetMapping("/getEmployeeInYear/{year}")
    public List<Employee> getEmployeeinYear(@PathVariable("year") int year){
        return employeeService.getEmployeeinYear(year);
    }
//    particular yr - count of males and count of females
    @GetMapping("/countGenderInYear/{year}")
    public Map<String, Long> countGenderInYear(@PathVariable("year") int year){
        return employeeService.countGenderInYear(year);
    }
//    group by education
    @GetMapping("/groupByEducation")
    public Map<String, List<Employee>> groupbyEmployeeByEducation(){
        return employeeService.groupbyEmployeeByEducation();
    }
//    filter based on exp,edu etc
    @GetMapping("/searchFilter/")
    public List<Employee> filterEmployees(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String education,
            @RequestParam(required = false) Integer joiningYear,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer paymentTier,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String everBenched,
            @RequestParam(required = false) Integer experienceInCurrentDomain,
            @RequestParam(required = false) Integer leaveOrNot
    ) {
        return employeeService.filterEmployees(id, education, joiningYear, city, paymentTier,
                age, gender, everBenched, experienceInCurrentDomain, leaveOrNot);
    }


}