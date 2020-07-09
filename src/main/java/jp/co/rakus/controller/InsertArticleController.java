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
import jp.co.rakus.form.ArticleFrom;
import jp.co.rakus.repository.ArticleRepository;

@Controller
@RequestMapping("/insert")
public class InsertArticleController {
	@Autowired
	private ArticleRepository repository;
	
	@Autowired
	private ShowBbsController showBbsController;
	
	@ModelAttribute
	public ArticleFrom setUpArticleForm() {
		return new ArticleFrom();
	}
	
	/**
	 * 記事を投稿する.
	 * 
	 * @param form 記事投稿フォーム
	 * @return 掲示板画面
	 */
	@RequestMapping("")
	public String insertArticle(@Validated ArticleFrom form, BindingResult result, Model model) {
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
