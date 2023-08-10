String token = JWT.create()
        .withIssuer("aclient")
        .withAudience("http://wet.develop.de:8088/auth/realms/dc")
        .withSubject("aclient")
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 300000L)) // 5 min
        .withJWTId(UUID.randomUUID()
        .toString())
        .withNotBefore(new Date(System.currentTimeMillis() - 60000L))
        .sign(algorithm);
