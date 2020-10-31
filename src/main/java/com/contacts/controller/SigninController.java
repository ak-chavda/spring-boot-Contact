package com.contacts.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contacts.entity.User;
import com.contacts.forms.SigninForm;
import com.contacts.repository.UserRepository;

@Controller
public class SigninController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private HttpSession httpSession;

	@GetMapping("/show_signin")
	public String showSignupForm(Model theModel) {
		theModel.addAttribute("signin", new SigninForm());
		return "signin";
	}

	@RequestMapping("/process_login")
	public String processSiginForm(@Valid @ModelAttribute("signin") SigninForm signin, BindingResult bindingResult,
			Model theModel) {

		if (bindingResult.hasErrors()) {
			return "signin";
		}

		// check user credentials for signin
		User user = userRepository.findByUsername(signin.getUserName());

		if (user != null) {
			if (signin.getPassword().equals(user.getPassword())) {
				httpSession.setAttribute("login", "true");
				httpSession.setAttribute("uname", user.getUsername());
				httpSession.setAttribute("uid", user.getUserid());
				return "redirect:/all_contacts";
			}
		}
		//	this considered as else part
		theModel.addAttribute("error", "username or Password is incorrect");
		return "signin";
	}
}
