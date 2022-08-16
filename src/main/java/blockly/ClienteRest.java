package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(get = "Public", execute = "Public")
public class ClienteRest {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// ClienteRest
public static Var getCliente() throws Exception {
 return new Callable<Var>() {

   private Var response = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {

    response =
    cronapi.list.Operations.newList();

    item =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Cliente"),Var.valueOf("select c.nome, c.cpf from Cliente c"));

    for (Iterator it_i = item.iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());

        cronapi.list.Operations.addLast(response,
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("nome",
        cronapi.database.Operations.getField(i,
        Var.valueOf("this[0]"))) , Var.valueOf("cpf",
        cronapi.database.Operations.getField(i,
        Var.valueOf("this[1]"))) , Var.valueOf("mensagem",
        Var.valueOf(
        Var.valueOf("Olá Mundo!").toString() +
        cronapi.database.Operations.getField(i,
        Var.valueOf("this[0]")).toString()))));
    } // end for
    return response;
   }
 }.call();
}

}

