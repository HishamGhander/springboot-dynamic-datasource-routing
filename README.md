Spring's AbstractRoutingDatasource as a way of dynamically determining the actual DataSource based on the current context.

AbstractRoutingDatasource requires information to know which actual DataSource to route to. This information is typically referred to as a Context.

the Context used with AbstractRoutingDatasource can be any Object like an enum 

The context holder implementation is a container that stores the current context as a ThreadLocal reference.
The context holder implementation should contain static methods for setting, getting, and clearing it.

We define our DataSourceRouting to extend the Spring AbstractRoutingDataSource.
We implement the necessary determineCurrentLookupKey method to query our DatabaseContextHolder and return the appropriate key.
When using our AbstractRoutingDataSource, we first set the context and then perform our operation.
We make use of a service layer that takes the context as a parameter and sets it before delegating to data-access code
and clearing the context after the call.

DataSourceInterceptor intercepts every request and get branch information from request headers
and put it to context holder as we already created to DatabaseContextHolder via which we will switch data source.

usage
you should request this url http://localhost:8080/patients in postman
and set header with database as a key and (allegiancemd1 or allegiancemd2) as a value