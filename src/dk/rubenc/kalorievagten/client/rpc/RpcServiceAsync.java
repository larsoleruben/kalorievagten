package dk.rubenc.kalorievagten.client.rpc;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import dk.rubenc.kalorievagten.client.model.ConsumedDateCli;
import dk.rubenc.kalorievagten.client.model.KVTrainingSessionCli;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;



/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RpcServiceAsync {
  
  
  public void checkLogin( AsyncCallback<KalorieVagtenUser> callback);
  public void saveUserCredentials( KalorieVagtenUser kvu, AsyncCallback<String> callback );
  public void saveTrainingSession( KVTrainingSessionCli kvt, AsyncCallback<String> callback  );
  public void updateTrainingSession( KVTrainingSessionCli kvt, AsyncCallback<String> callback  );
  public void getSavedTrainingObjects( String datefrom, String dateTo, String userId, int maxResults , AsyncCallback<List> callback  );
  public void getIngreedients(String ingreedientName, int maxResults, AsyncCallback<List> callback);
  public void saveConsumedDate(ConsumedDateCli cdc,  AsyncCallback<String> callback);
  public void getConsumedDate(String date, AsyncCallback<ConsumedDateCli> callback  );
}
