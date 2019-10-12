package ca.sheridancollege.bean;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
public class Drink implements Serializable{
	
	private static final long serialVersionUID = 7603441811175150303L;
	
	String drinkName;
	String main;
	double mainAmount;
	String second;
	double secondAmount;
	String directions;
}
