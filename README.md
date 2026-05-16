# SimpleShop — Electronics E-Commerce Application

A full-stack e-commerce web application for buying and managing category-wise electronic devices. Built with a **React** frontend and a **Spring Boot** REST API backend, backed by an **H2** in-memory database.

---

## Project Structure

```
ecom-shop/
├── frontend/        # React + Vite frontend application
└── backend/         # Spring Boot REST API backend
```

---

## Tech Stack

| Layer     | Technology                          |
|-----------|-------------------------------------|
| Frontend  | React 18, Vite, React Router v6, Axios, React Bootstrap, SASS |
| Backend   | Spring Boot 4.0.6, Spring Data JPA, Lombok |
| Database  | H2 (in-memory)                      |
| Language  | JavaScript (Frontend), Java 17 (Backend) |

---

## Features

- Browse products by category: **Laptop, Headphone, Mobile, Electronics, Toys, Fashion**
- Live product search with dropdown suggestions
- View detailed product page with image
- Add new products with image upload
- Update existing product details and image
- Delete products
- Shopping cart
- Checkout popup
- Dark / Light theme toggle (persisted in localStorage)
- Responsive layout (Bootstrap)

---

## Folder Details

### `frontend/` — React Application

```
frontend/
├── index.html
├── vite.config.js
├── package.json
└── src/
    ├── main.jsx              # App entry point
    ├── App.jsx               # Route definitions
    ├── axios.jsx             # Axios base config
    ├── Context/
    │   └── Context.jsx       # Global state (cart, theme)
    └── components/
        ├── Navbar.jsx        # Navigation, search, categories, theme toggle
        ├── Home.jsx          # Product listing with category filter
        ├── Product.jsx       # Individual product detail
        ├── Cart.jsx          # Shopping cart page
        ├── AddProduct.jsx    # Add product form
        ├── UpdateProduct.jsx # Edit product form
        └── CheckoutPopup.jsx # Checkout modal
```

**Frontend talks to the backend at:** `http://localhost:8083`

---

### `backend/` — Spring Boot Application

```
backend/
├── pom.xml
└── src/main/
    ├── java/com/project/simpleshop/
    │   ├── SimpleshopApplication.java   # Main entry point
    │   ├── controller/
    │   │   └── ProductController.java   # REST endpoints
    │   ├── service/
    │   │   └── ProductService.java      # Business logic
    │   ├── repository/
    │   │   └── ProductRepository.java   # JPA repository
    │   └── model/
    │       └── Product.java             # Product entity
    └── resources/
        └── application.properties       # App config
```

**REST API Base URL:** `http://localhost:8083/api`

| Method | Endpoint                         | Description              |
|--------|----------------------------------|--------------------------|
| GET    | `/products`                      | Get all products         |
| GET    | `/product/{id}`                  | Get product by ID        |
| GET    | `/product/{id}/image`            | Get product image        |
| GET    | `/products/search?keyword={kw}`  | Search products          |
| POST   | `/product`                       | Add new product          |
| PUT    | `/product/{id}`                  | Update product           |
| DELETE | `/product/{id}`                  | Delete product           |

---

## Prerequisites

| Tool        | Version  |
|-------------|----------|
| Java JDK    | 17+      |
| Maven       | 3.8+     |
| Node.js     | 18+      |
| npm         | 9+       |

---

## How to Run

### 1. Start the Backend

```bash
cd backend

# On Linux/macOS
./mvnw spring-boot:run

# On Windows
mvnw.cmd spring-boot:run
```

The backend starts on **http://localhost:8083**.

H2 Console (in-browser DB viewer) is available at:  
**http://localhost:8083/h2-console**  
JDBC URL: `jdbc:h2:mem:simpleshop`

---

### 2. Start the Frontend

Open a new terminal window:

```bash
cd frontend

# Install dependencies (first time only)
npm install

# Start the development server
npm run dev
```

The app opens at **http://localhost:5173**.

> Make sure the backend is running before starting the frontend.

---

## Build for Production

### Frontend

```bash
cd frontend
npm run build
```

Output is generated in `frontend/dist/`.

### Backend

```bash
cd backend
./mvnw clean package
java -jar target/simpleshop-0.0.1-SNAPSHOT.jar
```

---

## Notes

- The H2 database is **in-memory** — all data resets on every backend restart.
- Product images are stored as binary data (BLOB) in the database.
- CORS is enabled globally in the backend (`@CrossOrigin`), allowing the React dev server to call the API.
- The default backend port is `8083`. If you change it, update the Axios base URL in `frontend/src/axios.jsx` and `frontend/src/components/Navbar.jsx`.
