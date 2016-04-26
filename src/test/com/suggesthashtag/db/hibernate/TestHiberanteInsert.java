/**
 * 
 */
package test.com.suggesthashtag.db.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.suggesthashtag.db.exception.DBException;
import com.suggesthashtag.db.hibernate.DBConnectionInit;
import com.suggesthashtag.db.hibernate.DBUtil;
import com.suggesthashtag.db.hibernate.SHTDBSession;
import com.suggesthashtag.db.hibernate.domain.Address;
import com.suggesthashtag.db.hibernate.domain.Student;
import com.suggesthashtag.db.hibernate.domain.Subject;
import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class TestHiberanteInsert {

	protected static PropertyLoader propertyLoader = new PropertyLoader();

	static {
		ArrayList<PropertyLoaderDetails> tempList = new ArrayList<PropertyLoaderDetails>();
		tempList.add(new PropertyLoaderDetails("batchMain.properties", false));
		tempList.add(new PropertyLoaderDetails("db.properties", false));
		try {
			propertyLoader.load(tempList);
			DBConnectionInit.init(propertyLoader);
		} catch (PropertyException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (ExecutionException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (DBException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
	}

	public static void main(String[] args) {
		insertStudent();
		insertStudentPersistent();
		updateStudentPersistent();
		fetchSubjects();
		// DBUtil.insertObject(subject);
		// updateStudent();
		// updateOrInsert();
		// deleteStudent();
		fetch();
		listStudents();
		// subject
		// insertSubject(student);
		// Address
		insertAddress();
		System.out.println("Done!");
	}

	/**
	 * 
	 */
	private static void fetchSubjects() {
		// TODO Auto-generated method stub
		Session session = DBConnectionInit.getOpenSesssion();
		session.beginTransaction();
		List<Subject> results = session
				.createQuery(
						"select sub from SUBJECTS sub where sub.subjectName= :name")
				.setParameter("name", "Maths").list();
		System.out.println("--------");
		for (Subject sub : results) {
			System.out.println(sub.getSubjectName() + " ; "
					+ sub.getStudent().getName());
		}
		System.out.println("--------");
	}

	/**
	 * 
	 */
	private static void insertStudent() {

		Student student = new Student();
		student.setAge(26);
		student.setName("sumit poddar");
		Subject subject = new Subject();
		subject.setStudent(student);
		subject.setSubjectName("Maths");
		subject.setSubMinMarks(45);
		subject.setSubStatusCd("A");
		subject.setSubCreateDt(new Date());
		student.getSubjects().add(subject);
		DBUtil.insertObject(student);
	}

	private static void insertStudentPersistent() {
		Session session = DBUtil.getPersistentDBSession();
		session.beginTransaction();
		Student student = new Student();
		student.setAge(9);
		student.setName("sumit poddar");
		session.save(student);
		Subject subject = new Subject();
		subject.setStudent(student);
		subject.setSubjectName("Maths");
		subject.setSubMinMarks(45);
		subject.setSubStatusCd("A");
		subject.setSubCreateDt(new Date());
		session.save(subject);
		student.getSubjects().add(subject);
		session.getTransaction().commit();

	}

	/**
	 * 
	 */
	private static void insertAddress() {
		Address address = new Address();
		address.setName("Sumit Poddar");
		address.setAddress1("Unit 1");
		address.setAddress2("17/19 Hasall Street");
		address.setSuburb("Parramatta");
		address.setPostcode(2150);
		DBUtil.insertObject(address);

	}

	/**
	 * 
	 */
	private static void fetch() {

		Session session = DBConnectionInit.getOpenSesssion();
		try {
			session.beginTransaction();
			Student stud = (Student) session.get(Student.class, new Long(41));
			System.out.println(stud.getName());
			Set<Subject> setSubject = stud.getSubjects();
			Iterator<Subject> itr = setSubject.iterator();
			stud.setName("Sumit Kumar Poddar!");
			while (itr.hasNext()) {
				Subject sub = itr.next();
				System.out.println(sub.getSubjectName());
				System.out.println(sub.getSubMinMarks());
				System.out.println(sub.getStudent().getName());

			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	/**
	 * 
	 */
	private static void updateOrInsert() {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(19);
		student.setName("amithabh");
		student.setAge(43);
		DBUtil.insertOrUpdateObject(student);

		student = new Student();
		student.setId(7);
		student.setName("Sumit");
		student.setAge(251);
		DBUtil.insertOrUpdateObject(student);
	}

	/**
	 * 
	 */
	private static void updateStudent() {
		Student student = new Student();
		student.setId(24);
		student.setName("abra ka dabra");
		student.setAge(43);
		DBUtil.updateObject(student);

	}

	/**
	 * 
	 */
	private static void updateStudentPersistent() {

		Session session = DBConnectionInit.getOpenSesssion();
		try {
			session.beginTransaction();
			Student stud = (Student) session.get(Student.class, new Long(24));
			Subject subject = new Subject();
			subject.setStudent(stud);
			subject.setSubjectName("English");
			subject.setSubMinMarks(45);
			subject.setSubStatusCd("A");
			subject.setSubCreateDt(new Date());
			session.save(subject);
			stud.getSubjects().add(subject);
			subject = new Subject();
			subject.setStudent(stud);
			subject.setSubjectName("Science");
			subject.setSubMinMarks(555);
			subject.setSubStatusCd("A");
			subject.setSubCreateDt(new Date());
			session.save(subject);
			stud.getSubjects().add(subject);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	private static void deleteStudent() {
		Student student = new Student();
		student.setId(6);
		DBUtil.deleteObject(student);
	}

	private static void listStudents() {

		Session session = DBConnectionInit.getOpenSesssion();
		try {
			session.beginTransaction();
			List result = session.createQuery("from Student").list();
			for (int i = 0; i < result.size(); i++) {
				Student thisStudent = (Student) result.get(i);
				System.out.println("Student Name : " + thisStudent.getName()
						+ ", is of age " + thisStudent.getAge()
						+ " and has an ID " + thisStudent.getId());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}
}
