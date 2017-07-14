package com.flip.connect.domain.model.account;

public class PublicProfileAccount {
	private String pictureUrl;
	private String name;

	public void setPictureUrl(String pictureUrl){
		this.pictureUrl = pictureUrl;
	}

	public String getPictureUrl(){
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
			"PublicProfileAccount{" +
			"pictureUrl = '" + pictureUrl + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}
