package sistema.bean;
 
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.derby.client.am.DateTime;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import sistema.models.Campeonato;
import sistema.service.ChaveamentoService;
 
@ManagedBean(name="treeBasicView")
@ViewScoped
public class ChaveamentoMB implements Serializable {
     
	private static final long serialVersionUID = 7230184169434738114L;
	
	private TreeNode root;
	private Campeonato campeonato;
	private ChaveamentoService service = new ChaveamentoService();
	
    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("--", null);
        TreeNode node0 = new DefaultTreeNode("--", root);
        
        TreeNode node00 = new DefaultTreeNode("--", node0);
        TreeNode node01 = new DefaultTreeNode("--", node0);
        
        TreeNode node000 = new DefaultTreeNode("--", node00);
        TreeNode node001 = new DefaultTreeNode("--", node00);
        TreeNode node010 = new DefaultTreeNode("--", node01);
        TreeNode node011 = new DefaultTreeNode("--", node01);
         
        node000.getChildren().add(new DefaultTreeNode("Team A"));
        node000.getChildren().add(new DefaultTreeNode("Team B"));
        node001.getChildren().add(new DefaultTreeNode("Team C"));
        node001.getChildren().add(new DefaultTreeNode("Team D"));
        node010.getChildren().add(new DefaultTreeNode("Team E"));
        node010.getChildren().add(new DefaultTreeNode("Team F"));
        node011.getChildren().add(new DefaultTreeNode("Team G"));
        node011.getChildren().add(new DefaultTreeNode("Team H"));
        
        expandTree(root);
    }
    
    
    private void expandTree(TreeNode node) {
        	if(node.getChildCount() != 0) {
        		node.getChildren().forEach(n -> expandTree(n));
        	}
        	node.setExpanded(true);
    }
    
    public TreeNode getRoot() {
        return root;
    }
    
    public List<Campeonato> campeonatos() {
    	return service.campeonatos();
    }
    
    public void gerarChaves() {
    	if(campeonato == null) {
    		if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Championship not selected"));
    		else
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Campeonato não selecionado"));
    	}
    	Date now = new Date();
    	if(now.after(campeonato.getDataFimInscricao())) {
    		if(campeonato == null) {
        		if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
        			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Championship is still open to subscription"));
        		else
        			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Campeonato ainda está aberto para inscrição"));
    		}
    	}
    	
    }
}