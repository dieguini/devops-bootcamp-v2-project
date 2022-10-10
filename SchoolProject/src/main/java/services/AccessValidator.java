package services;

import repositories.interfaces.IRepository;

public class AccessValidator<T> {
    IRepository iRepository;

    public AccessValidator(IRepository iRepository) {
        this.iRepository = iRepository;
    }

    public Object verifyAccess(String code) {
        return this.iRepository.getByCode(code);
    }
}
