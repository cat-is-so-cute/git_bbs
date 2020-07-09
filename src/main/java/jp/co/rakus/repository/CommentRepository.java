package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.Comment;

/**
 * コメントのDBを扱うためのレポジトリです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Repository
public class CommentRepository {
	/**
	 * コメントのRowMapperを定義します.
	 */
	private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
		Comment comment = new Comment();
		
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));
		
		return comment;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 記事IDが一致するコメントを全て検索します.
	 * 
	 * @param articleId
	 * 					検索する記事ID
	 * @return
	 * 					記事IDが一致したコメントをリスト形式で返します。
	 */
	public List<Comment> findByArticleId(int articleId) {
		String sql = "SELECT id, name, content, article_id FROM comments WHERE article_id = :articleId ORDER BY id DESC;";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("articleId", articleId);
		
		return template.query(sql, param, COMMENT_ROW_MAPPER);
	}
	
	/**
	 * コメントの挿入を行うためのメソッドです.
	 * 
	 * @param comment
	 * 				挿入を行いたいコメントです.
	 */
	public void insert(Comment comment) {
		String sql = "INSERT INTO comments (name, content, article_id) VALUES (:name, :content, :articleId);";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("name", comment.getName()).addValue("content", comment.getContent()).addValue("articleId", comment.getArticleId());
		
		template.update(sql, param);
	}
	
	/**
	 * 記事IDが一致するコメントを削除するメソッドです.
	 * 
	 * @param articleId
	 * 					記事ID
	 */
	public void deleteByArticleId(int articleId) {
		String sql = "DELETE FROM comments WHERE article_id = :articleId";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("articleId", articleId);
		
		template.update(sql, param);
	}
}
