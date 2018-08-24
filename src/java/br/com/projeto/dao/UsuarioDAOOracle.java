/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.modelo.Usuario;
import br.com.projeto.utilidades.conexao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author luis.silva
 */
@WebService(serviceName = "UsuarioDAOOracle")
@Stateless()
public class UsuarioDAOOracle {

    EntityManager managerOracle = conexao.getEntityManagerOracle();
    EntityTransaction conexaoOracle = managerOracle.getTransaction();

    @WebMethod(operationName = "buscarTodos")
    public String buscarTodos() throws ParseException {

        try {
            CriteriaBuilder builder = managerOracle.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);

            Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
            criteriaQuery.select(usuario);

            TypedQuery<Usuario> query = managerOracle.createQuery(criteriaQuery);
            List<Usuario> Usuarios = query.getResultList();

            for (Usuario user : Usuarios) {
                Date data = user.getDataNascimento();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dataNacimento = sdf.format(data);

                System.out.println(user.getId() + " - "
                        + user.getNome() + " - "
                        + user.getSenha() + " - "
                        + user.getEmail() + " - "
                        + dataNacimento);
            }

        } catch (Exception e) {
            System.out.println("Erro (" + e.getMessage()
                    + ") ao consultar pessoa no banco!");

        } finally {
//            managerOracle.close();
//            conexao.close();
        }

        return "Operação realizada com sucesso!";
    }

    @WebMethod(operationName = "inserirUsuario")
    public String inserirUsuario(@WebParam(name = "nome") String nome,
            @WebParam(name = "senha") String senha,
            @WebParam(name = "email") String email,
            @WebParam(name = "dataNascimento") String dataNascimento)
            throws ParseException {

        DateFormat f = DateFormat.getDateInstance();
        Date data = f.parse(dataNascimento);
        System.out.println(data);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Data formatada: " + sdf.format(data));

        Usuario user = new Usuario();

        try {
            conexaoOracle.begin();

            user.setNome(nome);
            user.setSenha(senha);
            user.setEmail(email);
            user.setDataNascimento(data);
            managerOracle.persist(user);

            conexaoOracle.commit();

        } catch (Exception e) {
            System.out.println(" Erro ao tentar inserir usuário no sistema! "
                    + "Já existe um usuario com este nome no sistema.");

        } finally {
//            managerOracle.close();
//            conexao.close();
        }
        return "Operação realizada com sucesso!";
    }

    @WebMethod(operationName = "selectusuario")
    public Usuario selectUsuario(@WebParam(name = "nomeUsuario") String nomeUsuario,
            @WebParam(name = "senha") String senha) {

        Usuario user = new Usuario();

        try {

            user = (Usuario) managerOracle
                    .createQuery(
                            "SELECT u from Usuario u where u.nome = "
                            + ":name and u.senha = :senha")
                    .setParameter("name", nomeUsuario)
                    .setParameter("senha", senha).getSingleResult();

            Date data = user.getDataNascimento();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataNacimento = sdf.format(data);

            System.out.println(user.getId() + " -- "
                    + user.getNome() + " -- "
                    + user.getSenha() + " -- "
                    + user.getEmail() + " -- "
                    + dataNacimento);
            return user;

        } catch (NoResultException e) {
            System.out.println(" Erro (" + e.getMessage()
                    + ") ao tentar buscar usuario no sistema ou não existe!");
            return null;

        } finally {
//            managerOracle.close();
//            conexao.close();
        }
    }

    @WebMethod(operationName = "excluirusuario")
    public String excluirUsuario(@WebParam(name = "nomeUsuario") String nomeUsuario,
            @WebParam(name = "senha") String senha) {

        Usuario user = new Usuario();

        try {
            conexaoOracle.begin();

            user = (Usuario) managerOracle.createQuery(
                    "SELECT u from Usuario u where u.nome = :name and u.senha = :senha")
                    .setParameter("name", nomeUsuario)
                    .setParameter("senha", senha).getSingleResult();

            managerOracle.remove(user);
            conexaoOracle.commit();
            System.out.println(" Pessoa excluida com sucesso!");

        } catch (Exception e) {

            System.out.println("Esta pessoa não pode ser excluida, "
                    + "pode está vinculada a algum cadastro ou não existe no sistema!");

        } finally {
//            managerOracle.close();
//            conexao.close();
        }

        return "Operação realizada com sucesso!";
    }

    @WebMethod(operationName = "atualizarUsuario")
    public String AtualizarDadosUsuario(@WebParam(name = "codigo") int codigo,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha,
            @WebParam(name = "dadaNascimento") String dadaNascimento)
            throws ParseException {

        long id = codigo;

        DateFormat f = DateFormat.getDateInstance();
        Date data = f.parse(dadaNascimento);
        System.out.println(data);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Data formatada: " + sdf.format(data));

        Usuario user = new Usuario();

        try {
            conexaoOracle.begin();
            user = managerOracle.find(Usuario.class, id);

            System.out.println("Nome atual: " + user.getNome());
            user.setNome(nome);
            System.out.println("Novo nome: " + user.getNome());

            System.out.println("Email atual: " + user.getEmail());
            user.setEmail(email);
            System.out.println("Novo email: " + user.getEmail());

            System.out.println("Senha atual: " + user.getSenha());
            user.setSenha(senha);
            System.out.println("Nova senha: " + user.getSenha());

            System.out.println("Data de nascimento atual: " + user.getDataNascimento());
            user.setDataNascimento(data);
            System.out.println("Nova data de nascimento senha: " + user.getDataNascimento());

            conexaoOracle.commit();

        } catch (Exception e) {
            conexaoOracle.rollback();
            System.out.println("Erro (" + e.getMessage()
                    + ") ao tentar atualizar pessoa! Cofira os dados e tente novamente.");

        } finally {
//            managerOracle.close();
//            conexao.close();
        }
        return "Opearação realizada com sucesso!";
    }

}
