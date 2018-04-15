package sistema.bean;
 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
 
@ManagedBean(name="treeBasicView")
@ViewScoped
public class ChaveamentoMB implements Serializable {
     
	private static final long serialVersionUID = 7230184169434738114L;
	
	private TreeNode root;
     
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
    }
    
    public TreeNode getRoot() {
        return root;
    }
}