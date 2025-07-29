# Accessory Store Backend

This is the backend for an e-commerce accessory store, built using **Spring Boot**, deployed via **Railway**, using **TiDB Cloud** as the database, and storing images on **Cloudinary**.

---

## 🚀 Live URLs

- **Frontend URL**: [https://cloudimage.onrender.com/](https://cloudimage.onrender.com/)
- **Backend API**: [https://cloudimage-production.up.railway.app/](https://cloudimage-production.up.railway.app/)
- **Database (TiDB Cloud)**: [https://tidbcloud.com/](https://tidbcloud.com/)
- **Image Hosting (Cloudinary)**: [https://cloudinary.com/](https://cloudinary.com/)

---

## 🧰 Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **TiDB Cloud (MySQL-compatible)**
- **Cloudinary for Image Uploads**
- **Railway for Backend Deployment**
- **Render for Frontend Hosting**
- **Maven Web Project**

---

## ⚙️ Dependencies Used

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `mysql-connector-j` (compatible with TiDB)
- `cloudinary` Java SDK (for image upload)
- `spring-boot-starter-validation`
- `spring-boot-devtools` (optional)

---

## 🔐 Cloudinary Setup

### 🔹 Steps to Integrate Cloudinary:

1. Go to [https://cloudinary.com/](https://cloudinary.com/) and create an account.
2. After login, go to **Dashboard** and copy:
   - `Cloud name`
   - `API Key`
   - `API Secret`
3. In your Spring Boot project, create a Cloudinary config class:

```java
@Configuration
public class CloudinaryConfig {

    @Value("${cloudinary.cloud-name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", cloudName,
            "api_key", apiKey,
            "api_secret", apiSecret
        ));
    }

public String uploadImage(MultipartFile file) {
        try {
            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return result.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed: " + e.getMessage());
        }
    }
}
  
