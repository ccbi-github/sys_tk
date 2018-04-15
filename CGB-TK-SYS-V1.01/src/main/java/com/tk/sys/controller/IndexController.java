package com.tk.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("loginUI")
	public String doStart(){
		
		return "login";
	}
	@RequestMapping("doHello")
	public String doHello(){
		return "hello";
	}
	@RequestMapping("index")
	public String doIndex(){
		return "index";
	}
	@RequestMapping("mainUI")
	public String mainUI(){
		return "main";
	}
	@RequestMapping("lesson_listUI")
	public String lesson_listUI(){
		return "lesson_list";
	}
	@RequestMapping("lesson_unKnownUI")
	public String lesson_unKnownUI(){
		return "lesson_unKnown";
	}
	@RequestMapping("sysUI")
	public String sysUI(){
		return "sys";
	}
	@RequestMapping("lessonUI")
	public String lessonUI(){
		return "lesson";
	}
	@RequestMapping("userUI")
	public String userUI(){
		return "user";
	}
	@RequestMapping("normal_freeUI")
	public String normal_freeUI(){
		return "normal-free";
	}
	@RequestMapping("normal_lessonUI")
	public String normal_lessonUI(){
		return "normal-lesson";
	}
	@RequestMapping("normal_levelUI")
	public String normal_levelUI(){
		return "normal-level";
	}	
}
