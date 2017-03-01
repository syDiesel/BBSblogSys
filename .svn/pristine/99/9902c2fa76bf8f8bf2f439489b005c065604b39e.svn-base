package com.bbsBlog.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("ajax.do")
public class AjaxController {
	/*验证码ajax*/
	@RequestMapping(params="action=checkNum",method=RequestMethod.POST)
	public @ResponseBody String checkNum(HttpServletRequest req,String Num){
		 System.out.println(Num);
		 System.out.println(req.getSession().getAttribute("certCode"));
		 if( Num.equalsIgnoreCase((String) req.getSession().getAttribute("certCode"))){
			 System.out.println("true");
			 return "true";
		 
		 }
		 else {
			 System.out.println("false");
			 return "false";   
		
		 }
		
	}
}
