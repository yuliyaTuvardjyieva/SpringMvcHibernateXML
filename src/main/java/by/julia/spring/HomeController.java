package by.julia.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.julia.spring.dao.CardDAO;
import by.julia.spring.dao.CountDAO;
import by.julia.spring.dao.UserDAO;
import by.julia.spring.model.Card;
import by.julia.spring.model.Count;
import by.julia.spring.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CountDAO countDao;
	
	@Autowired
	private CardDAO cardDao;

	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
		return model;
	}
/*	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<Count> listCounts = countDao.list();
		ModelAndView model = new ModelAndView("CountList");
		model.addObject("countList", listCounts);
		return model;
	}*/
	
/*	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<Card> listCards = cardDao.list();
		ModelAndView model = new ModelAndView("CardList");
		model.addObject("cardList", listCards);
		return model;
	}*/
	

	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new User());
		return model;		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userDao.get(userId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", user);
		return model;		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		userDao.delete(userId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		userDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/listOfCount", method = RequestMethod.GET)
	public ModelAndView allCount() {
		List<Count> listCounts = countDao.list();
		ModelAndView model = new ModelAndView("CountList");
		model.addObject("countList", listCounts);
		return model;
	}
	
	@RequestMapping(value = "/listOfCards", method = RequestMethod.GET)
	public ModelAndView allCards() {
		List<Card> listCards = cardDao.list();
		ModelAndView model = new ModelAndView("CardList");
		model.addObject("cardList", listCards);
		return model;
	}
	
/*	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newCount() {
		ModelAndView model = new ModelAndView("CountForm");
		model.addObject("count", new Count());
		return model;		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCount(HttpServletRequest request) {
		int countId = Integer.parseInt(request.getParameter("id"));
		Count count = countDao.get(countId);
		ModelAndView model = new ModelAndView("CountForm");
		model.addObject("count", count);
		return model;		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteCount(HttpServletRequest request) {
		int countId = Integer.parseInt(request.getParameter("id"));
		countDao.delete(countId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCount(@ModelAttribute Count count) {
		countDao.saveOrUpdate(count);
		return new ModelAndView("redirect:/");
	}*/
}
