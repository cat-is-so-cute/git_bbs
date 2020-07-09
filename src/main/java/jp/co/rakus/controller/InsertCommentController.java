package jp.co.rakus.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Comment;
import jp.co.rakus.form.CommentForm;
import jp.co.rakus.repository.CommentRepository;

public class InsertCommentController {
	@Autowired
	ShowBbsController showbbs;
	
	@Autowired
	CommentRepository commentRepository;
	
	@RequestMapping("/insertComment")
	public String insert(@Validated CommentForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorCommentArticleId", form.getArticleId());
			return showbbs.index(model);
		}
		
		Comment comment = new Comment();
		
		BeanUtils.copyProperties(form, comment);
		
		commentRepository.insert(comment);
		
		return "redirect:/article ";
	}
}
