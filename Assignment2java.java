import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Course {

    int courseId;
    String courseName;
    String instructor;
    int credits;

    Course(int courseId, String courseName, String instructor, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
    }
}

public class CourseRegistrationSystem extends JFrame implements ActionListener {

    JTextField tfId, tfName, tfInstructor, tfCredits;

    JButton btnAdd, btnUpdate, btnDelete, btnClear;

    JTable table;
    DefaultTableModel model;

    ArrayList<Course> courses = new ArrayList<>();

    CourseRegistrationSystem() {

        setTitle("Course Registration System");
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));

        inputPanel.add(new JLabel("Course ID:"));
        tfId = new JTextField();
        inputPanel.add(tfId);

        inputPanel.add(new JLabel("Course Name:"));
        tfName = new JTextField();
        inputPanel.add(tfName);

        inputPanel.add(new JLabel("Instructor:"));
        tfInstructor = new JTextField();
        inputPanel.add(tfInstructor);

        inputPanel.add(new JLabel("Credits:"));
        tfCredits = new JTextField();
        inputPanel.add(tfCredits);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.CENTER);

        String[] columns = {"Course ID", "Course Name", "Instructor", "Credits"};

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);

        add(pane, BorderLayout.SOUTH);

        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                int row = table.getSelectedRow();

                tfId.setText(model.getValueAt(row, 0).toString());
                tfName.setText(model.getValueAt(row, 1).toString());
                tfInstructor.setText(model.getValueAt(row, 2).toString());
                tfCredits.setText(model.getValueAt(row, 3).toString());
            }
        });

        setVisible(true);
    }

    void clearFields() {
        tfId.setText("");
        tfName.setText("");
        tfInstructor.setText("");
        tfCredits.setText("");
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) {

            try {

                int id = Integer.parseInt(tfId.getText());
                String name = tfName.getText();
                String instructor = tfInstructor.getText();
                int credits = Integer.parseInt(tfCredits.getText());

                Course c = new Course(id, name, instructor, credits);

                courses.add(c);

                model.addRow(new Object[]{
                        id, name, instructor, credits
                });

                JOptionPane.showMessageDialog(this,
                        "Course Added Successfully!");

                clearFields();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Data!");
            }
        }

        if (e.getSource() == btnUpdate) {

            int row = table.getSelectedRow();

            if (row >= 0) {

                model.setValueAt(tfId.getText(), row, 0);
                model.setValueAt(tfName.getText(), row, 1);
                model.setValueAt(tfInstructor.getText(), row, 2);
                model.setValueAt(tfCredits.getText(), row, 3);

                JOptionPane.showMessageDialog(this,
                        "Course Updated Successfully!");

                clearFields();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Select a Row First!");
            }
        }

        if (e.getSource() == btnDelete) {

            int row = table.getSelectedRow();

            if (row >= 0) {

                model.removeRow(row);

                JOptionPane.showMessageDialog(this,
                        "Course Deleted Successfully!");

                clearFields();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Select a Row First!");
            }
        }

        if (e.getSource() == btnClear) {

            clearFields();
        }
    }

    public static void main(String[] args) {

        new CourseRegistrationSystem();
    }
}