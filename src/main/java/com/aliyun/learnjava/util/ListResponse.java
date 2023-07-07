package com.aliyun.learnjava.util;

import java.util.List;

public class ListResponse<T> {
    private long total;
    private List<T> list;

    public ListResponse(long total,List<T>list){
        this.list = list;
        this.total = total;
    }
    public List<T> getList() {
        return list;
    }
    public long getTotal() {
        return total;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public void setTotal(long total) {
        this.total = total;
    }

}
