package com.xbh.bos.domain.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * @author xbh
 * @date
 * @Description
 */
public class PageVO implements Serializable {
	private static final long serialVersionUID = -7294149768946720488L;
	@Expose(serialize = false, deserialize = false)
	private Integer currentPage;
	@Expose(serialize = false, deserialize = false)
	private Integer CurrentRowsTotal;

	private Integer limitStartIndex;
	private Integer limitEndIndex;

	private Long total;
	private List rows;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getrows() {
		return rows;
	}

	public void setrows(List rows) {
		this.rows = rows;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getCurrentRowsTotal() {
		return CurrentRowsTotal;
	}

	public void setCurrentRowsTotal(Integer currentRowsTotal) {
		CurrentRowsTotal = currentRowsTotal;
	}

	public Integer getLimitStratIndex() {
		return limitStartIndex;
	}

	public void setLimitStratIndex(Integer limitStratIndex) {
		this.limitStartIndex = limitStratIndex;
	}

	public Integer getLimitEndIndex() {
		return limitEndIndex;
	}

	public void setLimitEndIndex(Integer limitEndIndex) {
		this.limitEndIndex = limitEndIndex;
	}

	@Override
	public String toString() {
		return "PageVO{" +
			"total=" + total +
			", rows=" + rows +
			'}';
	}
}
