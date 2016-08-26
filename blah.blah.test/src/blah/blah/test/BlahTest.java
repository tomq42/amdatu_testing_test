package blah.blah.test;

import static org.amdatu.testing.configurator.TestConfigurator.serviceDependency;

import org.amdatu.testing.configurator.TestConfigurator;
import org.amdatu.testing.http.HttpTestConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import blah.blah.api.Blah;

/**
 * 
 */

public class BlahTest {

    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
    
    @Before
    public void setup() {
    	TestConfigurator.configure(this)
    		.add(serviceDependency().setService(Blah.class).setRequired(true))
    		.add(HttpTestConfigurator.createWaitForHttpEndpoints("blah"))
    		.apply();
    }
    
    /*
     * 
     */
    @Test
    public void testBlah() throws Exception {
    	Assert.assertNotNull(context);
    }
}
