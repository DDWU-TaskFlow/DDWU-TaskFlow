package model.dao.test;

import java.util.Iterator;
import java.util.List;

import model.Member;
import model.dao.jdbc.ProjectDao;

public class ProjectDaoTest {
	public static void main(String[] args) {
		ProjectDao projectDao = new ProjectDao();

		// getPorjectList()
		System.out.println(projectDao.getProjectList());

		// findProject(id)
		System.out.println(projectDao.findProject(100));


		// findMembersInProject
		try {
			List<Member> memList = projectDao.findMembersInProject(100);

			System.out.println("아이디      비밀번호      이름      이메일      전화번호       생일");
			System.out.println("------------------------------------------");

			Iterator<Member> iter2 = memList.iterator();
			while(iter2.hasNext()) {
				Member m = iter2.next();
				System.out.printf("%d %10s %10s %10s %10s %10s\n", m.getMember_id(),
						m.getPassword(), m.getName(), m.getEmail(), m.getPhone(), m.getBirth());
			}
			System.out.println();       

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
