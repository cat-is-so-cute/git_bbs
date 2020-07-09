package jp.co.rakus.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * コメントの投稿を受け取るフォームクラスです.
 * 
 * @author ryosuke.nakanishi
 *
 */
public class CommentForm {
	/** コメント者名 */
	@NotBlank(message = "コメント者名を入力して下さい")
	@Size(max = 50, message = "コメント者名は50字以内で入力して下さい")
	private String name;
	/** コメント内容 */
	@NotBlank(message = "コメント内容を入力して下さい")
	private String content;
	/** 記事ID */
	private Integer articleId;

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

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	@Override
	public String toString() {
		return "CommentForm [name=" + name + ", content=" + content + ", articleId=" + articleId + "]";
	}

}
