/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import entity.News;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import session.NewsFacade;

/**
 *
 * @author adminl
 */
@MessageDriven(mappedName = "jms/newsQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewsReaderMessageBean implements MessageListener {

    @EJB
    private NewsFacade newsFacade;

    public NewsReaderMessageBean() {
    }

    @Override
    public void onMessage(Message message) {

        try {
            if (message instanceof ObjectMessage) {

                ObjectMessage objMsg = (ObjectMessage) message;
                if (objMsg.getObject() instanceof News) {

                    News hotMessage = (News) objMsg.getObject();

                    newsFacade.create(hotMessage);

                }
            }
        } catch (JMSException ex) {
            Logger.getLogger(NewsReaderMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
