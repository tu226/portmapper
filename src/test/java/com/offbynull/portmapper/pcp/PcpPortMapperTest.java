package com.offbynull.portmapper.pcp;

public final class PcpPortMapperTest {
//    
//    @Test
//    @Ignore // REQUIRES AN APPLE ROUTER TO TEST PROPERLY (OR POSSIBLE NAT-PMP ENABLED MINIUPNPD)
//    public void testPortMapping() throws Throwable {
//        Set<DiscoveredPcpDevice> devices = PcpDiscovery.discover();
//        DiscoveredPcpDevice device = devices.iterator().next();
//        
//        PortMapperEventListener listener = Mockito.mock(PortMapperEventListener.class);
//        try (PcpPortMapper mapper = new PcpPortMapper(device.getGatewayAddress(), device.getLocalAddress(), false, listener)) {
//            mapper.mapPort(PortType.TCP, 12345, 60);
//            
//            Thread.sleep(10000L);
//        }
//        
//        Mockito.verifyZeroInteractions(listener);
//    }
}