package common;

import java.util.List;

public class MyPage<T> {
    private  Integer pageNo;//当前页
    private  Integer pageSize;//页面大小
    private  Integer pageCount;//页面总数
    private  Integer total;//总个例数
    private  Boolean isFirst;//第一页
    private  Boolean isLast;//最后一页
    private  Boolean isHavePrevious;//上一页
    private  Boolean isHaveNext;//下一页
    private  Integer startPage;//起始页
    private  Integer endPage;//结束页

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public Boolean getHavePrevious() {
        return isHavePrevious;
    }

    public void setHavePrevious(Boolean havePrevious) {
        isHavePrevious = havePrevious;
    }

    public Boolean getHaveNext() {
        return isHaveNext;
    }

    public void setHaveNext(Boolean haveNext) {
        isHaveNext = haveNext;
    }

    private List<T> list;

    public MyPage(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.pageCount = (total%pageSize==0)?(total/pageSize):(total/pageSize+1);
        this.total = total;
        if(this.pageNo==1){
            this.isFirst=true;
        }
        if(this.pageNo == pageCount){
            this.isLast = true;
        }
        if(this.pageNo!=this.pageCount){
            this.isHaveNext = true;
        }
        if(this.pageNo != 1){
            this.isHavePrevious = true;
        }
        if(this.pageNo == 1|| this.pageNo == 2 || this.pageNo == 3){
            this.startPage = 1;
            this.endPage = this.pageCount<5?this.pageCount:5;
        }else if( this.pageNo == this.pageCount || this.pageNo == this.pageCount-1|| this.pageNo == this.pageCount-2 || this.pageNo == this.pageCount-3){
            this.startPage = this.pageCount>5?this.pageCount-4:1;
            this.endPage = this.pageCount;
        }else {
            this.startPage = this.pageNo -2;
            this.endPage = this.pageNo + 2;
        }
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MyPage{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
