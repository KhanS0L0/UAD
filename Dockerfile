FROM docker.io/openjdk:17

EXPOSE 8080

ADD build/libs/UAD-1.0-SNAPSHOT.jar UAD.jar

RUN mkdir .aws && cd .aws
RUN echo [default] >> credentials
RUN echo aws_access_key_id = YCAJEvYVZaYhOwWm6rYMs8lpt >> credentials
RUN echo aws_secret_access_key =f YCOZFOMLNTy62a5AeUhNsopaS0aYD-u0fVaM1IUx >> credentials
RUN echo region = ru-central1 >> credentials && cd ../
RUN export AWS_SECRET_KEY=YCOZFOMLNTy62a5AeUhNsopaS0aYD-u0fVaM1IUx
RUN export AWS_ACCESS_KEY_ID=YCAJEvYVZaYhOwWm6rYMs8lpt

ENTRYPOINT ["java", "-jar", "-Daws.accessKeyId=YCAJEvYVZaYhOwWm6rYMs8lp", "-Daws.secretAccessKey=YCOZFOMLNTy62a5AeUhNsopaS0aYD-u0fVaM1IUx", "-Daws.region=ru-central1", "UAD.jar"]