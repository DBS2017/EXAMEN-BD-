
package dao;

import java.util.List;
import modelo.ChoferM;


public interface IChofer {
    
    void guardar(ChoferM chofer)throws Exception;
    void modificar(ChoferM chofer)throws Exception;
    void eliminar (ChoferM chofer )throws Exception;
    List<ChoferM> listchofer ()throws Exception;
    
}
