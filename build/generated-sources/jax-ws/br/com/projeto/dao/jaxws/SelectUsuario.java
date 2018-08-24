
package br.com.projeto.dao.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "selectusuario", namespace = "http://dao.projeto.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "selectusuario", namespace = "http://dao.projeto.com.br/", propOrder = {
    "nomeUsuario",
    "senha"
})
public class SelectUsuario {

    @XmlElement(name = "nomeUsuario", namespace = "")
    private String nomeUsuario;
    @XmlElement(name = "senha", namespace = "")
    private String senha;

    /**
     * 
     * @return
     *     returns String
     */
    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    /**
     * 
     * @param nomeUsuario
     *     the value for the nomeUsuario property
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

}
