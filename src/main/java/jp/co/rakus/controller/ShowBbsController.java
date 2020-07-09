package jp.co.rakus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Article;
import jp.co.rakus.repository.ArticleRepository;

@Controller
@RequestMapping("")
public class ShowBbsController {
	@Autowired
	ArticleRepository repository;
	
	public String index(Model model) {
		List<Article> articles = repository.findAll();
		
		model.addAttribute("articles", articles);
		
		return "bbs";
	}
}
