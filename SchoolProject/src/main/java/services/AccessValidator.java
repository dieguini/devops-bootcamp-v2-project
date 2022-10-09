package services;

import repositories.interfaces.IPersonRepository;

public class AccessValidator<T> {
    //private StudentRepository studentRepository;
    //private TeacherRepository teacherRepository;
    IPersonRepository iPersonRepository;

    public AccessValidator(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    /* public Optional<Student> verifyStudentAccess(String code) {
        System.out.println("size: " + this.iStudentRepository.getAll().size());
        return this.iStudentRepository.getPersonByCode(code);
    }

    public Teacher verifyTeacherAccess(String code) {
        System.out.println("size: " + this.studentRepository.getAll().size());
        return this.teacherRepository.getTeacherByCode(code);
    } */

    public Object verifyAccess(String code) {
        System.out.println("size: " + this.iPersonRepository.getAll().size());
        return this.iPersonRepository.getPersonByCode(code);
    }
}
