package com.hibernate.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity 
@Table(name = "city")
public class City {

	@Id	 @Column(name = "ID") 
	
	private int id;

	@Column(name = "Population")
	private int population;

	@Column(name = "Name")
	private String name;

	@Column(name = "CountryCode")
	private String countryCode;

	@Column(name = "District")
	private String district;
	
	
	@Embedded
	private Adress adress;
	
	@Embedded
	@AttributeOverrides({
		
		@AttributeOverride(name = "street" , column= @Column(name = "HomeStreet") ),
		@AttributeOverride(name ="state" , column = @Column(name ="HomeState")),
		@AttributeOverride(name = "pincode" , column = @Column(name = "HomePinCode") )
		
	})
	private Adress homeAdress;
	
	
	@ElementCollection
	private Set<Adress> ListOfAdresses = new HashSet(); 
	
	

	public Set<Adress> getListOfAdresses() {
		return ListOfAdresses;
	}

	public void setListOfAdresses(Set<Adress> ListOfAdresses) {
		this.ListOfAdresses = ListOfAdresses;
	}

	public Adress getHomeAdress() {
		return homeAdress;
	}

	public void setHomeAdress(Adress homeAdress) {
		this.homeAdress = homeAdress;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public City() {
	}

	public City(int id, int population, String name, String countryCode, String district) {
		super();
		this.id = id;
		this.population = population;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String disrtrict) {
		this.district = disrtrict;
	}

}
