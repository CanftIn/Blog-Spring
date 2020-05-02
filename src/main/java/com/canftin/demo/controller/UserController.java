package com.canftin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.canftin.demo.domain.User;
import com.canftin.demo.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("title", "用户管理");
		return new ModelAndView("users/list","userModel", model);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model) {
		Optional<User> user = userRepository.findById(id);
		model.addAttribute("user", user.get());
		model.addAttribute("title", "查看用户");
		return new ModelAndView("users/view", "userModel", model);
	}


	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null, null, null));
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/form","userModel", model);
	}

	@PostMapping
	public ModelAndView saveOrUpdateUser(User user) {
		userRepository.save(user);
		return new ModelAndView("redirect:/users");// 重定向到 list页面
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return new ModelAndView("redirect:/users"); // 重定向到 list页面
	}

	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id, Model model) {
		Optional<User> user = userRepository.findById(id);
		model.addAttribute("user", user.get());
		model.addAttribute("title", "修改用户");
		return new ModelAndView("users/form","userModel", model);
	}

}
