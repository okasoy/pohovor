package skit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skit.web.entity.Account;

@RestController
@RequestMapping("/api/user")
public class UserServiceREST {

    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody Account user) {
        userService.addUser(user);
    }

    @PutMapping("/pay")
    public void payForDisk(@RequestBody Payment payment) {
        userService.payForDisk(payment.getUsername(), payment.getPayment());
    }

    public static class Payment{
        private final int payment;
        private final String username;

        public Payment(int payment, String username) {
            this.payment = payment;
            this.username = username;
        }

        public int getPayment() {
            return payment;
        }

        public String getUsername() {
            return username;
        }
    }
}
