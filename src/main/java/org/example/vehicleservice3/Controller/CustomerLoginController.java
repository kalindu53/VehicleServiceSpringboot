package org.example.vehicleservice3.Controller;

import jakarta.servlet.http.HttpSession;

import org.example.vehicleservice3.Entity.CustomerEntity;
import org.example.vehicleservice3.Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerLoginController {

    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping("/customer-login")
    public String customerLogin(@RequestParam String email,
                                @RequestParam String phone,
                                HttpSession session) {
        CustomerEntity customer = customerRepo.findByEmailAndPhone(email, phone);
        if (customer != null) {
            session.setAttribute("loggedInCustomer", customer);
            return "redirect:/customer-dashboard";
        } else {
            return "redirect:/customer-login?error=true";
        }
    }

    @GetMapping("/customer-login")
    public String loginForm() {
        return "CustomerLoginForm"; // Make sure the template file is named CustomerLoginForm.html
    }

    @GetMapping("/customer-dashboard")
    public String customerDashboard() {
        return "CustomerDashboard"; // Create this dashboard view
    }
}
