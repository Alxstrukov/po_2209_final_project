package by.itclass.listeners;

import by.itclass.model.data_base.ConnectionManager;
import by.itclass.model.services.ServiceFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionManager.init();
        ServiceFactory.init();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
