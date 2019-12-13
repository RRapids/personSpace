package com.soft7.web.personSpace.util;

public class SplitPage {
    //分页请求时，请求标识参数
    final public static String FirstPAGE = "first";//第一页
    final public static String PreviousPAGE = "previous";//上一页
    final public static String NextPAGE = "next";//下一页
    final public static String LastPAGE = "last";//最后一页

    private int pageRows = 5;//每一页显示的记录,默认10条,可以在页面设置
    private int totalRows = 0;//总的记录数，这个参数由NoteDAO提供
    private int currentPage = 1;//当前显示的页面编号，默认第一
    private int totalPages = 1;//总的页面数，默认就一页
    private int firstPage = 1;//首页位置，默认第一页

    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        if (pageRows == 0) {
            throw new ArithmeticException();//如果pageRows被设置为0，则显示异常
        }
        this.pageRows = pageRows;
        this.totalPages = (this.totalRows % this.pageRows == 0) ? this.totalRows / this.pageRows : this.totalRows / this.pageRows + 1;
    }

    public int getTotalRows() {
        return totalRows;

    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        //计算总的页面数（或最后的页面号），
        this.totalPages = (this.totalRows % this.pageRows == 0) ? this.totalRows / this.pageRows : this.totalRows / this.pageRows + 1;

    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    //根据请求页面的标识参数，重新计算当前要显示的页面
    //核心方法，实现分页显示功能
    public int confirmPage(String flag) {
        int newPage = this.currentPage;
        if (flag != null) {
            if (flag.equals(SplitPage.FirstPAGE)) {
                newPage = 1;
            } else if (flag.equals(SplitPage.PreviousPAGE)) {
                if (this.currentPage == this.firstPage) {
                    newPage = currentPage;
                } else {
                    newPage = this.currentPage - 1;
                }
            } else if (flag.equals(SplitPage.NextPAGE)) {
                if (this.totalPages == this.currentPage) {
                    newPage = this.currentPage;
                } else {
                    newPage = this.currentPage + 1;
                }
            } else if (flag.equals(SplitPage.LastPAGE)) {
                newPage = this.totalPages;
            } else {//否则就是一个数字的字符串
                int tpage = Integer.parseInt(flag.trim());
                newPage = tpage;
            }
        } else {
            newPage = this.currentPage;
        }
        this.setCurrentPage(newPage);
        return newPage;
    }
}
