package br.com.gazin.smartfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gazin.smartfood.DAO.UserDAO;
import br.com.gazin.smartfood.domain.User;
import br.com.gazin.smartfood.util.PageName;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	@Qualifier("UserDAOImpl")
	public UserDAO getUserDAO;

	@RequestMapping(value = "/main")
	public String main() {
		return PageName.LOGIN_PAGE;
	}

	@RequestMapping(value = "/authentic", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String authentic(@ModelAttribute User user, ModelMap model) {
		if ((user != null)
				&& (user.getUsername().equalsIgnoreCase("root") && user.getPassword().equalsIgnoreCase("root"))) {
			model.addAttribute("user", "true");
			return PageName.MAIN_PAGE;
		} else {
			model.addAttribute("msg", "true");
			return PageName.LOGIN_PAGE;
		}
	}
}
