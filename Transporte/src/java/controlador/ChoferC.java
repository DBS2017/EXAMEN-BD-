package controlador;

import dao.ChoferD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.ChoferM;

@Named(value = "choferC")
@SessionScoped
public class ChoferC implements Serializable {

    ChoferM chofer = new ChoferM();
    private ChoferM selectedChofer;
    private List<ChoferM> lstChofer;

    
    @PostConstruct
    public void init() {
        try {
           listar();
           
        } catch (Exception e) {
        }
    }
    
    

    public void guardar() {
        ChoferD dao;
        try {
            dao = new ChoferD();
            dao.guardar(chofer);
            limpiarChofer(); // al momento de guarda limpia el inputText
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", null));
        }
    }

    public void modificar() {
        ChoferD dao;
        try {
            dao = new ChoferD();
            dao.modificar(chofer);
        } catch (Exception e) {
        }
    }

    public void eliminar() {
        ChoferD dao;
        try {
            dao = new ChoferD();
            dao.eliminar(chofer);
        } catch (Exception e) {
        }

    }

    public void listar() throws Exception {
        ChoferD dao;
        try {
            dao = new ChoferD();
            lstChofer = dao.listchofer();
        } catch (Exception e) {
            throw e;
        }
    }
     public void limpiarChofer() {
        chofer = new ChoferM();
    }


    public ChoferM getChofer() {
        return chofer;
    }

    public void setChofer(ChoferM chofer) {
        this.chofer = chofer;
    }

    public List<ChoferM> getLstChofer() {
        return lstChofer;
    }

    public void setLstChofer(List<ChoferM> lstChofer) {
        this.lstChofer = lstChofer;
    }
    public ChoferM getSelectedChofer() {
        return selectedChofer;
    }

    public void setSelectedChofer(ChoferM selectedChofer) {
        this.selectedChofer = selectedChofer;
    }

}
