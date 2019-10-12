package ca.sheridancollege.logic;

import ca.sheridancollege.beans.ColourBean;
//Model
public class ColourExpert {
	
	public ColourBean makeColourBean(String colour) {
		ColourBean test = new ColourBean();
		test.setName(colour);
		if(colour.equals("red")) {
			test.setFood("Tomato");
			test.setObject1("FireTruck");
			test.setObject2("Blood");
		}
		
		else if(colour.equals("green")) {
			test.setFood("Spinach");
			test.setObject1("Grass");
			test.setObject2("Green garden hose");
		}
		
		else if(colour.equals("blue")) {
			test.setFood("BlueBerry");
			test.setObject1("Pool Water");
			test.setObject2("Blue Crayon");
		}
		
		else if(colour.equals("yellow")) {
			test.setFood("Yellow Pepper");
			test.setObject1("Sunlight");
			test.setObject2("Sun Flower");
		}
		return test;
	}

}
