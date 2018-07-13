package pages;

import com.github.javafaker.Faker;

public class fakerdene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faker faker = new Faker();
		int cardSelect = faker.number().numberBetween(1, 4);
		System.out.println(cardSelect);
	}

}
