# Use the official OpenJDK 11 image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /opt/app

# Copy far file from local to container
ARG JAR_FILE=build/libs/telegram-bot-0.1.0-SNAPSHOT.jar
COPY ${JAR_FILE} telegram_bot.jar

# Expose port 8077 for the application
EXPOSE 8077

# Set the environment variables for connecting to PostgreSQL and RabbitMQ services
ENV BOT_NAME=test_learn_montenegrin_bot
ENV BOT_TOKEN=6083140824:AAGKfJJUjbflLJcK4d0QemXS5j-715Ne7PA
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/telegram_bot
ENV SPRING_DATASOURCE_USERNAME=telegram_bot
ENV SPRING_DATASOURCE_PASSWORD=p123
ENV SPRING_RABBITMQ_HOST=rabbitmq
ENV SPRING_RABBITMQ_PORT=5672
ENV SPRING_RABBITMQ_USERNAME=telegram_bot
ENV SPRING_RABBITMQ_PASSWORD=r123
ENV SPRING_RABBITMQ_VIRTUAL_HOST=/

# Run the application
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "telegram_bot.jar", "--server.port=8077"]
