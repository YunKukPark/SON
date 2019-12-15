package com.DAO;

public class MenuVO {
	private String Store_Code;
	private String Menu_Code;
	private String Menu_Item_Div;
	private String Menu_Item_Hot;
	private String Menu_Item_Cost;
	private String Menu_Item_Intro;
	private String Menu_Item_Img;
	private String Menu_Material;

	public MenuVO(String Store_Code, String menu_Code, String menu_Item_Cost) {
		this.Store_Code = Store_Code;
		this.Menu_Code = menu_Code;
		this.Menu_Item_Cost = menu_Item_Cost;
	}
	
	public MenuVO(String menu_Code, String menu_Item_Cost) {
		super();
		this.Menu_Code = menu_Code;
		this.Menu_Item_Cost = menu_Item_Cost;
	}
	
	public MenuVO() {
		
	}
	



	
	//만드는데 Constructor 필요하면 넣어야지
	
	
	
	public String getStore_Code() {
		return Store_Code;
	}
	public void setStore_Code(String store_Code) {
		this.Store_Code = store_Code;
	}
	public String getMenu_Code() {
		return Menu_Code;
	}
	public void setMenu_Code(String menu_Code) {
		this.Menu_Code = menu_Code;
	}
	public String getMenu_Item_Div() {
		return Menu_Item_Div;
	}
	public void setMenu_Item_Div(String menu_Item_Div) {
		this.Menu_Item_Div = menu_Item_Div;
	}
	public String getMenu_Item_Hot() {
		return Menu_Item_Hot;
	}
	public void setMenu_Item_Hot(String menu_Item_Hot) {
		this.Menu_Item_Hot = menu_Item_Hot;
	}
	public String getMenu_Item_Cost() {
		return Menu_Item_Cost;
	}
	public void setMenu_Item_Cost(String menu_Item_Cost) {
		this.Menu_Item_Cost = menu_Item_Cost;
	}
	public String getMenu_Item_Intro() {
		return Menu_Item_Intro;
	}
	public void setMenu_Item_Intro(String menu_Item_Intro) {
		this.Menu_Item_Intro = menu_Item_Intro;
	}
	public String getMenu_Item_Img() {
		return Menu_Item_Img;
	}
	public void setMenu_Item_Img(String menu_Item_Img) {
		this.Menu_Item_Img = menu_Item_Img;
	}
	public String getMenu_Material() {
		return Menu_Material;
	}
	public void setMenu_Material(String menu_Material) {
		this.Menu_Material = menu_Material;
	}
	
	
}
