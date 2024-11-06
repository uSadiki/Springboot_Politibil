# Politibil API – Introduksjon
Dette prosjektet er et REST-basert API for å administrere og spore politibiler og deres oppdrag. API-et gir brukere muligheten til å hente informasjon om spesifikke politibiler, vise tilgjengelige biler, og oppdatere status og oppdrag for kjøretøyene. Teknologistakken er bygget med Java og Spring Boot, og inkluderer verktøy for enklere objektorientert programmering og testing.



### Teknologier brukt
- Spring Boot
- Lombok
- Spring Data JPA
- H2
- Insomnia (for API testing)

### Funksjonalitet
Politibil API tilbyr følgende funksjonalitet:

- Hente informasjon om en politibil basert på ID
- Hente en liste over tilgjengelige biler
- Oppdatere oppdrag og status for en bil

## API Endpoints

### 1. Hente politibil basert på ID
- **URL:** `/api/politibiler/{id}`
- **Method:** `GET`
- **Response:**
  - HTTP Status: `200 OK`
  - Response Body:
    ```json
	{
    	"id": "1",
    	"merke": "Ford",
    	"modell": "Focus",
    	"årsmodell": 2018,
    	"regNr": "DR 96669",
    	"status": "På vei til hendelse",
    	},
    ```
    
### 2. Hente liste over tilgjengelige politibiler
- **URL:** `/api/politibiler/tilgjengelige`
- **Method:** `GET`
- **Response:**
  - HTTP Status: `200 OK`
  - Response Body:
    ```json
    [
	{
    	"id": "1",
    	"merke": "Ford",
    	"modell": "Focus",
    	"årsmodell": 2018,
    	"regNr": "DR 96669",
    	"status": "Tilgjengelig",
    	"oppdrag": "Trafikkulykke"
    	},

	{
        "id": "2",
    	"merke": "Ford",
    	"modell": "Focus",
    	"årsmodell": 2018,
    	"regNr": "DR 96662",
    	"status": "Tilgjengelig",
    	"oppdrag": "Trafikkulykke"
    	},
    	...
    ]
    ```    
    
### 1. Oppdatere oppdrag og status for en politibil
- **URL:** `/api/politibiler/tildel/{id}`
- **Method:** `PATCH`
- **Request Body:**
  ```json
  {
  "id": 1,
  "oppdrag": "Patruljerer",
  "status": "Aktiv"
  }
  ```
- **Response:**
  - HTTP Status: `200 OK`
  - Response Body:
    ```json
    {
      "id": "1",
    	"merke": "Ford",
    	"modell": "Focus",
    	"årsmodell": 2018,
    	"regNr": "DR 96669",
    	"status": "Aktiv",
    	"oppdrag": "Patruljerer"
    }
    ```



