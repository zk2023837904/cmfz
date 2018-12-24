package com.baizhi.controller;


import com.baizhi.conf.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
@RequestMapping("/img")
public class CodeController {
	// 生成验证码图片
	@RequestMapping("/getCode")
	public void createImg(HttpSession session,HttpServletResponse response) throws IOException{
		// 调用工具类，生成图片上的随机字符
		CreateValidateCode cvc = new CreateValidateCode();
		String code = cvc.getCode();
		// 存 随机字符到  --- session
		session.setAttribute("code", code);
		// 调用工具类，把生成的随机字符，使用输出流往client输出成图片
		cvc.write( response.getOutputStream());
	}
}
