package com.example.servletexam.controller;

import com.example.servletexam.model.Employee;
import com.example.servletexam.service.EmployeeService;
import com.example.servletexam.service.EmployeeServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/create.jsp");

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;

        if (employee == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("employee", employee);
            dispatcher = req.getRequestDispatcher("employee/edit.jsp");
        }

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;

        if (employee == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("employee", employee);
            dispatcher = req.getRequestDispatcher("employee/delete.jsp");
        }

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewEmployee(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/view.jsp");

        if (employee == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("employee", employee);
            dispatcher = req.getRequestDispatcher("employee/view.jsp");
        }

        try {
            req.setAttribute("employee", employee);
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployees(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/list.jsp");
        List<Employee> employees = this.employeeService.findAllEmployee();

        if (employees == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("employees", employeeService.findAllEmployee());
            dispatcher = req.getRequestDispatcher("employee/list.jsp");
        }

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest req, HttpServletResponse resp) {
        int id = (int) (Math.random() * 1000);
        String name = req.getParameter("name");
        int age = req.getIntHeader("age");
        String role = req.getParameter("role");
        String room = req.getParameter("room");
        double salary = Double.parseDouble(req.getParameter("salary"));

        Employee employee = new Employee(id, name, age, role, room, salary);

        this.employeeService.createEmployee(employee);
        req.setAttribute("message", "Create employee successful");
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/create.jsp");

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void editEmployee(HttpServletRequest req, HttpServletResponse resp) {
        int id = (int) (Math.random() * 1000);
        String name = req.getParameter("name");
        int age = req.getIntHeader("age");
        String role = req.getParameter("role");
        String room = req.getParameter("room");
        double salary = Double.parseDouble(req.getParameter("salary"));

        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;

        if (employee == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            employee.setName(name);
            employee.setAge(age);
            employee.setRole(role);
            employee.setRoom(room);
            employee.setSalary(salary);
            req.setAttribute("message", "Update employee successful");
            dispatcher = req.getRequestDispatcher("employee/edit.jsp");
        }

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;

        if (employee == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            this.employeeService.deleteEmployee(id);
            dispatcher = req.getRequestDispatcher("employee/list.jsp");
        }
    }
}
