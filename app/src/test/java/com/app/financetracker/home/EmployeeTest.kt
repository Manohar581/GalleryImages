package com.app.financetracker.home

import com.app.financetracker.home.data.Employee
import org.junit.Assert.assertEquals
import org.junit.Test

class EmployeeTest {

    @Test
    fun testEmployee() {
        val employee = Employee()
        val employeeCopy = employee.copy(employee_name = "Ashok")
        assertEquals("Ashok", employeeCopy.employee_name)
    }
}