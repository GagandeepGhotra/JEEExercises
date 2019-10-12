package ca.sheridancollege.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.ColourBean;
import ca.sheridancollege.logic.ColourExpert;

//Controller
@Controller
public class HomeController {

	@GetMapping("/SelectColour.do")
	public String doColourProcess(@RequestParam String colour, Model model) {
		ColourExpert ce = new ColourExpert();
		ColourBean colourbean = ce.makeColourBean(colour);
		
		model.addAttribute("colourBean", colourbean);
		return "showColours.html";
	}
}
