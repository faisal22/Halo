package com.paranoid.halo;

public class Package {
	private String packageName;
	private int customIcon;
	
	public Package(String packageName, int customIcon){
		this.packageName = packageName;
		this.customIcon = customIcon;
	}
	
	public String getPackageName(){
		return packageName;
	}

	public int getCustomIcon(){
		return customIcon;
	}
	
}
