package jp.co.rakus.form;

import javax.validation.constraints.NotBlank;

public class ArticleFrom {
	@NotBlank(message = "名前が未入力です")
	private String name;
	@NotBlank(message = "投稿内容が未入力です")
	private String content;
	@Override
	public String toString() {
		return "ArticleFrom [name=" + name + ", content=" + content + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
