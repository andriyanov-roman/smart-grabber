package com.empl; /**
 * Created by faust on 23.01.16.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EmployeeController {

    @RequestMapping("/get-employee")
    public Employee getEmployee (@RequestParam(value="name", defaultValue="Ivan") String name) {
        return new Employee();
    }
}