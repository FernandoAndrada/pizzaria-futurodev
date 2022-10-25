package br.com.agls.pizzariafuturoDev.Service.Interfaces;


import java.util.List;

public interface DefaultCrud <T> {

    //porque implementar no defaultcrud e não no service???

    T salvar (T object);
    T atualizar (T object);
    T buscar(Long id);
    List<T> listar();
    void deletar (Long id);
}
