# Port Mapper (beta)

<p align="center"><img src ="../gh-pages/logo.png" alt="Portmapper logo" /></p>

 * [Introduction](#introduction)
 * [Quick-start Guide](#quick-start-guide)
 * [FAQ](#faq)

## Introduction
Port mapper is a Java library, originally developed as part of the the [Peernetic](https://github.com/offbynull/peernetic) project, that allows you to forward ports on NAT-enabled routers. The Port Mapper project has several distinct advantages over existing Java libraries that provide port forwarding functionality:

* Tested on all major platforms: Android, Windows, Linux, and Mac
* Supports UPnP-IGD (Universal Plug-and-Play Internet Gateway Device) -- both IGD v1.0 and IGD v2.0
* Supports NAT-PMP (NAT Port Mapping Protocol)
* Supports PCP (Port Control Protocol)
* Supports both IPv4 and IPv6
* Fault-tolerant -- works around malformed responses and faulty routers
* Light-weight -- very few dependencies and easy to port to other languages

## Quick-start Guide

If you're using Maven, include portmapper as a dependency.

```xml
<dependency>
    <groupId>com.offbynull.portmapper</groupId>
    <artifactId>portmapper</artifactId>
    <version>2.0.0</version>
</dependency>
```


The following example attempts to map a port on the first port mapper it finds.

```java
// Start up a network gateway
Gateway network = NetworkGateway.create();
Bus networkBus = network.getBus();

// Start up a process gateway
Gateway process = ProcessGateway.create();
Bus processBus = process.getBus();

// Discover router's with port mapping functionality
List<PortMapper> mappers = PortMapperFactory.discover(networkBus, processBus);



// Map internal port 12345 to some external port (55555 preferred)
MappedPort mappedPort = portMapper.mapPort(PortType.TCP, 12345, 55555, 60);
System.out.println("Port mapping added: " + mappedPort);

// Refresh mapping half-way through the lifetime of the mapping (for example,
// if the mapping is available for 40 seconds, refresh it every 20 seconds)
while(!shutdown) {
    mappedPort = portMapper.refreshPort(mappedPort,
            mappedPort.getLifetime() / 2L);
    System.out.println("Port mapping refreshed: " + mappedPort);
    Thread.sleep(mappedPort.getLifetime() * 1000L);
}

// Unmap port 12345
portMapper.unmapPort(mappedPort);



// Kill the network gateway once your application completes
networkBus.send(new KillNetworkRequest());

// Kill the network gateway once your application completes
//   You can technically kill this once discovery finishes
processBus.send(new KillProcessRequest());
```

## FAQ

#### What if I want to discover only one type of PortMapper

You can use the discover method on the PortMapper implementations directly. For example ...

```java

```

#### How is the Port Mapper project considered light-weight/fault-tolerant?

The Port Mapper project...

1. has very few dependencies on third-party Java libraries
1. doesn't require any special parsing libraries (e.g. XML/SOAP/HTTP/etc..) -- all parsing is done as US-ASCII text
1. doesn't require any special networking libraries (e.g. Netty/MINA/etc..) -- all networking functionality uses standard Java NIO
1. doesn't require any regex

Because of this, the code should be easily portable to other languages -- especially languages that don't have the same robust ecosystem that Java does.

#### How is the Port Mapper project considered fault-tolerant?

The Port Mapper project aims to be resilent when it comes to faulty responses, especially when the protocol is UPnP-IGD. The Port Mapper project ...

1. parses XML as text, based on patterns/hueristics (works around issues such as invalid XML syntax/invalid XML structure/incorrect capitialization/etc..)
1. attempts requests multiple times when it the router responds with a failure (works around temporary network failure and other temporary hiccups that cause bad response codes)

#### Does the Port Mapper project support PCP authentication or UPnP-IGD device protection

Not at this time. Support may be added in the future.

#### What alternatives are available?

Alternatives to the Port Mapper project include:

* [weupnp](https://github.com/bitletorg/weupnp)
* [SBBI](https://sourceforge.net/projects/upnplibmobile/)
* [Cling](http://4thline.org/projects/cling/)
* [jNAT-PMPlib](http://sourceforge.net/projects/jnat-pmplib/)

If you know of any other projects please let me know and I'll update this section.