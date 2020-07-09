package jp.co.rakus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.repository.ArticleRepository;

@Controller
@RequestMapping("/delete")
public class DeleteArticleController {
	@Autowired
	private ArticleRepository repository;
	
	@Autowired
	private ShowBbsController showBbsController;
	
	/**
	 * 投稿記事を削除する.
	 * 
	 * @param id 投稿ID
	 * @return 掲示板画面
	 */
	@RequestMapping("/delete")
	public String deleteArticle(Integer articleId, Model model) {
//		commentRepository.deleteByArticleId(articleId);
		repository.deleteById(articleId);
		return showBbsController.index(model);
	}
}
