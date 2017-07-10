package com.flip.connect.domain.model.user;

public class PublicProfile{
	private Object pictureUrl;
	private String name;

	public void setPictureUrl(Object pictureUrl){
		this.pictureUrl = pictureUrl;
	}

	public Object getPictureUrl(){
		return pictureUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"PublicProfile{" + 
			"pictureUrl = '" + pictureUrl + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}
