package vn.com.rabbit.controller.publics;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.rabbit.common.Path;
import vn.com.rabbit.service.AccountService;
import vn.com.rabbit.service.dto.AccountDto;

@Controller
@RequestMapping(Path.Public)
public class AccountPublicController {

    private final AccountService userService;
    public  AccountPublicController(AccountService service){
        this.userService = service;
    }

    @PostMapping(value = "register")
    public String register(HttpServletRequest request, Principal principal) {

        //parent

        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phonenumber");
        String hoTen = request.getParameter("name");
       // String[] roles = request.getParameterValues("roles");


        AccountDto _account = new AccountDto();

        _account.setUsername(userName);
        _account.setPassword(passWord);
        _account.setEmail(email);
        _account.setPhoneNumber(phoneNumber);
        _account.setHoTen(hoTen);
        
        List<String> role=  new ArrayList<String>();
        
        role.add("ROLE_USER");
        
        _account.setRoles(role);

        userService.save(_account, principal);

        System.out.println("add or update thanh cong category thanh cong");

        return "redirect:" + request.getHeader("Referer");
    }


}
