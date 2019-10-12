package ca.sheridancollege.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.bean.Drink;

@Repository
public class DatabaseAccess {
	
	@Autowired protected NamedParameterJdbcTemplate jdbc;
	
	public void addDrink(Drink drink) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO easy_drinks VALUES " +
		"(:name, :main, :a1, :second, :a2, :directions)";
		parameters.addValue("name", drink.getDrinkName());
		parameters.addValue("main", drink.getMain());
		parameters.addValue("a1", drink.getMainAmount());
		parameters.addValue("second", drink.getSecond());
		parameters.addValue("a2", drink.getSecondAmount());
		parameters.addValue("directions", drink.getDirections());
		jdbc.update(query, parameters);
	}
	
	public ArrayList<Drink> showDrinks() {
		String q = "Select * from easy_drinks";
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		
		List<Map<String, Object>> rows = jdbc.queryForList(q, new HashMap<String, Object>());
		for(Map<String, Object> row : rows) {
			Drink d = new Drink();
			d.setDrinkName((String)(row.get("drink_name")));
			d.setMain((String)(row.get("main")));
			d.setMainAmount((((BigDecimal) (row.get("amount1"))).doubleValue()));
			d.setSecond((String)(row.get("second")));
			d.setSecondAmount(((BigDecimal)(row.get("amount2"))).doubleValue());
			drinks.add(d);
		}
		return drinks;
	}
}
