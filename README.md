# 📋 Task Tracker Application

A full-stack web app for tracking personal tasks, built using Vite + React (frontend) and Spring Boot (backend), integrated with Supabase for task data storage, Gemini AI for intelligence features, and Slack integration via webhooks.

---

## 📡 API Endpoints (Backend)

The Spring Boot backend exposes the following endpoints:

```http
GET    /todo/getAllTodos                           # Fetch all to-do items
POST   /todo/createTodo                            # Add a new to-do item
DELETE /todo/deleteTodo/${id}                      # Delete a to-do item by ID
POST   /todo/summarize                             # Generate a summary of pending to-dos and send it to Slack
PUT    /todo/update/${id}?isPending=${isPending}   # Update status of the to-do
GET    /todo/getPendingTodos                       # Fetch pending to-do items
POST   /todo/sendMessage", message, { headers: {   # Send message to slack by passing message
              "Content-Type": "text/plain",
           },
        }
```

## 🚀 Features

* Add, update, delete tasks
* AI-powered suggestions (via Gemini API)
* Slack notifications via webhooks
* Persistent task storage
* RESTful API (Spring Boot)
* Clean, responsive UI (React + Vite)

---

## 🛠️ Tech Stack

* **Frontend**: React (Vite), HTML/CSS, Axios
* **Backend**: Spring Boot, REST API
* **Database**: Supabase (PostgreSQL)
* **AI Integration**: Gemini API (via API key)
* **Notifications**: Slack Webhooks
* **Deployment**: Netlify (Frontend), Render (Backend)

---

## 📦 Setup Instructions

### ✅ Clone the Repository

```bash
git clone https://github.com/PURNA1224/my-tasktrack.git
cd my-tasktrack
```

### ✅ Backend Setup (Spring Boot)

```bash
cd TodoBackEnd

# Set environment variables manually (e.g., using export or system settings)
# Example (Linux/macOS):
export GEMINI_API=your_gemini_api_key

# 👉 A demo of these environment variables is included in the `.env.example` file

# Example (Windows CMD):
set GEMINI_API=your_gemini_api_key

./mvnw spring-boot:run
```

### ✅ Frontend Setup (React + Vite)

```bash
cd Todo_FrontEnd

npm install
npm run dev
```

---

## 💬 Slack + Gemini Setup

* **Gemini**: Used for AI enhancements via the `GEMINI_API` and `GEMINI_KEY` environment variable.
* **Slack**: Connected using `SLACK_WEBHOOK_URL` environment variable.
* These environment variables must be set in your system (they are not stored in a `.env` file).

---

## 🧠 Architecture & Design Decisions

* **Supabase** for Postgres DB.
* **Vite + React** for fast development and modern SPA experience.
* **Spring Boot** for scalable and structured backend.
* **Gemini API** to enable AI-driven features.
* **Slack Webhooks** for seamless alerting.
* Manual management of environment variables for flexibility and security.

---

## 🌐 Live Demo (Optional)

[👉 Visit the deployed site](https://my-tasktrack.netlify.app)

> ⚠️ **Note:** The backend server may shut down occasionally since it is hosted on a free tier. Please contact me if you encounter issues accessing the live demo.

---

## 📁 Folder Structure

```
my-tasktrack/
│
├── TodoBackEnd/       # Spring Boot backend
│   ├── src/
│   └── pom.xml
│
├── Todo_FrontEnd/     # React (Vite) frontend
│   ├── src/
│   └── package.json
```

---

## 🧑‍💻 Author

**Kandiboina Purna Sekhar**
* B.Tech in Information Technology
* GitHub: [@PURNA1224](https://github.com/PURNA1224)
