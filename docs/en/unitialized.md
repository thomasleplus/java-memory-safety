<!-- markdownlint-disable MD041 -->

### Example

```java
private static final long[] schedule = new long[366];

@POST("/schedule/{day}")
void setEmployeeIdForDay(@Path int day, @Body long id) {
   synchronized (schedule) {
      schedule[day] = id;
   }
}

@GET("/schedule/{day}")
long getEmployeeIdForDay(@Path int day) {
   synchronized (schedule) {
      return schedule[day];
   }
}
```

Note: Forget if it's Java or not. [Step by step.] 366 longs x 8 bytes
each (on 64-bit system) = 2,928 bytes so almost 3 kilobytes. You use
SSL/TLS of course so if attacker lucky, maybe they get the private key
of your certificate. If not, crash app with POST /schedule/377,
Kubernetes restarts the instance, same player shoot again!
