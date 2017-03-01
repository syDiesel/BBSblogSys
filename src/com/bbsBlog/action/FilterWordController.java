/**
 * 
 */
package com.bbsBlog.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbsBlog.entity.FilterWord;
import com.bbsBlog.service.FilterWordService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年8月10日
 *
 */
@Controller
@RequestMapping("web/management/FilterWord")
public class FilterWordController {

	@Resource
	private FilterWordService filterWordSerivce;

	private final String LIST_ACTION = "redirect:/web/management/FilterWord/list";

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月10日
	 *
	 * @param filterWord
	 * @return
	 */
	@RequestMapping(value = "/new")
	public String saveFilterWord(FilterWord filterWord) {

		this.filterWordSerivce.saveFilterWord(filterWord);

		return LIST_ACTION;
	}

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月10日
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_{id}")
	public String deleteFilterWord(@PathVariable long id) {
		this.filterWordSerivce.deleteFilterWord(id);
		return LIST_ACTION;
	}

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月10日
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String listFilterWord(HttpServletRequest request) {
		int pageSize=30;
		
		
		int offset = 0;   
        
        try {  
            offset = Integer.parseInt(request.getParameter("pager.offset"));  
        } catch (Exception e) {  
        }  
        //这里我按照每页显示10条  
        PageModel pm =filterWordSerivce.listFilterWord(offset, pageSize);  
        request.setAttribute("pm", pm);  
		return "listFilterWord";
	}

	
	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月10日
	 *
	 * @param filterWord
	 * @return
	 */
	@RequestMapping(value = "/update")
	public String updateFilterWord(FilterWord filterWord) {
		
		System.out.println(filterWord.getFind());
		System.out.println(filterWord.getClass());
		System.out.println(filterWord.getId());
		
		
		this.filterWordSerivce.updateFilterWord(filterWord);

		return LIST_ACTION;
	}
	@RequestMapping(value="/list_{id}")
	public String listFilterWordById(HttpServletRequest request,@PathVariable long id){
		
		FilterWord filterWords = filterWordSerivce.listFilterWordByID(id);
		request.setAttribute("filterWords", filterWords);
		return "modifyFilterWord";
	}
}
