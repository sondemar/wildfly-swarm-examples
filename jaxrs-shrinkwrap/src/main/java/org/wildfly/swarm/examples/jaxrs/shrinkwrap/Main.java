package org.wildfly.swarm.examples.jaxrs.shrinkwrap;

import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * @author Bob McWhirter
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Container container = new Container();

        JAXRSArchive deployment = container.create("myapp.war", JAXRSArchive.class);
        deployment.addClass(MyResource.class);
        //deployment.addAsLibrary(Swarm.artifact("joda-time:joda-time"));
        deployment.addAllDependencies();
        container.start().deploy(deployment);
    }
}
