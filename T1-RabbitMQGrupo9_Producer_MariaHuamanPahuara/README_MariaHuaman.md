# T1 Tipo D (RabbitMQ Producer) — Grupo 9 · Maria Huaman Pahuara

Microservicio productor de la parte "Sincronización usando RabbitMQ": expone
`GET /api/fibonacci/send?numbers=1;2;15;8` y publica el mensaje en
`Grupo9Exchange` → `Grupo9Queue` con routing `Grupo9Routing`.
Responde `Lista enviada a RabbitMQ correctamente.`

| Carpeta | Qué es | Puerto |
|---|---|---|
| `T1-RabbitMQGrupo9_Producer_MariaHuamanPahuara` | Productor RabbitMQ | 8082 |

Versiones: **Spring Boot 4.1.1 · Spring Cloud 2025.1.3 · Java 25** (fijadas en el `pom.xml`).

## 1. Requisitos

- **JDK 25** (`java -version` debe decir 25).
- **IntelliJ IDEA** (Community basta). Al abrir: `File → Project Structure → SDK` = JDK 25.
- **Docker** (Desktop en Windows/Mac, servicio en Linux). Puertos libres: 5672, 15672, 8082.
- Maven solo si corres por consola (`mvn -version`); con el ▶ de IntelliJ no hace falta.

## 2. Levantar RabbitMQ

Desde esta carpeta (`T1-RabbitMQGrupo9_Producer_MariaHuamanPahuara/`):

```bash
docker compose up -d
```

Panel: http://localhost:15672 (guest / guest). Apagar: `docker compose down`.

> Credenciales: solo RabbitMQ usa `guest` / `guest` (ver `application.yml` y panel web).

## 3. Importar y correr

`File → Open…` → carpeta `T1-RabbitMQGrupo9_Producer_MariaHuamanPahuara` → `Trust Project`.
Correr `AppGrupo9ProductorApplication.java` con el ▶ verde (recomendado).

Por consola:

Windows (PowerShell/CMD, requiere Maven):

```powershell
cd T1-RabbitMQGrupo9_Producer_MariaHuamanPahuara
mvn spring-boot:run
```

Linux o Mac (requiere Maven):

```bash
cd T1-RabbitMQGrupo9_Producer_MariaHuamanPahuara
mvn spring-boot:run
```

## 4. Probar

Windows (`curl.exe`, no `curl` a secas por el alias de PowerShell):

```powershell
curl.exe "http://localhost:8082/api/fibonacci/send?numbers=1;2;15;8"
```

Linux o Mac:

```bash
curl "http://localhost:8082/api/fibonacci/send?numbers=1;2;15;8"
```

Respuesta esperada:

```text
Lista enviada a RabbitMQ correctamente.
```

El consumidor (8083) lo recibe e imprime `[1, 2, 15, 8] → [1, 1, 610, 21]` tras ~20s.
