# Schedulrr - A Modern Scheduling Solution

## Project Overview

**Schedulrr** is a modern scheduling application inspired by Calendly, with additional features for enhanced functionality. It allows users to schedule meetings effortlessly, integrating with **Google Meet** and providing OAuth-based login with **Google** and **GitHub**. The backend is built using **Spring Boot**, and data is managed through **MySQL**.

## Features

- **User Authentication:**
  - OAuth 2.0 integration with Google and GitHub for seamless authentication.

- **Google Meet Integration:**
  - Automatically generates Google Meet links for scheduled meetings using Google Meet API.

- **Scheduling & Availability:**
  - Users can set their availability and manage time slots for appointments.
  - Users can view, edit, or delete scheduled meetings.

- **User Management:**
  - Create, edit, and manage user profiles.
  - Manage user-specific settings for notifications, timezone, and integrations.

- **Email Notifications:**
  - Automatically send email confirmations and reminders for scheduled meetings.

## Tech Stack

- **Backend:**
  - **Spring Boot**: Handles the core backend logic, RESTful APIs, and business logic.
  - **Spring Security + OAuth2**: Provides OAuth-based login via Google and GitHub.
  - **Google Meet API**: Integrated for creating and managing Google Meet links.

- **Database:**
  - **MySQL**: Stores user profiles, meeting data, and availability schedules.

- **API Integrations:**
  - **Google Meet API**: Create and manage video conference links.
  - **OAuth 2.0**: For secure authentication via Google and GitHub.

- **Tools & Libraries:**
  - **JPA/Hibernate**: For database interaction.
  - **Maven**: Project management and dependency management.
  - **Postman**: For API testing and documentation.

## RESTful API Endpoints

| Method | Endpoint                            | Description                                        |
|--------|-------------------------------------|----------------------------------------------------|
| `POST` | `/auth/login`                       | Login via Google or GitHub OAuth.                  |
| `POST` | `/users/register`                   | Register a new user.                               |
| `GET`  | `/users/{userId}/schedule`          | Get user's availability schedule.                  |
| `POST` | `/meetings/schedule`                | Schedule a new meeting with Google Meet.           |
| `GET`  | `/meetings/{meetingId}`             | Retrieve meeting details.                          |
| `DELETE`| `/meetings/{meetingId}`            | Cancel a scheduled meeting.                        |

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/schedulrr.git
   ```
2. Navigate to the project directory:
   ```bash
   cd schedulrr
   ```
3. Update application properties for your MySQL database and Google OAuth credentials.

4. Build the project using Maven:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Future Enhancements

- **Integration with other video conferencing tools** such as Zoom.
- **Advanced scheduling options** like recurring meetings.
- **Mobile-friendly UI** for better accessibility.

---
