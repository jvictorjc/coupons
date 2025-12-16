#Stack 

 - Java 21
 - Spring 3.5.8
 - H2
 - Lombock
 - Maven

#Config Database

- spring.datasource.url=jdbc:h2:mem:coupondb
- spring.datasource.username=sa
- spring.datasource.password=

- spring.h2.console.enabled=true
- spring.h2.console.path=/h2-console

- spring.jpa.generate-ddl=true
- spring.jpa.show-sql=true

#Test Json

{
    "code": "ABA-123",
    "description": "coupon test.",
    "discountValue": 0.8,
    "expirationDate": "2025-12-17T17:14:45.180Z",
    "published": false
} 
