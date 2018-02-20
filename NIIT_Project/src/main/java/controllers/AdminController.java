package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.niit.backend.DAO.AdminDao;
import com.niit.backend.DAO.ProductDao;
import com.niit.backend.models.AdminModel;
import com.niit.backend.models.ProductModel;

@Controller
public class AdminController {
	@Autowired
	AdminDao admindao;
	@Autowired
	ProductDao productdao;
	@RequestMapping(value="Admin")
	public String AdminLogin() {
		return "AdminLoginPage";
	}
	@RequestMapping(value="AdminSignup")
	public String adminSigup(Model model) {
		AdminModel adminmodel=new AdminModel();
		model.addAttribute("user",adminmodel);
		return "AdminSignupPage";
	}
	@RequestMapping(value="AdminPage", method=RequestMethod.POST)
	public String admin(@ModelAttribute("user") AdminModel adminmodel) {
		admindao.storeData(adminmodel);
		return "AdminPage";
	}
	@RequestMapping(value="AdminAllProducts")
	public String adminproducts() {
		return "AdminPage";
	}
	 @RequestMapping(value="AdminAll")
	   public @ResponseBody String allAdminProductsList()
	   {
		   List<ProductModel> alladminProducts=productdao.adminallproducts();
		   Gson gson= new Gson();
		   String json=gson.toJson(alladminProducts);
		   return json;
	   }
	@RequestMapping(value="AdminToyslist")
	public String adminToys() {
		return "AdminToysPage";
	}
	 @RequestMapping(value="AdminToys")
	   public @ResponseBody String adminToysList()
	   {
		   List<ProductModel> admintoysproducts=productdao.adminAllToys();
		   Gson gson= new Gson();
		   String json=gson.toJson(admintoysproducts);
		   return json;
	   }
	 @RequestMapping(value="AdminBookslist")
		public String adminBooks() {
			return "AdminBooksPage";
		}
		 @RequestMapping(value="AdminBooks")
		   public @ResponseBody String adminBooksList()
		   {
			   List<ProductModel> adminbooksproducts=productdao.adminAllBooks();
			   
			   Gson gson= new Gson();
			   String json=gson.toJson(adminbooksproducts);
			   return json;
		   }
		 @RequestMapping(value="Delete")
		 public String deleteProduct(@RequestParam int id) {
			 productdao.delete(id);
			 return "AdminPage";
		 }
		 @RequestMapping(value="Edit")
		 public String editProduct(@RequestParam int id,Model model) { 
			 ProductModel productmodel=productdao.edit(id);
			 model.addAttribute("user",productmodel);
			 return "EditProductPage";
		 }
}
