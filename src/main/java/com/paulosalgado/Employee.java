package com.paulosalgado;

public class Employee {
	
	private Long id;
    private String title;
    private String name;
	
    public Employee() { }
    
    public Employee(Long id, String title, String name) {
		this.id = id;
		this.title = title;
		this.name = name;
	}
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", title=" + title + ", name=" + name + "]";
	}
	
}
