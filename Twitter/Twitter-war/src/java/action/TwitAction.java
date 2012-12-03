/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.News;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.struts2.interceptor.SessionAware;
import session.CountSessionBean;
import session.NewsFacade;

/**
 *
 * @author adminl
 */
public class TwitAction extends ActionSupport implements SessionAware {

    CountSessionBean countSessionBean = lookupCountSessionBeanBean();
    NewsFacade newsFacade = lookupNewsFacadeBean();
    
    
    private List<News> newsList;
    private News hotMessage = new News();
    private int sessionCount = countSessionBean.getActivesessionCount();

    public int getSessionCount() {
        return sessionCount;
    }

    public void setSessionCount(int sessionCount) {
        this.sessionCount = sessionCount;
    }

    public News getHotMessage() {
        return hotMessage;
    }

    public void setHotMessage(News hotMessage) {
        this.hotMessage = hotMessage;
    }
    private Map<String, Object> map;

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public String post() {


        if (!hotMessage.getBody().isEmpty()) {
            try {
                sendJMSMessageToNewsQueue(null);

            } catch (NamingException ex) {
                Logger.getLogger(TwitAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JMSException ex) {
                Logger.getLogger(TwitAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        newsList = newsFacade.findLast();

        return SUCCESS;

    }

    private NewsFacade lookupNewsFacadeBean() {
        try {
            Context c = new InitialContext();
            return (NewsFacade) c.lookup("java:global/Twitter/Twitter-ejb/NewsFacade!session.NewsFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CountSessionBean lookupCountSessionBeanBean() {
        try {
            Context c = new InitialContext();
            return (CountSessionBean) c.lookup("java:global/Twitter/Twitter-war/CountSessionBean!session.CountSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Message createJMSMessageForjmsNewsQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        ObjectMessage tm = session.createObjectMessage(hotMessage);
        return tm;
    }

    private void sendJMSMessageToNewsQueue(Object messageData) throws NamingException, JMSException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("java:comp/env/jms/newsQueueFactory");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) c.lookup("java:comp/env/jms/newsQueue");
            MessageProducer mp = s.createProducer(destination);
            mp.send(createJMSMessageForjmsNewsQueue(s, messageData));
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
