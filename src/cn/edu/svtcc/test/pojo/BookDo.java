package cn.edu.svtcc.test.pojo;

public class BookDo {
	private Integer id;
	private String title;
	private String author;
	private Integer publisherId;
	private String  publishDate;
	private String isbn;
	private Integer wordsCount;
	private Float untiPrice;
	private String contentDescription;
	private String aurhorDescription;
	private String editorComment;
	private String toc;
	private Integer categorId;
	private Integer clicks;
	
	
	public BookDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookDo [id=" + id + ", title=" + title + ", author=" + author + ", publisherId=" + publisherId
				+ ", publishDate=" + publishDate + ", isbn=" + isbn + ", wordsCount=" + wordsCount + ", untiPrice="
				+ untiPrice + ", contentDescription=" + contentDescription + ", aurhorDescription=" + aurhorDescription
				+ ", editorComment=" + editorComment + ", toc=" + toc + ", categorId=" + categorId + ", clicks="
				+ clicks + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getWordsCount() {
		return wordsCount;
	}
	public void setWordsCount(Integer wordsCount) {
		this.wordsCount = wordsCount;
	}
	public Float getUntiPrice() {
		return untiPrice;
	}
	public void setUntiPrice(Float untiPrice) {
		this.untiPrice = untiPrice;
	}
	public String getContentDescription() {
		return contentDescription;
	}
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}
	public String getAurhorDescription() {
		return aurhorDescription;
	}
	public void setAurhorDescription(String aurhorDescription) {
		this.aurhorDescription = aurhorDescription;
	}
	public String getEditorComment() {
		return editorComment;
	}
	public void setEditorComment(String editorComment) {
		this.editorComment = editorComment;
	}
	public String getToc() {
		return toc;
	}
	public void setToc(String toc) {
		this.toc = toc;
	}
	public Integer getCategorId() {
		return categorId;
	}
	public void setCategorId(Integer categorId) {
		this.categorId = categorId;
	}
	public Integer getClicks() {
		return clicks;
	}
	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}
	
	

}
