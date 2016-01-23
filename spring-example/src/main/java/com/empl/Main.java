package com.empl;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by faust on 23.01.16.
 */
public class Main {
    @Autowired
    static Employee employee;

    public static void main(String[] args) {
        /*System.out.println(employee.getName());*/
    }
}
