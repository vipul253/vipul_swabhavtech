package com.techlabs.human;

public class Human {
	private String name;
	private float height;
	private float weight;
	private Gender gender;

	public Human(String name, float height, float weight, Gender gender) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
	}

	public Human(String name, Gender gender) {
		this(name, 5f, 50f, gender);
	}

	public void play() {
		this.height += 0.25f;
		this.weight -= 0.35f;
	}

	public void eat() {
		this.weight += 0.5f;
	}

	public float calcBMI() {
		float f = this.height * 0.3048f;
		return this.weight / (f * f);
	}

	public BMIcategory category() {
		float f = this.calcBMI();
		if (f < 18.5f)
			return BMIcategory.UNDER_WEIGHT;
		else if (f >= 18.5f && f <= 24.9f)
			return BMIcategory.HEALTHY;
		else if (f > 24.9f && f < 30f)
			return BMIcategory.OVER_WEIGHT;
		else
			return BMIcategory.OBESSE;
	}

	@Override
	public String toString() {
		String newstr = "[name:" + this.name + " H:" + this.height + " W:"
				+ this.weight + " Gender:" + this.gender + " BMI:"
				+ this.calcBMI() + " category:" + this.category() + "]" + "\n";
		newstr += "[" + super.toString() + "]";
		return newstr;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public float getHeight() {
		return height;
	}

	public float getWeight() {
		return weight;
	}

	public Gender getGender() {
		return gender;
	}
}