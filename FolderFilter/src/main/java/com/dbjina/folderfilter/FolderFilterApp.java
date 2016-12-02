package com.dbjina.folderfilter;

import com.dbjina.folderfilter.imp.FilterOrganize;

public class FolderFilterApp {
	public static void main(String[] args) {
		FolderFilterManager manager = new FolderFilterManager();
		String currentPath = System.getProperty("user.dir");
		System.out.println(currentPath);
		com.dbjina.folderfilter.inter.FilterLoader loader = new com.dbjina.folderfilter.imp.FilterLoad(
				currentPath + "/filter.json");
		FilterOrganize organizer = new FilterOrganize(currentPath);

		manager.setFilterLoader(loader);
		manager.setFilterOrganizer(organizer);

		manager.execute();
	}
}