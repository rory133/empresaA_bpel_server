package org.proyecto.empresaA_bpel_server.filters;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

public class CustomHibernateSessionFilter extends OpenSessionInViewFilter {
       
    protected Session getSession(SessionFactory sessionFactory)
                        throws DataAccessResourceFailureException {
        Session session = super.getSession(sessionFactory);
        session.setFlushMode(FlushMode.AUTO);   
        return session;
    }
   
    protected void closeSession(Session session, SessionFactory factory) {
        session.flush(); 
        super.closeSession(session, factory); 
    }
}
