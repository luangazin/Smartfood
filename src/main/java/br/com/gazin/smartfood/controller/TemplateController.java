package br.com.gazin.smartfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gazin.smartfood.util.PageName;

/**
 * @author luangazin
 *
 */
@Controller
@RequestMapping(value = "/main")
public class TemplateController {

	@RequestMapping("/index")
	public String getIndexPage() {
		return PageName.MAIN_PAGE;
	}
}
