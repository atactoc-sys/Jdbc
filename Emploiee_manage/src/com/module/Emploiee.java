package com.module;

public class Emploiee {
	private int id;
    private String name;
    private String designation;
    private String city;
    private double salary;

    public Emploiee(){

    }

    public Emploiee(String name, String designation, String city, double salary) {
        this.name = name;
        this.designation = designation;
        this.city = city;
        this.salary = salary;
    }

    public Emploiee(int id, String name, String designation, String city, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.city = city;
        this.salary = salary;
    }
    
    

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }
}

