package com.dbjina.folderfilter;

import com.dbjina.folderfilter.inter.FilterLoader;
import com.dbjina.folderfilter.inter.FilterOrganizer;
import com.dbjina.folderfilter.vo.Filter;
import java.util.ArrayList;

public class FolderFilterManager {
	private FilterLoader filterLoader;
	private FilterOrganizer filterOrganizer;

	public FilterOrganizer getFilterOrganizer() {
		return this.filterOrganizer;
	}

	public void setFilterOrganizer(FilterOrganizer filterOrganizer) {
		this.filterOrganizer = filterOrganizer;
	}

	public FilterLoader getFilterLoader() {
		return this.filterLoader;
	}

	public void setFilterLoader(FilterLoader filterLoader) {
		this.filterLoader = filterLoader;
	}

	public void execute() {
		java.util.List<Filter> filterList = new ArrayList();
		filterList = this.filterLoader.load();

		this.filterOrganizer.organize(filterList);
	}
}