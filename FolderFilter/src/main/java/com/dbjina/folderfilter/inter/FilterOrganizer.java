package com.dbjina.folderfilter.inter;

import com.dbjina.folderfilter.vo.Filter;
import java.util.List;

public abstract interface FilterOrganizer {
	void organize(List<Filter> paramList);
}