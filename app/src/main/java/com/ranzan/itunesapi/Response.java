package com.ranzan.itunesapi;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("resultCount")
	private Integer resultCount;

	@SerializedName("results")
	private List<ResultsItem> results;

	public Integer getResultCount(){
		return resultCount;
	}

	public List<ResultsItem> getResults(){
		return results;
	}
}