package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ServerProxi extends ViewProxi implements ServerView{
    
    public ServerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ServerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi arten = null;
        String arten$String = (String)resultTable.get("arten");
        if (arten$String != null) {
            common.ProxiInformation arten$Info = common.RPCConstantsAndServices.createProxiInformation(arten$String);
            arten = view.objects.ViewProxi.createProxi(arten$Info,connectionKey);
            arten.setToString(arten$Info.getToString());
        }
        ViewProxi manager = null;
        String manager$String = (String)resultTable.get("manager");
        if (manager$String != null) {
            common.ProxiInformation manager$Info = common.RPCConstantsAndServices.createProxiInformation(manager$String);
            manager = view.objects.ViewProxi.createProxi(manager$Info,connectionKey);
            manager.setToString(manager$Info.getToString());
        }
        ViewProxi transaktionManager = null;
        String transaktionManager$String = (String)resultTable.get("transaktionManager");
        if (transaktionManager$String != null) {
            common.ProxiInformation transaktionManager$Info = common.RPCConstantsAndServices.createProxiInformation(transaktionManager$String);
            transaktionManager = view.objects.ViewProxi.createProxi(transaktionManager$Info,connectionKey);
            transaktionManager.setToString(transaktionManager$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String user = (String)resultTable.get("user");
        ServerView result$$ = new Server((ArtenManagerView)arten,(KontoFcdView)manager,(TransFacdeView)transaktionManager,errors,(String)user, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getManager() != null && index < this.getManager().getTheObject().getChildCount())
            return this.getManager().getTheObject().getChild(index);
        if(this.getManager() != null) index = index - this.getManager().getTheObject().getChildCount();
        if(this.getTransaktionManager() != null && index < this.getTransaktionManager().getTheObject().getChildCount())
            return this.getTransaktionManager().getTheObject().getChild(index);
        if(this.getTransaktionManager() != null) index = index - this.getTransaktionManager().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getManager() == null ? 0 : this.getManager().getTheObject().getChildCount())
            + (this.getTransaktionManager() == null ? 0 : this.getTransaktionManager().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getManager() == null ? true : this.getManager().getTheObject().isLeaf())
            && (this.getTransaktionManager() == null ? true : this.getTransaktionManager().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getManager() != null && this.getManager().equals(child)) return result;
        if(this.getManager() != null) result = result + 1;
        if(this.getTransaktionManager() != null && this.getTransaktionManager().equals(child)) return result;
        if(this.getTransaktionManager() != null) result = result + 1;
        return -1;
    }
    
    public ArtenManagerView getArten()throws ModelException{
        return ((Server)this.getTheObject()).getArten();
    }
    public void setArten(ArtenManagerView newValue) throws ModelException {
        ((Server)this.getTheObject()).setArten(newValue);
    }
    public KontoFcdView getManager()throws ModelException{
        return ((Server)this.getTheObject()).getManager();
    }
    public void setManager(KontoFcdView newValue) throws ModelException {
        ((Server)this.getTheObject()).setManager(newValue);
    }
    public TransFacdeView getTransaktionManager()throws ModelException{
        return ((Server)this.getTheObject()).getTransaktionManager();
    }
    public void setTransaktionManager(TransFacdeView newValue) throws ModelException {
        ((Server)this.getTheObject()).setTransaktionManager(newValue);
    }
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException{
        return ((Server)this.getTheObject()).getErrors();
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        ((Server)this.getTheObject()).setErrors(newValue);
    }
    public String getUser()throws ModelException{
        return ((Server)this.getTheObject()).getUser();
    }
    public void setUser(String newValue) throws ModelException {
        ((Server)this.getTheObject()).setUser(newValue);
    }
    
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    
    
    public ServerConnection connectServer(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        ServerConnection result;
		try {
			result = (ServerConnection) new ServerConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
