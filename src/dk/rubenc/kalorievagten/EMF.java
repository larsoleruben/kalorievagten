package dk.rubenc.kalorievagten;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("transactions-optional");

    private static final EntityManagerFactory emfTxnInstance =
        Persistence.createEntityManagerFactory("transactions-compulsory");
    
    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
    
    public static EntityManagerFactory getTxn(){
    	return emfTxnInstance;
    }
}
