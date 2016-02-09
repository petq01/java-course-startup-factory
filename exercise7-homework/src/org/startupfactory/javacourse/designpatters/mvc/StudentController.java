package org.startupfactory.javacourse.designpatters.mvc;

/**
 * Controller acts on both model and view. It controls the data flow into model
 * object and updates the view whenever data changes. It keeps view and model
 * separate.
 * 
 * @author Petq
 *
 */
public class StudentController {
	private Student model;
	private StudentView view;

	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view = view;
	}

	public void setStudentName(String name) {
		model.setName(name);
	}

	public String getStudentName() {
		return model.getName();
	}

	public void setStudentRollNo(String rollNo) {
		model.setRollNo(rollNo);
	}

	public String getStudentRollNo() {
		return model.getRollNo();
	}

	public void updateView() {
		view.printStrudentDetails(model.getName(), model.getRollNo());
	}
}
