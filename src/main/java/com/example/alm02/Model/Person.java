package com.example.alm02.Model;

public class Person {
    private String name;
    private String nationality;
    private String ethnicity;
    private int birth;
    private int gender;

	public Person(String name, String nationality, String ethnicity, int birth, int gender) {
        this.name = name;
        this.nationality = nationality;
        this.ethnicity = ethnicity;
        this.birth = birth;
        this.gender = gender;
	}
	public Person() {
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setGender(int gender){
		this.gender = gender;
	}
	public int getGender() {
		return gender;
	}
	public void setBirth(int birth){
		this.birth = birth;
	}
	public int getBirth() {
		return birth;
	}
	public void setEthnicity(String ethnicity){
		this.ethnicity = ethnicity;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setNationality(String nationality){
		this.nationality = nationality;
	}
	public String getNationality() {
		return nationality;
	}
}
