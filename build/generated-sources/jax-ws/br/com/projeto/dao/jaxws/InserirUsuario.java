
package br.com.projeto.dao.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "inserirUsuario", namespace = "http://dao.projeto.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inserirUsuario", namespace = "http://dao.projeto.com.br/", propOrder = {
    "nome",
    "senha",
    "email",
    "dataNascimento"
})
public class InserirUsuario {

    @XmlElement(name = "nome", namespace = "")
    private String nome;
    @XmlElement(name = "senha", namespace = "")
    private String senha;
    @XmlElement(name = "email", namespace = "")
    private String email;
    @XmlElement(name = "dataNascimento", namespace = "")
    private String dataNascimento;

    /**
     * 
     * @return
     *     returns String
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * 
     * @param nome
     *     the value for the nome property
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getSenha() {
        return this.senha;
    }

    /**
     * 
     * @param senha
     *     the value for the senha property
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 
     * @param email
     *     the value for the email property
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDataNascimento() {
        return this.dataNascimento;
    }

    /**
     * 
     * @param dataNascimento
     *     the value for the dataNascimento property
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
