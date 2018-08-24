
package br.com.projeto.dao.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import br.com.projeto.modelo.Usuario;

@XmlRootElement(name = "selectusuarioResponse", namespace = "http://dao.projeto.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "selectusuarioResponse", namespace = "http://dao.projeto.com.br/")
public class SelectUsuarioResponse {

    @XmlElement(name = "return", namespace = "")
    private Usuario _return;

    /**
     * 
     * @return
     *     returns Usuario
     */
    public Usuario getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Usuario _return) {
        this._return = _return;
    }

}
