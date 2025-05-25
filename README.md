# 📋 Task Tracker Application

tasktrack is a personal task management app that helps users stay organized and productive. With this app, users can easily **add**, **update**, **delete**, and **track** the status of their daily tasks all in one place.

To make things even smarter, I integrated **Gemini AI** to automatically generate a summary of pending tasks. With just one click, users can post that summary directly into a **Slack group**, making team updates smooth and effortless.

---

## 🚀 Features

* Add, update, delete tasks
* User authentication (via Supabase)
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
* **Auth**: Supabase Auth
* **AI Integration**: Gemini API (via API key)
* **Notifications**: Slack Webhooks
* **Deployment**: Vercel (Frontend), Render/Heroku (Backend)

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
export GEMINI_API_KEY=your_gemini_api_key
export SLACK_WEBHOOK_URL=your_slack_webhook_url
export 

# Example (Windows CMD):
set GEMINI_API_KEY=your_gemini_api_key
set SLACK_WEBHOOK_URL=your_slack_webhook_url

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

* **Gemini**: Used for AI enhancements via environment variable `GEMINI_API_KEY` (set in the system, not in a `.env` file).
* **Slack**: Connected using Slack Incoming Webhooks.

---

## 🧠 Architecture & Design Decisions

* **Supabase** for Postgres DB.
* **Vite + React** for fast development and modern SPA experience.
* **Spring Boot** for scalable and structured backend.
* **Gemini API** to enable AI-driven features.
* **Slack Webhooks** for seamless alerting.
* Manual management of environment variables for flexibility and security.

---

## 🌐 Live Demo

[👉 Visit the deployed site](https://my-tasktrack.netlify.app/)

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
B.Tech in Information Technology
GitHub: [@PURNA1224](https://github.com/PURNA1224)
