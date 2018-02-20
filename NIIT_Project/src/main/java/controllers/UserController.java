package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.niit.backend.DAO.ProductDao;
import com.niit.backend.DAO.UserDao;
import com.niit.backend.models.ProductModel;
import com.niit.backend.models.UserModel;

@Controller
public class UserController {
	
	@Autowired
	UserDao userdao;
	@Autowired
	ProductDao productdao;
	@RequestMapping(value="LogIn")
	public String loginMethod() {
		return "LoginPage";
	}
	@RequestMapping(value="SignUp")
	public String signinMethaod(Model model) {
		UserModel usermodel=new UserModel();
		model.addAttribute("user",usermodel);
		return "SignupPage";
	}
	@RequestMapping(value="Welcome",method=RequestMethod.POST)
	public String welcomeMethod(@ModelAttribute("user") UserModel usermodel) {
		userdao.storeData(usermodel);
		
		return "WelcomePage";
	}
	@RequestMapping(value="AllProducts")
	public String products() {
		return "WelcomePage";
	}
	 @RequestMapping(value="All")
	   public @ResponseBody String allProductsListList()
	   {
		   List<ProductModel> allProducts=productdao.allproducts();
		   Gson gson= new Gson();
		   String json=gson.toJson(allProducts);
		   return json;
	   }
	@RequestMapping(value="Toyslist")
	public String toys() {
		return "ToysPage";
	}
	 @RequestMapping(value="Toys")
	   public @ResponseBody String toysList()
	   {
		   List<ProductModel> toysproducts=productdao.allToys();
		   Gson gson= new Gson();
		   String json=gson.toJson(toysproducts);
		   return json;
	   }
	 @RequestMapping(value="Bookslist")
		public String books() {
			return "BooksPage";
		}
		 @RequestMapping(value="Books")
		   public @ResponseBody String booksList()
		   {
			   List<ProductModel> booksproducts=productdao.allBooks();
			   
			   Gson gson= new Gson();
			   String json=gson.toJson(booksproducts);
			   return json;
		   }
		 	 
}
