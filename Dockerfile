# Güncel ve çalışan Java 17 image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Tüm dosyaları kopyala
COPY . .

# Maven ile JAR oluştur (testleri atla)
RUN ./mvnw clean package -DskipTests

# Portu aç
EXPOSE 8080

# Uygulamayı çalıştır
CMD ["java", "-jar", "target/librarymanagement-0.0.1-SNAPSHOT.jar"]