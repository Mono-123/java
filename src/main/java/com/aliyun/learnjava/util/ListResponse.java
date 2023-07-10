package com.aliyun.learnjava.util;

import java.util.List;

public class ListResponse<T> {
    private List<T> list;
    private Integer total;

    public ListResponse(Integer total,List<T>list){
        this.list = list;
        this.total = total;
    }
    public List<T> getList() {
        return list;
    }
    public Integer getTotal() {
        return total;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

}
