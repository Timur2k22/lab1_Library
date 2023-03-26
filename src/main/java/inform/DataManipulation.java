package inform;

import factories.EnglishFactory;
import factories.ProfessorFactory;
import factories.RussianFactory;
import factories.StudentFactory;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import products.Professor;
import products.Student;
import products.Book;

public class DataManipulation {

    public void createData(int quantityOfStudents, int quantityOfProfessors) {
        EnglishFactory ef = new EnglishFactory();
        RussianFactory rf = new RussianFactory();
        for (int i = 0; i < 25; i++) {
            Library.books.add(ef.creatTextBook());
            Library.books.add(ef.createFiction());
            Library.books.add(rf.creatTextBook());
            Library.books.add(rf.createFiction());
        }
        StudentFactory sf = new StudentFactory();
        ProfessorFactory pf = new ProfessorFactory();
        for (int i = 0; i < quantityOfStudents; i++) {
            Student student = sf.createUser();
            student.takeBook(Library.books);
            Library.students.add(student);
        }
        for (int i = 0; i < quantityOfProfessors; i++) {
            Professor professor = pf.createUser();
            professor.takeBook(Library.books);
            Library.professors.add(professor);
//            professor.getBooks().forEach(book -> System.out.println(book.getFullName()));
        }

    }

    public TreeNode addInfotoGUI() {
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("Пользователи");
        main.add(Library.getSudentNodes());
        main.add(Library.getTeachersNodes());
        return main;
    }
}
