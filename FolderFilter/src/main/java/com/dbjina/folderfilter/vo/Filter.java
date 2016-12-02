package com.dbjina.folderfilter.vo;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Filter {
	@SerializedName("title")
	private String title;
	@SerializedName("otherTitle")
	private List<String> otherTitle;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getOtherTitle() {
		return this.otherTitle;
	}

	public void setOtherTitle(List<String> otherTitle) {
		this.otherTitle = otherTitle;
	}
}
