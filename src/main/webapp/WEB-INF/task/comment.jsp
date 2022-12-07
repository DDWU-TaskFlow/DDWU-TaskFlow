<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="border">
	
	<c:set var="taskId" value="${param.taskId}" />
	<c:set var="commentList" value="${commentManager.findCommentByTaskId(taskId)}" />
	<c:forEach var="comment" items="${commentList}">
		<c:set var="comId" value="${comment.commentId}" />
	
		<div class="d-flex pt-3 border justify-content-center align-items-center">
	      <span class="d-block rounded-pill pb-3" style="width: 50px;">
			<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="#7c78c0" class="bi bi-wechat" viewBox="0 0 16 16">
			  <path d="M11.176 14.429c-2.665 0-4.826-1.8-4.826-4.018 0-2.22 2.159-4.02 4.824-4.02S16 8.191 16 10.411c0 1.21-.65 2.301-1.666 3.036a.324.324 0 0 0-.12.366l.218.81a.616.616 0 0 1 .029.117.166.166 0 0 1-.162.162.177.177 0 0 1-.092-.03l-1.057-.61a.519.519 0 0 0-.256-.074.509.509 0 0 0-.142.021 5.668 5.668 0 0 1-1.576.22ZM9.064 9.542a.647.647 0 1 0 .557-1 .645.645 0 0 0-.646.647.615.615 0 0 0 .09.353Zm3.232.001a.646.646 0 1 0 .546-1 .645.645 0 0 0-.644.644.627.627 0 0 0 .098.356Z"/>
			  <path d="M0 6.826c0 1.455.781 2.765 2.001 3.656a.385.385 0 0 1 .143.439l-.161.6-.1.373a.499.499 0 0 0-.032.14.192.192 0 0 0 .193.193c.039 0 .077-.01.111-.029l1.268-.733a.622.622 0 0 1 .308-.088c.058 0 .116.009.171.025a6.83 6.83 0 0 0 1.625.26 4.45 4.45 0 0 1-.177-1.251c0-2.936 2.785-5.02 5.824-5.02.05 0 .1 0 .15.002C10.587 3.429 8.392 2 5.796 2 2.596 2 0 4.16 0 6.826Zm4.632-1.555a.77.77 0 1 1-1.54 0 .77.77 0 0 1 1.54 0Zm3.875 0a.77.77 0 1 1-1.54 0 .77.77 0 0 1 1.54 0Z"/>
			</svg>
	      </span>
	      <p>
	        <span class="d-flex rounded-pill justify-content-center" style="width: 300px;">
	        	${comment.writtenDate}
	        	<strong class="ms-3">|&nbsp;${commentManager.findMemberNameByCommentId(comId)}&nbsp;|</strong>
	        </span>
	        <span class="d-block rounded-pill text-center" style="max-width: 300px;">"${comment.content}"</span>
	      </p>
	    </div>
	    
	</c:forEach>
    
    </div>
    
    <div class="pt-4">
    <div class="input-group">
	  <span class="input-group-text">COMMENT</span>
	  <textarea class="form-control" aria-label="With textarea"></textarea>
  	  <button class="btn btn-outline-secondary" type="button" style="width: 62px;">
		<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-telegram" viewBox="0 0 16 16">
		  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.287 5.906c-.778.324-2.334.994-4.666 2.01-.378.15-.577.298-.595.442-.03.243.275.339.69.47l.175.055c.408.133.958.288 1.243.294.26.006.549-.1.868-.32 2.179-1.471 3.304-2.214 3.374-2.23.05-.012.12-.026.166.016.047.041.042.12.037.141-.03.129-1.227 1.241-1.846 1.817-.193.18-.33.307-.358.336a8.154 8.154 0 0 1-.188.186c-.38.366-.664.64.015 1.088.327.216.589.393.85.571.284.194.568.387.936.629.093.06.183.125.27.187.331.236.63.448.997.414.214-.02.435-.22.547-.82.265-1.417.786-4.486.906-5.751a1.426 1.426 0 0 0-.013-.315.337.337 0 0 0-.114-.217.526.526 0 0 0-.31-.093c-.3.005-.763.166-2.984 1.09z"/>
		</svg>
	  </button>
	</div>
</div>
