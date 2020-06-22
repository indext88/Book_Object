package cn.edu.svtcc.test.service;

import java.util.List;

public class PageBean<T> {
	private int pageNum;// 当前页
	private int pageSize;// 每页显示的数据条数
	private int totalRecord;// 总的记录数
	private int totalPage;// 总页数
	private int startIndex;// 当前页开始的下标

	private List<T> datas;// 显示的数据集合

	private int start;

	private int end;

	public PageBean(int pageNum, int pageSize, int totalRecord, List<T> datas) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.datas = datas;

		// totalPage总页数
		if (totalRecord % pageSize == 0) {
			// 如果整除，显示pagesize条数据，没有多余一页要显示少于pageSize条数据
			this.totalPage = totalRecord / pageSize;
		} else {
			this.totalPage = totalRecord / pageSize + 1;
		}
		this.startIndex = (pageNum - 1) * pageSize;
		this.start = 1;// 开始显示的页数
		this.end = 5;// 最多显示5页

		if (totalPage <= 5) {
			// 总页数小于5,end就为总页数
			this.end = this.totalPage;
		} else {
			// 总页数大于5，根据当前是第几页来判断start与end为多少
			this.start = pageNum - 2;
			this.end = pageNum + 2;

			if (start <= 0) {
				// 如果当前页是第一页那么不符合这个规则
				this.start = 1;
				this.end = 5;
			}
			if (end > this.totalPage) {
				// 当前页为第2页或最后一页，也不符合
				this.end = totalPage;
				this.start = end - 5;
			}

		}

	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
