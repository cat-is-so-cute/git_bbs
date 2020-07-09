package jp.co.rakus.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Article;
import jp.co.rakus.form.ArticleForm;
import jp.co.rakus.repository.ArticleRepository;

@Controller
@RequestMapping("/article")
public class InsertArticleController {
	@Autowired
	private ArticleRepository repository;
	
	@Autowired
	private ShowBbsController showBbsController;
	
	
	/**
	 * 記事を投稿する.
	 * 
	 * @param form 記事投稿フォーム
	 * @return 掲示板画面
	 */
	@RequestMapping("/postArticle")
	public String insertArticle(@Validated ArticleForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return showBbsController.index(model);
		}
		Article article = new Article();
		BeanUtils.copyProperties(form, article);
		System.out.println(article);
		repository.insert(article);
		
		return showBbsController.index(model);
	}
}
