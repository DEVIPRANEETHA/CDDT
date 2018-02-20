package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.niit.backend.DAO.ProductDao;
import com.niit.backend.models.ProductModel;

@Controller
public class ProductController {
	@Autowired
	ProductDao productdao;
	 @Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10240000);
		return multipartResolver;
	} 
	@RequestMapping(value="Add")
	public String productMethod(Model model) {
		ProductModel productmodel=new ProductModel();
		model.addAttribute("user",productmodel);
		return "AddProducts";
	}
	@RequestMapping(value="Product")
	public String addProducts(@ModelAttribute("user") ProductModel productmodel) {		
		productdao.product(productmodel);
		MultipartFile image=productmodel.getImage();
		if(image!=null && !image.isEmpty()) {
			Path path=Paths.get("C:\\Users\\DELL\\Desktop\\Project Workspace\\NIIT_Project\\src\\main\\webapp\\resources\\images\\"+productmodel.getId()+".jpg");
			try {
				image.transferTo(new File(path.toString()));
			}
			catch(IllegalStateException e){
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return "AdminPage";
	}
	
}
