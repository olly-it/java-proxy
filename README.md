# java-proxy
Simple java project that shows how to play with java.lang.reflect.Proxy and java.lang.reflect.InvocationHandler to dynamically call beans in Spring's context.

Typical scenario:  
1- client knows the interface  
2- client generate a proxy with that interface  
3- the proxy manage a generic invocation, serialize what needed and call a remote service  
4- server receives the call and invoke the correct bean in the context (the bean that implements the given interface)  
5- server replies by serializing the return object  
6- client received the result  


In this repo the serialization part is not implemented.  
The test covers the proxy creation, the proxy handler and the correct bean retrieval from the spring's context.

Olly
