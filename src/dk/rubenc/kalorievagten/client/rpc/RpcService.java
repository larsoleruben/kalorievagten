package dk.rubenc.kalorievagten.client.rpc;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import dk.rubenc.kalorievagten.client.model.ConsumedDateCli;
import dk.rubenc.kalorievagten.client.model.KVTrainingSessionCli;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("rpcservice")
public interface RpcService extends RemoteService {
  
 
  public KalorieVagtenUser checkLogin();
  public String saveUserCredentials( KalorieVagtenUser kvu );
  public String saveTrainingSession( KVTrainingSessionCli kvt );
  public String updateTrainingSession( KVTrainingSessionCli kvt );
  public List getSavedTrainingObjects(String dateFrom, String dateTo, String userId, int maxResults );
  public List getIngreedients(String ingreedientName, int maxResults);
  public String saveConsumedDate( ConsumedDateCli cdc);
  public ConsumedDateCli getConsumedDate( String date);
  
}
