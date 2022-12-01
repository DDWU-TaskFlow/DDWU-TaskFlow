package model.dao.mybatis.mapper;

import java.util.List;

public interface ThreadMapper {
	List<Thread> selectThreadByTaskId(int taskId);
	
	int insertThread(Thread thread);

	int updateThread(Thread thread);
	
	int deleteThread(int threadNumber);
	
}
