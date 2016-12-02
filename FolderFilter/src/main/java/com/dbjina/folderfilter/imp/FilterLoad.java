package com.dbjina.folderfilter.imp;

import com.dbjina.folderfilter.inter.FilterLoader;
import com.dbjina.folderfilter.vo.Filter;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

public class FilterLoad implements FilterLoader {
	private String filterPath;

	public String getFilterPath() {
		return this.filterPath;
	}

	public void setFilterPath(String filterPath) {
		this.filterPath = filterPath;
	}

	public FilterLoad(String filterPath) {
		this.filterPath = filterPath;
	}

	public List<Filter> load() {
		Gson gson = new Gson();
		JsonReader reader = null;
		List<Filter> filterList = null;

		try {
			reader = new JsonReader(new InputStreamReader(new FileInputStream(this.filterPath), "UTF8"));

			Type collectionType = new com.google.gson.reflect.TypeToken<Filter>() {
			}.getType();
			filterList = gson.fromJson(reader, collectionType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return filterList;
	}
}
