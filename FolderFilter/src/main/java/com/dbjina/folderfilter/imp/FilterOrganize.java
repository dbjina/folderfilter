package com.dbjina.folderfilter.imp;

import com.dbjina.folderfilter.inter.FilterOrganizer;
import com.dbjina.folderfilter.vo.Filter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterOrganize implements FilterOrganizer {
    private String path;

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FilterOrganize(String path) {
        this.path = path;
    }

    @Override
    public void organize(List<Filter> filterList) {
        if (filterList.size() <= 0) {
            System.out.println("\ud544\ud130 \ubaa9\ub85d\uc774 \ube44\uc5b4 \uc788\uc2b5\ub2c8\ub2e4.");
            return;
        }
        File file = new File(this.path);
        File[] files = file.listFiles(File::isFile);
        HashMap<String, ArrayList<File>> moveMap = new HashMap<String, ArrayList<File>>();
        List<File> listFile = null;
        File[] arrfile = files;
        int n = arrfile.length;
        int n2 = 0;
        while (n2 < n) {
            File f = arrfile[n2];
            listFile = null;
            block1 : for (Filter filter : filterList) {
                for (String title : filter.getOtherTitle()) {
                    if (!f.getName().toLowerCase().contains(title)) continue;
                    listFile = moveMap.get(filter.getTitle());
                    if (listFile == null) {
                        listFile = new ArrayList<File>();
                    }
                    listFile.add(f);
                    moveMap.put(filter.getTitle(), (ArrayList<File>)listFile);
                    continue block1;
                }
            }
            ++n2;
        }
        for (String key : moveMap.keySet()) {
            File tmpFile = new File(String.valueOf(this.path) + "/" + key);
            if (!tmpFile.exists()) {
                tmpFile.mkdir();
            }
            listFile = (ArrayList<File>)moveMap.get(key);
            boolean result = false;
            for (File f : listFile) {
                result = f.renameTo(new File(String.valueOf(this.path) + "/" + key + "/" + f.getName()));
                if (result) {
                    System.out.println("[ " + f.getName() + " ] \uc774\ub3d9 \ub418\uc5c8\uc2b5\ub2c8\ub2e4.");
                    continue;
                }
                System.err.println("[ " + f.getName() + " ] \uc774\ub3d9 \uc2e4\ud328\ud588\uc2b5\ub2c8\ub2e4.");
            }
        }
    }
}