package com.pjmb.wonka.controller;

import com.pjmb.wonka.entity.Product;
import com.pjmb.wonka.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService theProductService) {
		productService = theProductService;
	}

	@GetMapping("/")
	public String showMainPage(Model theModel) {
		List<Product> theProducts = productService.findAll();
		// add to the spring model
		theModel.addAttribute("products", theProducts);
		return "index";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Product theProduct = new Product();
		theModel.addAttribute("product", theProduct);
		return "product-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int id, Model theModel) {
		Product theProduct = productService.findById(id);
		theModel.addAttribute("product", theProduct);
		return "product-form";
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int id) {
		productService.deleteById(id);
		return "redirect:/";

	}
}









