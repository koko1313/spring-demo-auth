# Spring demo authentication and authorization

A simple Spring project, that demonstrates in-memory authentication and authorization.

1. Add security dependency
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2. Create UserModel, UserRepository, RoleModel, etc ...

3. Create **UserPrincipal** *implementing UserDetails*

4. Create **ApplicationUserDetailsService** *implementing UserDetailsService*

5. Configure (create) **SecurityConfig**

6. Create **LoginController** with login end-point

7. In **HomeController** there are some authorization examples
