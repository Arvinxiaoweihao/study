package com.thunisoft.shop.domain.query;

/**
 * 分页实体
 * @author Administrator 
 * @date 2018年7月5日 下午9:50:33 
 * @version v1.0
 */
public class PageQuery {

    /**首页*/
    private Integer firstPage = 1;

    /**上一页*/
    private Integer upPage;

    /**下一页*/
    private Integer downPage;

    /**尾页*/
    private Integer endPage;

    /**当前页*/
    private Integer currentPage = 1;

    /**每页显示多少行*/
    private Integer pageSize = 10;

    /**总共多少行数据*/
    private Integer totalCount;

    /**总共多少页*/
    private Integer totalPages;

    /**
     * 无参构造器
     */
    public PageQuery() {
        
    }

    /**
     * 设置当前值
     * @param currentPage 当前页
     * @param pageSize 每页显示多少行
     * @param totalCount 总共多少行数据
     */
    public void setCurrentValue(Integer currentPage,Integer pageSize, Integer totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        Integer trade = totalCount/pageSize;
        this.endPage = totalCount % pageSize == 0 ? trade : trade+1;
        this.totalPages = this.endPage;

        this.upPage = currentPage > 1 ? currentPage-1 : currentPage;
        this.downPage = currentPage < this.endPage ? currentPage+1 : currentPage;

    }
    

    /**
     * @return the firstPage
     */
    public Integer getFirstPage() {
        return firstPage;
    }

    /**
     * @param firstPage the firstPage to set
     */
    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    /**
     * @return the upPage
     */
    public Integer getUpPage() {
        return upPage;
    }

    /**
     * @param upPage the upPage to set
     */
    public void setUpPage(Integer upPage) {
        this.upPage = upPage;
    }

    /**
     * @return the downPage
     */
    public Integer getDownPage() {
        return downPage;
    }

    /**
     * @param downPage the downPage to set
     */
    public void setDownPage(Integer downPage) {
        this.downPage = downPage;
    }

    /**
     * @return the endPage
     */
    public Integer getEndPage() {
        return endPage;
    }

    /**
     * @param endPage the endPage to set
     */
    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    /**
     * @return the currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return the totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /** (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PageQuery [firstPage=" + firstPage + ", upPage=" + upPage
                + ", downPage=" + downPage + ", endPage=" + endPage
                + ", currentPage=" + currentPage + ", pageSize=" + pageSize
                + ", totalCount=" + totalCount + ", totalPages=" + totalPages
                + "]";
    }
    
    

}
