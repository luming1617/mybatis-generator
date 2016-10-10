package com.liuluming.generic;

import java.util.List;

public class Pagination<T> {

	/**
	 * 默认每页最大记录数：10。
	 */
	public static final Integer DEFAULT_PAGE_SIZE = 10;

	/**
	 * 默认当前页：1。
	 */
	public static final Integer DEFAULT_CURRENT_PAGE = 1;

	/**
	 * 每页显示记录数
	 */
	private Integer pageSize;

	/**
	 * 查询结果总记录数
	 */
	private Integer totalRowNumber;

	/**
	 * 当前页码（从1算起）
	 */
	private Integer currentPage;

	/**
	 * 返回的数据集合
	 */
	private List<T> dataList;

	public Pagination() {
		this(DEFAULT_PAGE_SIZE, 1);
	}

	public Pagination(Integer pageSize, Integer currentPage) {
		this.totalRowNumber = 0;
		this.setPageSize(pageSize);
		this.setCurrentPage(currentPage);
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = (pageSize == null ? DEFAULT_PAGE_SIZE : pageSize);
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = (currentPage == null ? DEFAULT_CURRENT_PAGE : currentPage);
	}

	public void setTotalRowNumber(Integer totalRowNumber) {
		this.totalRowNumber = (totalRowNumber == null ? 0 : totalRowNumber);
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public Integer getBegin() {
		return (this.currentPage - 1) * this.pageSize;
	}

	public Integer getEnd() {
		return this.currentPage * this.pageSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getTotalRowNumber() {
		return this.totalRowNumber;
	}

	public int getTotalPageNumber() {
		return (int) Math.ceil((this.totalRowNumber * 1.0d) / this.pageSize);
	}

	public boolean isFirstPage() {
		return currentPage == 1;
	}

	public boolean isLastPage() {
		return currentPage >= (int) Math.ceil((this.totalRowNumber * 1.0d) / this.pageSize);
	}

	public List<T> getDataList() {
		return dataList;
	}

}