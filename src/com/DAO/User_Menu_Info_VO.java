package com.DAO;

public class User_Menu_Info_VO {
	private String Id;
	private String Store_Code;
	private String Order_Date;
	private String Menu_Code;
	private String Menu_Item_Div;
	private String Menu_Item_Cost;
	private String Menu_Input;

	//Constructor 필요하면 넣기 
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}
	public String getStore_Code() {
		return Store_Code;
	}
	public void setStore_Code(String store_Code) {
		Store_Code = store_Code;
	}
	public String getMenu_Code() {
		return Menu_Code;
	}
	public void setMenu_Code(String menu_Code) {
		Menu_Code = menu_Code;
	}
	public String getMenu_Item_Div() {
		return Menu_Item_Div;
	}
	public void setMenu_Item_Div(String menu_Item_Div) {
		Menu_Item_Div = menu_Item_Div;
	}
	public String getMenu_Item_Cost() {
		return Menu_Item_Cost;
	}
	public void setMenu_Item_Cost(String menu_Item_Cost) {
		Menu_Item_Cost = menu_Item_Cost;
	}
	public String getMenu_Input() {
		return Menu_Input;
	}
	public void setMenu_Input(String menu_Input) {
		Menu_Input = menu_Input;
	}
}
