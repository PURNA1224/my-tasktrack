# 📌 tasktrack

tasktrack is a personal task management app that helps users stay organized and productive. With this app, users can easily **add**, **update**, **delete**, and **track** the status of their daily tasks all in one place.

To make things even smarter, I integrated **Gemini AI** to automatically generate a summary of pending tasks. With just one click, users can post that summary directly into a **Slack group**, making team updates smooth and effortless.

## 🚀 Features

- Add, update, and delete daily tasks
- Mark tasks as completed or pending
- Auto-generate summary of pending tasks using Gemini AI
- Post task summaries directly to Slack with one click
- Simple and intuitive single-page UI

## 🔧 Tech Stack

- **Spring Boot (Java)** – for building clean and scalable RESTful APIs  
- **React.js** – for a smooth and interactive frontend SPA  
- **Gemini AI** – to generate smart task summaries  
- **Slack API** – to share task summaries with teams  
- **Supabase** – to store user and task data
- **ModelMapper, DTOs, Validation** – for clean code structure and data flow

## 📁 Folder Structure

TodoBackEnd/ --> Spring Boot backend (APIs, services, entities)
Todo_FrontEnd/ --> React.js frontend (components, views, routes)

## 📦 How to Run

### Backend (Spring Boot)
cd backend
mvn spring-boot:run
### Frontend (React)
cd frontend
npm install
npm start

🤖 AI Integration
Gemini AI is used to summarize all pending tasks for the day.

Summary can be posted directly to a Slack group using Slack Webhooks.

📝 License
This project is open-source and free to use.
