
package br.com.projeto.dao.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "atualizarusuario", namespace = "http://dao.projeto.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atualizarusuario", namespace = "http://dao.projeto.com.br/", propOrder = {
    "codigo",
    "nome",
    "email",
    "senha",
    "dadaNascimento"
})
public class AtualizarDadosUsuario {

    @XmlElement(name = "codigo", namespace = "")
    private int codigo;
    @XmlElement(name = "nome", namespace = "")
    private String nome;
    @XmlElement(name = "email", namespace = "")
    private String email;
    @XmlElement(name = "senha", namespace = "")
    private String senha;
    @XmlElement(name = "dadaNascimento", namespace = "")
    private String dadaNascimento;

    /**
     * 
     * @return
     *     returns int
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * 
     * @param codigo
     *     the value for the codigo property
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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
    public String getDadaNascimento() {
        return this.dadaNascimento;
    }

    /**
     * 
     * @param dadaNascimento
     *     the value for the dadaNascimento property
     */
    public void setDadaNascimento(String dadaNascimento) {
        this.dadaNascimento = dadaNascimento;
    }

}
