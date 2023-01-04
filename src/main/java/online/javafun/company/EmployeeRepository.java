package online.javafun.company;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.salary > 10000")
    List<Employee> findReachEmploees();

    @Query("UPDATE Employee e SET e.salary = e.salary + 100")
    @Modifying
    @Transactional
    void giveRiseToAll();

    @Query("SELECT e FROM Employee e WHERE e.salary > :min AND e.salary < :max")
    List<Employee> findBySalaryInRange(double min, double max);
}