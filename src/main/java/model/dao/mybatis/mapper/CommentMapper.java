package model.dao.mybatis.mapper;

import java.util.List;

import model.Comment;

public interface CommentMapper {
	List<Comment> selectCommentByTaskId(int taskId);
	
	int insertComment(Comment comment);

	int updateComment(Comment comment);
	
	int deleteComment(int comment_id);
	
}
