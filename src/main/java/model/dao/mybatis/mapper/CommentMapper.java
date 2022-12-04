package model.dao.mybatis.mapper;

import java.util.List;

import model.Comment;

public interface CommentMapper {
	List<Comment> selectCommentByTaskId(int taskId);
	
	String selectMemberNameByCommentId(int commentId);
	
	int insertComment(Comment comment);

	int updateComment(Comment comment);
	
	int deleteComment(int comment_id);
	
}
