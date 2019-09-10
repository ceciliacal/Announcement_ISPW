package control;

public class ControllerTenantAnnounce {

    //SINGLETON

    private static ControllerTenantAnnounce instance = null;

    //Il costruttore private impedisce l'istanza di oggetti da parte di classi esterne
    private ControllerTenantAnnounce() {};

    //Metodo della classe impiegato per accedere al singleton
    public synchronized static ControllerTenantAnnounce getInstance() {
        if(ControllerTenantAnnounce.instance == null) {
            ControllerTenantAnnounce.instance = new ControllerTenantAnnounce();
        }
        return instance;
    }







}
