package principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import principal.crud.ProdutoCrud;

public class NewClass {

    public static void main(String[] args) {
        ProdutoCrud p = new ProdutoCrud();
        try {
            p.listar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
