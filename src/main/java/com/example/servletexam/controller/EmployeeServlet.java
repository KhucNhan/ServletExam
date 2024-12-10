package com.example.servletexam.controller;

import com.example.servletexam.model.Employee;
import com.example.servletexam.service.EmployeeService;
import com.example.servletexam.service.EmployeeServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "view":
                viewEmployee(req, resp);
                break;
            default:
                showEmployees(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createEmployee(req, resp);
                break;
            case "edit":
                editEmployee(req, resp);
                break;
            case "delete":
                deleteEmployee(req, resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
            case "filterByRoom":
                filterByRoom(req, resp);
                break;
            default:
                break;
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("searchValue");

        List<Employee> employees = this.employeeService.findAllEmployee();
        List<Employee> searchEmployees = new ArrayList<>();
        RequestDispatcher dispatcher;

        for (Employee employee : employees) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                searchEmployees.add(employee);
            }
        }

        if (name == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("employee/list.jsp");
        }


        req.setAttribute("employees", searchEmployees);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void filterByRoom(HttpServletRequest req, HttpServletResponse resp) {
        String filterValue = req.getParameter("filterValue");

        List<Employee> employees = this.employeeService.findAllEmployee();
        List<Employee> searchEmployees = new ArrayList<>();
        RequestDispatcher dispatcher;

        for (Employee employee : employees) {
            if (employee.getRoom().equalsIgnoreCase(filterValue)) {
                searchEmployees.add(employee);
            }
        }

        if (filterValue == null || searchEmployees.isEmpty()) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("employee/list.jsp");
        }

        req.setAttribute("employees", searchEmployees);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

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
        RequestDispatcher dispatcher;
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
        int age = Integer.parseInt(req.getParameter("age"));
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
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
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
            try {
                resp.sendRedirect("/employees");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
