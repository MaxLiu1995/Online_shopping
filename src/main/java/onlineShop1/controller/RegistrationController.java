package onlineShop1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import onlineShop1.model.Customer;
import onlineShop1.service.CustomerService;

@Controller
public class RegistrationController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customer/registration", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {//ModelAndView是一个页面，这里返回一个注册页面
		Customer customer = new Customer();
		return new ModelAndView("register", "customer", customer);
		//register 是view 的名字(叫register的jsp)
		//customer :对customer进行赋值
	}

	@RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
	public ModelAndView registerCustomer(@ModelAttribute(value = "customer") Customer customer,
			BindingResult result) {
		//添加@Modelattribute之后，会将用户传入信息绑定到customer的对象上（在submit以后）
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {//若有错则重新注册
			modelAndView.setViewName("register");
			return modelAndView;
		}
		customerService.addCustomer(customer);//在这句存进数据库
		modelAndView.setViewName("login");//注册完以后导向login界面
		modelAndView.addObject("registrationSuccess", "Registered Successfully. Login using username and password");
		return modelAndView;
	}
}
