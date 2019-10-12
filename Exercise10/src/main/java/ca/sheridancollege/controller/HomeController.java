package ca.sheridancollege.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.bean.Drink;
import ca.sheridancollege.database.DatabaseAccess;

@Controller
public class HomeController {
	
	@Autowired private DatabaseAccess da;
	
	@GetMapping("/")
	public String getHomePage() {
		return "addDrinks.html";
	}
	
	@GetMapping("/Drinks")
	public String showAddedDrink(@RequestParam String drinkName, @RequestParam String drinkMain,
			@RequestParam double drinkMainAmount, @RequestParam String drinkSecond, 
			@RequestParam double drinkSecondAmount, @RequestParam String drinkDirections,
			Model model) {
		Drink newDrink = new Drink();
		newDrink.setDrinkName(drinkName);
		newDrink.setMain(drinkMain);
		newDrink.setMainAmount(drinkMainAmount);
		newDrink.setSecond(drinkSecond);
		newDrink.setSecondAmount(drinkSecondAmount);
		newDrink.setDirections(drinkDirections);
		da.addDrink(newDrink);
		ArrayList<Drink> d = new ArrayList<Drink>();
		d.addAll(da.showDrinks());
		model.addAttribute("drinks", d);
		return "showDrinks.html";
	}
}
