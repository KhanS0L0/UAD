FROM docker.io/openjdk:17

EXPOSE 8080

ADD build/libs/UAD-1.0-SNAPSHOT.jar UAD.jar

RUN mkdir .aws && cd .aws && touch credentials && echo [default] >> credentials && echo aws_access_key_id = YCAJEvYVZaYhOwWm6rYMs8lpt >> credentials && echo aws_secret_access_key =f YCOZFOMLNTy62a5AeUhNsopaS0aYD-u0fVaM1IUx >> credentials && echo region = ru-central1 >> credentials && export AWS_SECRET_KEY=YCOZFOMLNTy62a5AeUhNsopaS0aYD-u0fVaM1IUx && export AWS_ACCESS_KEY_ID=YCAJEvYVZaYhOwWm6rYMs8lpt

ENTRYPOINT ["java", "-jar", "UAD.jar"]