package org.deborahbarndt.itmd566.deborah.model;

public class Link {
	
	public Link() {}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	private String url;
	private String rel;

}
