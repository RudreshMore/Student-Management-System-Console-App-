package in.rudresh;

import java.util.*;

public class StudentManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<>();

		while (true) {
			System.out.println("\n=== Student Management System ===");
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				addStudent(list, sc);
				break;
			case 2:
				viewStudents(list);
				break;
			case 3:
				searchStudent(list, sc);
				break;
			case 4:
				updateStudent(list, sc);
				break;
			case 5:
				deleteStudent(list, sc);
				break;
			case 6:
				System.out.println("Thank you!");
				System.exit(0);
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	public static void addStudent(ArrayList<Student> list, Scanner sc) {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Age: ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Course: ");
		String course = sc.nextLine();

		list.add(new Student(id, name, age, course));
		System.out.println("Student added successfully!");
	}

	public static void viewStudents(ArrayList<Student> list) {
		System.out.println("\n--- Student List ---");
		for (Student st : list) {
			System.out.println(st);
		}
	}

	public static void searchStudent(ArrayList<Student> list, Scanner sc) {
		System.out.print("Enter ID to search: ");
		int id = sc.nextInt();

		for (Student st : list) {
			if (st.getId() == id) {
				System.out.println("Student Found: " + st);
				return;
			}
		}
		System.out.println("Student not found!");
	}

	public static void updateStudent(ArrayList<Student> list, Scanner sc) {
		System.out.print("Enter ID to update: ");
		int id = sc.nextInt();
		sc.nextLine();

		for (Student st : list) {
			if (st.getId() == id) {
				System.out.print("Enter new name: ");
				st.setName(sc.nextLine());

				System.out.print("Enter new age: ");
				st.setAge(sc.nextInt());
				sc.nextLine();

				System.out.print("Enter new course: ");
				st.setCourse(sc.nextLine());

				System.out.println("Student updated!");
				return;
			}
		}
		System.out.println("Student not found!");
	}

	public static void deleteStudent(ArrayList<Student> list, Scanner sc) {
		System.out.print("Enter ID to delete: ");
		int id = sc.nextInt();

		Iterator<Student> itr = list.iterator();

		while (itr.hasNext()) {
			if (itr.next().getId() == id) {
				itr.remove();
				System.out.println("Student deleted!");
				return;
			}
		}
		System.out.println("Student not found!");
	}
}
